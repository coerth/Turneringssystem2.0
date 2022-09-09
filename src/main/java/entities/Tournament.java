package entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "game_type", length = 45)
    private String gameType;

    @ManyToMany
    @JoinTable(name = "Tournament_has_Team",
            joinColumns = @JoinColumn(name = "Tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "Team_id"))
    private Set<Team> teams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tournament")
    private Set<Match> matches = new LinkedHashSet<>();

    @Column(name = "created")
    private Instant created;

    @Column(name = "updated")
    private Instant updated;

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Tournament() {
    }

    public Tournament(String name, LocalDate registrationDate, String gameType) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.gameType = gameType;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", gameType='" + gameType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
