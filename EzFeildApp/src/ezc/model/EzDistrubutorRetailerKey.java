package ezc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EzDistrubutorRetailerKey
 *
 */
@Embeddable

public class EzDistrubutorRetailerKey implements Serializable {

	@Column(name = "EDR_DISTRUBUTOR_ID", length = 10)
	private String distrubutorId;

	@Column(name = "EDR_RETAILER_ID", length = 10)
	private int retailerId;
	private static final long serialVersionUID = 1L;

	public EzDistrubutorRetailerKey() {
		super();
	}
	@Override
	public int hashCode() {
		return distrubutorId.hashCode() + retailerId;
	}

	public String getDistrubutorId() {
		return distrubutorId;
	}
	public void setDistrubutorId(String distrubutorId) {
		this.distrubutorId = distrubutorId;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof EzDistrubutorRetailerKey)
				&& this.distrubutorId.equals(((EzDistrubutorRetailerKey) obj)
						.getDistrubutorId()) && (this.retailerId == ((EzDistrubutorRetailerKey) obj)
					.getRetailerId()));
	}
}
