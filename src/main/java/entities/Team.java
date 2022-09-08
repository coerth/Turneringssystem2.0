package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @OneToMany(mappedBy = "team")
    private Set<TournamentHasTeam> tournamentHasTeams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<MatchHasTeam> matchHasTeams = new LinkedHashSet<>();

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

    public Set<TournamentHasTeam> getTournamentHasTeams() {
        return tournamentHasTeams;
    }

    public void setTournamentHasTeams(Set<TournamentHasTeam> tournamentHasTeams) {
        this.tournamentHasTeams = tournamentHasTeams;
    }

    public Set<MatchHasTeam> getMatchHasTeams() {
        return matchHasTeams;
    }

    public void setMatchHasTeams(Set<MatchHasTeam> matchHasTeams) {
        this.matchHasTeams = matchHasTeams;
    }

}