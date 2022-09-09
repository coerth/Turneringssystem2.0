package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "`Match`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToMany
    @JoinTable(name = "Match_has_Team",
            joinColumns = @JoinColumn(name = "Match_id"),
            inverseJoinColumns = @JoinColumn(name = "Team_id"))
    private Set<Team> teams = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }


    public Match() {
    }

    public Match(LocalDate date, Tournament tournament) {
        this.date = date;
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date=" + date +
                ", tournament=" + tournament +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return id.equals(match.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}