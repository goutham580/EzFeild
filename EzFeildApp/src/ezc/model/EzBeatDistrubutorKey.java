package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzBeatDistrubutorKey
 *
 */
@Embeddable

public class EzBeatDistrubutorKey implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public EzBeatDistrubutorKey() {
		super();
	}
	@Column(name = "EBD_BEAT_ID", length = 10)
	private int beatId;

	@Column(name = "EBD_DISTRUBUTOR_ID", length = 10)
	private int distrubutorId;
	
	
	public int getBeatId() {
		return beatId;
	}

	public void setBeatId(int beatId) {
		this.beatId = beatId;
	}

	public int getDistrubutorId() {
		return distrubutorId;
	}

	public void setDistrubutorId(int distrubutorId) {
		this.distrubutorId = distrubutorId;
	}

	@Override
	public int hashCode() {
		return beatId + distrubutorId;
	}

	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof EzBeatDistrubutorKey)
				&& (this.distrubutorId == ((EzBeatDistrubutorKey) obj)
					.getDistrubutorId()));
	}
}
