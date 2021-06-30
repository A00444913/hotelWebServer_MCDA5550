package com.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.hotel.bean.Gender;
import com.hotel.bean.Guest;
import com.hotel.bean.Reservation;
import com.hotel.repository.ReservationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ReservationRepositoryTests {
	
	@Autowired
	private ReservationRepository Repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void testCreateGuest() {
		Guest guest1 = new Guest("AK",25,Gender.FEMALE);
		Guest guest2 = new Guest("Rikiiiiy",28,Gender.MALE);
		Guest guest3 = new Guest("Jinting",25,Gender.NONIDENTIFIED);
		
		entityManager.persist(guest1);
		entityManager.persist(guest2);
		entityManager.persist(guest3);
		
	}
	
	@Test
	public void testCreateNewReservationWithOneGuest() {
		Guest guest1 = entityManager.find(Guest.class,1);
		Reservation reserv1 = new Reservation("Season Inn","20210607","20210609");
		reserv1.addGuest(guest1);
		
		Repo.save(reserv1);
		//reservRepo.save(reserv1);
	}
	
	@Test
	public void testCreateNewReservationWithTwoGuests() {
		Guest guest1 = entityManager.find(Guest.class,1);
		Guest guest2 = entityManager.find(Guest.class,2);
		Reservation reserv1 = new Reservation("Comfort Inn","20210629","20210720");
		
		reserv1.addGuest(guest1);
		reserv1.addGuest(guest2);
		
		Repo.save(reserv1);
	}
	
	

}
