package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bean.Guest;
import com.hotel.bean.HotelInfo;
import com.hotel.repository.GuestRepository;
import com.hotel.utils.ResultMsg;
import com.hotel.utils.ResultStatusCode;

@RestController
public class GuestController {
	
	@Autowired
	private GuestRepository guestRepository;
	
	
	@Modifying
	@RequestMapping(value="/addguest",method=RequestMethod.POST,consumes="application/json")
	public Object addUser(@RequestBody Guest guestEntity)
	{
		guestRepository.save(guestEntity);
		ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), guestEntity);
		return resultMsg;
		//return guestEntity.getGuest_id();
	}

}
