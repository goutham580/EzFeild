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
@Table(name = "EZC_BEAT")
public class EzBeat {

	@Id
	@Column(name = "EB_BEAT_ID", length = 10)
	private int beatId;

	@Column(name = "EB_NAME", length = 40)
	private String firstName;
	
	@Column(name = "EB_LAST_NAME", length = 40)
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(mappedBy = "ezBeat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EzUserBeat> ezUserBeat;
	
	@OneToMany(mappedBy = "ezBeat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EzBeatDistrubutor> ezBeatDistrubutor;

	public int getBeatId() {
		return beatId;
	}

	public void setBeatId(int beatId) {
		this.beatId = beatId;
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

	public List<EzBeatDistrubutor> getEzBeatDistrubutor() {
		return ezBeatDistrubutor;
	}

	public void setEzBeatDistrubutor(List<EzBeatDistrubutor> ezBeatDistrubutor) {
		this.ezBeatDistrubutor = ezBeatDistrubutor;
	}
	
}