package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzDistrubustorRetailer
 *
 */
@Entity
@Table(name = "EZC_DISTRUBUTOR_RETAILER")
public class EzDistrubutorRetailer implements Serializable {

	@EmbeddedId
	private EzDistrubutorRetailerKey ezDistrubutorRetailerKey;
	
	private static final long serialVersionUID = 1L;

	public EzDistrubutorRetailer() {
		super();
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EDR_DISTRUBUTOR_ID", referencedColumnName = "ED_DISTRUBUTOR_ID", insertable = false, updatable = false)
	private EzDistrubutor ezDistrubutorDR;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EDR_RETAILER_ID", referencedColumnName = "ER_RETAILER_ID", insertable = false, updatable = false)
	private EzRetailer ezRetailerDR;

	public EzDistrubutorRetailerKey getEzDistrubutorRetailerKey() {
		return ezDistrubutorRetailerKey;
	}


	public void setEzDistrubutorRetailerKey(EzDistrubutorRetailerKey ezDistrubutorRetailerKey) {
		this.ezDistrubutorRetailerKey = ezDistrubutorRetailerKey;
	}


	public EzDistrubutor getEzDistrubutorDR() {
		return ezDistrubutorDR;
	}


	public void setEzDistrubutorDR(EzDistrubutor ezDistrubutorDR) {
		this.ezDistrubutorDR = ezDistrubutorDR;
	}


	public EzRetailer getEzRetailerDR() {
		return ezRetailerDR;
	}


	public void setEzRetailerDR(EzRetailer ezRetailerDR) {
		this.ezRetailerDR = ezRetailerDR;
	}
	
	
}
