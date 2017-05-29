package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzBeatDistrubutor
 *
 */
@Entity
@Table(name = "EZC_BEAT_DISTRUBUTOR")
public class EzBeatDistrubutor implements Serializable {

	@EmbeddedId
	private EzBeatDistrubutorKey ezBeatDistrubutorKey;
	private static final long serialVersionUID = 1L;

	public EzBeatDistrubutor() {
		super();
	}
	
	public EzBeatDistrubutorKey getEzBeatDistrubutorKey() {
		return ezBeatDistrubutorKey;
	}

	public void setEzBeatDistrubutorKey(EzBeatDistrubutorKey ezBeatDistrubutorKey) {
		this.ezBeatDistrubutorKey = ezBeatDistrubutorKey;
	}


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EBD_BEAT_ID", referencedColumnName = "EB_BEAT_ID", insertable = false, updatable = false)
	private EzBeat ezBeatBD;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EBD_DISTRUBUTOR_ID", referencedColumnName = "ED_DISTRUBUTOR_ID", insertable = false, updatable = false)
	private EzDistrubutor ezDistrubutorBD;

	public EzBeat getEzBeatBD() {
		return ezBeatBD;
	}

	public void setEzBeatBD(EzBeat ezBeatBD) {
		this.ezBeatBD = ezBeatBD;
	}

	public EzDistrubutor getEzDistrubutorBD() {
		return ezDistrubutorBD;
	}

	public void setEzDistrubutorBD(EzDistrubutor ezDistrubutorBD) {
		this.ezDistrubutorBD = ezDistrubutorBD;
	}

	
	
}
