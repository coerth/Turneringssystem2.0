package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
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

    @OneToMany(mappedBy = "match")
    private Set<MatchHasTeam> matchHasTeams = new LinkedHashSet<>();

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

    public Set<MatchHasTeam> getMatchHasTeams() {
        return matchHasTeams;
    }

    public void setMatchHasTeams(Set<MatchHasTeam> matchHasTeams) {
        this.matchHasTeams = matchHasTeams;
    }

}