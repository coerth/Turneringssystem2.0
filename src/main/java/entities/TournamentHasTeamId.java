package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TournamentHasTeamId implements Serializable {
    private static final long serialVersionUID = -4208072840838776446L;
    @Column(name = "Tournament_id", nullable = false)
    private Integer tournamentId;

    @Column(name = "Team_id", nullable = false)
    private Integer teamId;

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentHasTeamId entity = (TournamentHasTeamId) o;
        return Objects.equals(this.tournamentId, entity.tournamentId) &&
                Objects.equals(this.teamId, entity.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournamentId, teamId);
    }

}