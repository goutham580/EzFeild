package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzUserBeat
 *
 */
@Entity

public class EzUserBeat implements Serializable {

	@EmbeddedId
	private EzUserBeatKey ezUserBeatKey;
	
	private static final long serialVersionUID = 1L;

	public EzUserBeatKey getEzUserBeatKey() {
		return ezUserBeatKey;
	}

	public void setEzUserBeatKey(EzUserBeatKey ezUserBeatKey) {
		this.ezUserBeatKey = ezUserBeatKey;
	}

	public EzUser getEzUser() {
		return ezUser;
	}

	public void setEzUser(EzUser ezUser) {
		this.ezUser = ezUser;
	}

	public EzBeat getEzBeat() {
		return ezBeat;
	}

	public void setEzBeat(EzBeat ezBeat) {
		this.ezBeat = ezBeat;
	}

	public EzUserBeat() {
		super();
	}
   
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EUB_USER_ID", referencedColumnName = "EU_USER_ID", insertable = false, updatable = false)
	private EzUser ezUser;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EUB_BEAT_ID", referencedColumnName = "EB_BEAT_ID", insertable = false, updatable = false)
	private EzBeat ezBeat;
	
}
