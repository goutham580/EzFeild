package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzUserBeat
 *
 */
@Entity
@Table(name = "EZC_USER_BEAT")
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

	public EzUserBeat() {
		super();
	}
   
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EUB_USER_ID", referencedColumnName = "EU_USER_ID", insertable = false, updatable = false)
	private EzUser ezUserUB;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EUB_BEAT_ID", referencedColumnName = "EB_BEAT_ID", insertable = false, updatable = false)
	private EzBeat ezBeatUB;

	public EzUser getEzUserUB() {
		return ezUserUB;
	}

	public void setEzUserUB(EzUser ezUserUB) {
		this.ezUserUB = ezUserUB;
	}

	public EzBeat getEzBeatUB() {
		return ezBeatUB;
	}

	public void setEzBeatUB(EzBeat ezBeatUB) {
		this.ezBeatUB = ezBeatUB;
	}
	
}
