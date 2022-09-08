package entities;

import javax.persistence.*;

@Entity
@Table(name = "Match_has_Team")
public class MatchHasTeam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private MatchHasTeamId id;

    @MapsId("matchId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Match_id", nullable = false)
    private Match match;

    @MapsId("teamId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Team_id", nullable = false)
    private Team team;

    public MatchHasTeamId getId() {
        return id;
    }

    public void setId(MatchHasTeamId id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}