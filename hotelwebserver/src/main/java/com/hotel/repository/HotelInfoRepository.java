package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hotel.bean.HotelInfo;



public interface HotelInfoRepository extends CrudRepository<HotelInfo,Integer> {
	
	@Query(value ="select * from hoteldetails", nativeQuery =true)
	List<HotelInfo> findAllHotel();
}
