package com.hotelwebserver.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelwebserver.entity.Guest;
import com.hotelwebserver.entity.HotelDetails;
import com.hotelwebserver.entity.ReservationDetails;

@RestController
public class HotelController {
	
	@RequestMapping("/hello")
	public String sayhi() {
		return "hi";
	}
	
	@RequestMapping("/bye")
	public String saybye() {
		return "bye";
	}
	
	@RequestMapping("/hotelslist")
	public List<HotelDetails> getHotelsList() {
		return getListOfHotels();
		
	}
	
	public List<HotelDetails> getListOfHotels(){
		List<HotelDetails> hotelsList = new ArrayList<HotelDetails>();
		List<String> hotelNames = Arrays.asList("Season Inn","Holiday Inn","The Grand Hotel","Comfort Inn");
		Random random = new Random();
		for(int i=0;i<hotelNames.size();i++) {
			HotelDetails hoteldetails = new HotelDetails();
			hoteldetails.setHotel_name(hotelNames.get(i));
			hoteldetails.setAvailability(true);
			
			int randomPrice = random.nextInt(300 - 50 +1)+50;
			hoteldetails.setPrice(randomPrice);
			hotelsList.add(hoteldetails);
			
			hoteldetails = null; //garbage collector
		}
		
		return hotelsList;
	}
	
	@RequestMapping("/getBookings")
	public String getBookings(@RequestParam(value = "name",defaultValue = "CozyHotel") String name) {
		return "Hi";
	}
	
	@RequestMapping(value= "/reservation",method=RequestMethod.POST,consumes="application/json")
	public List<Guest> reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		return reservationDetails.getGuests_list();
	}


}
