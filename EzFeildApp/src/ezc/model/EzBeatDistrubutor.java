package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzBeatDistrubutor
 *
 */
@Entity

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

	public EzBeat getEzBeat() {
		return ezBeat;
	}

	public void setEzBeat(EzBeat ezBeat) {
		this.ezBeat = ezBeat;
	}

	public EzDistrubutor getEzDistrubutor() {
		return ezDistrubutor;
	}

	public void setEzDistrubutor(EzDistrubutor ezDistrubutor) {
		this.ezDistrubutor = ezDistrubutor;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EBD_BEAT_ID", referencedColumnName = "EB_BEAT_ID", insertable = false, updatable = false)
	private EzBeat ezBeat;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EBD_DISTRUBUTOR_ID", referencedColumnName = "ED_DISTRUBUTOR_ID", insertable = false, updatable = false)
	private EzDistrubutor ezDistrubutor;
	
	
}
