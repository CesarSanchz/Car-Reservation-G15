package cst438.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import cst438.domain.*;
import cst438.services.*;
import cst438.repositories.CarRepository;

@Controller
public class CarController {
	
	@Autowired
	private CarRepository CarRepository;
	
	@Autowired
	CarService carService;
	
	
	
	//List of all cars in DB
	@GetMapping("/allCars")
	public String getAllCars(Model model) {
		List<Car> cars_list = CarRepository.findByPrice();
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
    public String getCarByCity(@RequestParam("city") String city, Model model ) throws ParseException {
        List<Car> cars = CarRepository.findByCity(city);
        model.addAttribute("Car", cars);
        System.out.append(city);
        return "reservations_page";
    }
      //try using findbyid from the carrepo page .java 
	@PostMapping("/select/reservation_page")
	public String getCarById(@RequestParam("id") int id, Model model) {
		 List<Car> test= CarRepository.findById(id);
		Car cars = new Car();
		//Car cars = CarRepository.findCarById(id);
		model.addAttribute("Car", test);
		model.addAttribute("car", cars);		
			return "reservations_save";
	}

	//@PostMapping("/select/confirmation")
}
