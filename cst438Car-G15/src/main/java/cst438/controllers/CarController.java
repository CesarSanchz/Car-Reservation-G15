package cst438.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cst438.domain.*;
import cst438.services.*;
import cst438.repositories.CarRepository;
import cst438.repositories.ReservationRepository;

@Controller
public class CarController {

    @Autowired
    private CarRepository CarRepository;

    @Autowired
    CarService carService;

    @Autowired
    ReservationRepository reservationRepository;



    //List of all cars in DB
    @GetMapping("/allCars")
    public String getAllCars(Model model) {
        List < Car > cars_list = CarRepository.findByPrice();
        model.addAttribute("Car", cars_list);

        return "cars_list";

    }
    //Landing Page
    @GetMapping("/")
    public String getIndex(Model model) {
        Reservation reservation = new Reservation();
        Car car = new Car();
        model.addAttribute("reservation", reservation);
        model.addAttribute("car", car);
        return "index";
    }

    //Page to filter cars by City wanted by customer
    @PostMapping("/select_reservationByCity")
    public String getCarByCity(@RequestParam("city") String city, Model model) throws ParseException {
        List < Car > cars = CarRepository.findByCity(city);
        model.addAttribute("Car", cars);
        //System.out.append(city);
        return "reservations_page";
    }
    //takes the car id input from the html page to the next page to display it 
    @PostMapping("/select/reservation_page")
    public String getCarById(@RequestParam("id") int id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("Car", car);
        System.out.println("car id: " + car);

        return "reservation_save";
    }
    //returns the reservation made 
    @PostMapping("/select/reservation_car")
    public ResponseEntity < Reservation > addReservation(@RequestParam("id") int id, @RequestParam("email") String email) {
        int car_id = id;
        System.out.println("Attempting to reserve " + id + " for " + email);
        Reservation reservation = carService.makeReservation(car_id, email);

        return new ResponseEntity < Reservation > (reservation, HttpStatus.OK);
    }
}