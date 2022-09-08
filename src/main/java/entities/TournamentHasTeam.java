package entities;

import javax.persistence.*;

@Entity
@Table(name = "Tournament_has_Team")
public class TournamentHasTeam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private TournamentHasTeamId id;

    @MapsId("tournamentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Tournament_id", nullable = false)
    private Tournament tournament;

    @MapsId("teamId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Team_id", nullable = false)
    private Team team;

    public TournamentHasTeamId getId() {
        return id;
    }

    public void setId(TournamentHasTeamId id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}