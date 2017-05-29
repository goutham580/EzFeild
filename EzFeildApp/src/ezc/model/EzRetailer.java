package ezc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzRetailer
 *
 */
@Entity
@Table(name = "EZC_RETAILER")
public class EzRetailer implements Serializable {

	@Id
	@Column(name = "ER_RETAILER_ID", length = 10)
	private int distrubutorId;
	
	@Column(name = "ER_RETAILER_NAME", length = 40)
	private String distName;
	
	@OneToMany(mappedBy = "ezRetailerDR", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EzDistrubutorRetailer> ezDistrubutorRetailer;

	private static final long serialVersionUID = 1L;
	
	public EzRetailer() {
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

	public List<EzDistrubutorRetailer> getEzDistrubutorRetailer() {
		return ezDistrubutorRetailer;
	}

	public void setEzDistrubutorRetailer(List<EzDistrubutorRetailer> ezDistrubutorRetailer) {
		this.ezDistrubutorRetailer = ezDistrubutorRetailer;
	}
   
}
