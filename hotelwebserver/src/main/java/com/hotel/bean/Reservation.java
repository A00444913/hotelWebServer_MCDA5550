package com.hotel.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 25,nullable = false)
	private String hotel_name;
	
	@Column(length = 25,nullable = false)
	private String checkin;
	
	@Column(length = 25,nullable = false)
	private String checkout;
	
	
	
	public Reservation(String hotel_name, String checkin, String checkout) {
		super();
		this.hotel_name = hotel_name;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@ManyToMany
	@JoinTable(
			name = "reservation_guest",
			joinColumns = @JoinColumn(name = "reservation_id"),
			inverseJoinColumns = @JoinColumn(name = "guest_id")
			)
	private Set<Guest> guests_list = new HashSet<>();


	public Set<Guest> getGuests_list() {
		return guests_list;
	}

	public void setGuests_list(Set<Guest> guests_list) {
		this.guests_list = guests_list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	public void addGuest(Guest guest) {
		this.guests_list.add(guest);
	}


}
