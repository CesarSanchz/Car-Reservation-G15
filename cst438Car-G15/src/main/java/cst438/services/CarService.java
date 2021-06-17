package cst438.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import cst438.domain.*;
import cst438.repositories.CarRepository;
import cst438.repositories.ReservationRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Car getCar(int id) {
		List<Car> cars = carRepository.findById(id);
		Car car = cars.get(0);
		return new Car(car.getId(), car.getMake(), car.getModel(),car.getFuel(),
				car.getTransmission(),car.getYear(),
				car.getPrice(), car.getCity());
	}
	
	// Car APIs
	
	public Car getCarById(int id) {
		
		return carRepository.findCarById(id);
		
	}
	
	public List<Car> getCarByCity(String city) {
		List<Car> cars = carRepository.findByCity(city);
		List<Car> carInfo = new ArrayList<>();
		
		for(Car car:cars) {
			carInfo.add(getCar(car.getId()));
		}
		
		return carInfo;
		
	}
	
	public List<Car> getAllCars() {
		
		return carRepository.findAll();
		
	}
	
	// Reservation APIs
	
	public Reservation makeReservation(int car_id, String email) {
		int id = car_id;
		Car car = carRepository.findCarById(id);
		Reservation reservation = new Reservation(car, email);
		System.out.println("Reserving car ID:" + car_id + ", for email:" + email);
		reservationRepository.save(reservation);
		
		Reservation reservationFromDb = reservationRepository.findByEmail(email);
		
		return reservationFromDb;
	}
	
	// Get reservations by ID
	// http://localhost:8080/api/getReservation/id?rid=5
	public List<Reservation> getReservationById(int rid) {
		return reservationRepository.findById(rid);
		
	}
	
	public List<Reservation> getReservation() {
		
		return reservationRepository.findAll();
		
	}
	
	public Reservation getReservationEmail(String email){
		return reservationRepository.findByEmail(email);
	}

	public List<Reservation> findEmails(String email) {
		// TODO Auto-generated method stub
		return reservationRepository.findEmails(email);
	}		
	
}
