package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatchHasTeamId implements Serializable {
    private static final long serialVersionUID = -8668315064824231041L;
    @Column(name = "Match_id", nullable = false)
    private Integer matchId;

    @Column(name = "Team_id", nullable = false)
    private Integer teamId;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
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
        MatchHasTeamId entity = (MatchHasTeamId) o;
        return Objects.equals(this.teamId, entity.teamId) &&
                Objects.equals(this.matchId, entity.matchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, matchId);
    }

}