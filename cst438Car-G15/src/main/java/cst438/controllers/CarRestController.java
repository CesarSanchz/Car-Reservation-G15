package cst438.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cst438.domain.*;
import cst438.repositories.ReservationRepository;
import cst438.services.*;

@RestController
@RequestMapping("/api")
public class CarRestController {
	
	@Autowired
	CarService carService;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	// Car APIs
	
	@GetMapping("/getAllCars")
	public List<Car> getAllCars() {
		List<Car> cars = carService.getAllCars();
		return cars;
		
	}
	
	@GetMapping("/getCarById")
	  public Car getCarById(@RequestParam("id") int id) {
	    Car cars = carService.getCarById(id);
	    return cars;
	  }
	
	@GetMapping("/getCarByCity")
	  public List<Car> getCarByCity(@RequestParam("city") String city) {
	    List<Car> cars = carService.getCarByCity(city);
	    return cars;
	  }
	
	// Reservation APIs
	// Section for reservation Details
	
	@PostMapping("/reserve")
	public Reservation addReservation(@RequestParam("car_id")int car_id, @RequestParam("email") String email) {
		System.out.println("Attempting to reserve " + car_id + " for " + email);
		
		Reservation reservation = carService.makeReservation(car_id, email);
		
		return reservation;
				
	}
	
	@GetMapping("/getReservation")
	  public List<Reservation> getReservation() {
	    List<Reservation> reservation = carService.getReservation();
	    return reservation;
	  }
	
	@GetMapping("/getReservationEmail")
	public List<Reservation> getReservationEmail(String email){
		List<Reservation> reservation = carService.findEmails(email);
		return reservation;
	}
	
	
	@GetMapping("/getReservation/id")
	  public List<Reservation> getReservationId(@RequestParam("rid") int rid) {
	    List<Reservation> reservation = carService.getReservationById(rid);
	    return reservation;
	  }
	
	
	
	@DeleteMapping("/getReservation/id")
	public ResponseEntity<Reservation> deleteReservation(@RequestParam("rid") int rid ) {
		List<Reservation> reservation = reservationRepository.findById(rid);
		
		if ( reservation.size()==0) {
			// reservation ID not found.  Send 404 return code.
			return new ResponseEntity<Reservation>( HttpStatus.NOT_FOUND);
		} else {
			for (Reservation c : reservation) {
				reservationRepository.delete(c);
			}
			// return 204,  request successful.  no content returned.
			return new ResponseEntity<Reservation>( HttpStatus.NO_CONTENT);
		}
		
	}
	
	//@GetMapping("/api/cars/{city}")
   // public ResponseEntity<Car> getWeather(@PathVariable("city") String city) {
  //      return carService.getCityInfo(city);
  //  }

}
