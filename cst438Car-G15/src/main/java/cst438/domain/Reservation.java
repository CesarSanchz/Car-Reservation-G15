package cst438.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="reservations")

public class Reservation {
	
	@Id
	@Column(name = "rid")
	private int rid;
	
	//@Column(name = "car_id")
	//private int car_id;
	
	@ManyToOne
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	private Car car_id;
	
	@NotNull
	@Size(min= 3, max=45)
	private String email;
	
	public Reservation () {
	}

	public Reservation(Car car_id, @NotNull @Size(min = 3, max = 45) String email) {
		super();
		this.car_id = car_id;
		this.email = email;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Car getCar_id() {
		return car_id;
	}

	public void setCar_id(Car car_id) {
		this.car_id = car_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (car_id == null) {
			if (other.car_id != null)
				return false;
		} else if (!car_id.equals(other.car_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (rid != other.rid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [rid=" + rid + ", car_id=" + car_id + ", email=" + email + "]";
	}

	
	
	
}
