package com.hotel.controller;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bean.Confirmation;
import com.hotel.bean.Gender;
import com.hotel.bean.Guest;
import com.hotel.bean.Reservation;
import com.hotel.repository.GuestRepository;
import com.hotel.repository.ReservationRepository;

@RestController
public class ReservationController {
	
	@Autowired
	private ReservationRepository reserRepo;
	@Autowired
	private GuestRepository guestRepo;
	

	
	@RequestMapping(value="/reservation",method=RequestMethod.POST,consumes="application/json")
	public Confirmation reservation(@RequestBody Reservation reservationEntity) {
		String hotel_name = reservationEntity.getHotel_name();
		String checkin = reservationEntity.getCheckin();
		String checkout = reservationEntity.getCheckout();
		
		Reservation reserv1 = new Reservation(hotel_name,checkin,checkout);
		
		Set<Guest> guests = reservationEntity.getGuests_list();
		
		//String test ="";
		
		for(Guest guest: guests) {
			String name = guest.getGuest_name();
			int age = guest.getAge();
			Gender gender = guest.getGender();
			
			Guest guest1 = new Guest(name,age,gender);
			guestRepo.save(guest1);
			
			//test = test + guest1.getId();
			
			reserv1.addGuest(guest1);
		}
		
		reserRepo.save(reserv1);
		
		Confirmation confirmation = new Confirmation();
		confirmation.setConfirmation_number(reserv1.getId().toString());
		
		
		return confirmation;
		//return test;
		
		
		
	}

}
