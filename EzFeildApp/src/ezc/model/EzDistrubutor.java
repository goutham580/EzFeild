package ezc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzDistrubutor
 *
 */
@Entity
@Table(name = "EZC_DISTRUBUTOR")
public class EzDistrubutor implements Serializable {

	@Id
	@Column(name = "ED_DISTRUBUTOR_ID", length = 10)
	private int distrubutorId;
	
	@Column(name = "ED_DISTRUBUTOR_NAME", length = 40)
	private String distName;
	
	@OneToMany(mappedBy = "ezDistrubutorBD", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EzBeatDistrubutor> ezBeatDistrubutor;
	
	@OneToMany(mappedBy = "ezRetailerDR", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EzDistrubutorRetailer> ezDistrubutorRetailer;
	
	private static final long serialVersionUID = 1L;

	public EzDistrubutor() {
		super();
	}

	public int getDistrubutorId() {
		return distrubutorId;
	}

	public void setDistrubutorId(int distrubutorId) {
		this.distrubutorId = distrubutorId;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public List<EzBeatDistrubutor> getEzBeatDistrubutor() {
		return ezBeatDistrubutor;
	}

	public void setEzBeatDistrubutor(List<EzBeatDistrubutor> ezBeatDistrubutor) {
		this.ezBeatDistrubutor = ezBeatDistrubutor;
	}
   
}
