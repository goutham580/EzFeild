package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzUserBeatKey
 *
 */
@Embeddable

public class EzUserBeatKey implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public EzUserBeatKey() {
		super();
	}
	@Column(name = "EUB_USER_ID", length = 10)
	private String userId;

	@Column(name = "EUB_BEAT_ID", length = 10)
	private int beatId;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBeatId() {
		return beatId;
	}

	public void setBeatId(int beatId) {
		this.beatId = beatId;
	}

	@Override
	public int hashCode() {
		return userId.hashCode() + beatId;
	}

	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof EzUserBeatKey)
				&& this.userId.equals(((EzUserBeatKey) obj)
						.getUserId()) && (this.beatId == ((EzUserBeatKey) obj)
					.getBeatId()));
	}
}
