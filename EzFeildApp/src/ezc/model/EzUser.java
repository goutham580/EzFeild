package ezc.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EZC_USER")
public class EzUser {

	@Id
	@Column(name = "EU_USER_ID", length = 10)
	private String userId;

	@Column(name = "EU_FIRST_NAME", length = 40)
	private String firstName;

	@OneToMany(mappedBy = "ezUserUB", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EzUserBeat> ezUserBeat;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<EzUserBeat> getEzUserBeat() {
		return ezUserBeat;
	}

	public void setEzUserBeat(List<EzUserBeat> ezUserBeat) {
		this.ezUserBeat = ezUserBeat;
	}
	
	
}