package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.model.Car;
import hello.service.CarService;

@Controller
public class CarController {
	@Autowired
	CarService carService;

	@GetMapping("/cars/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("car_list");
		List<Car> carList = carService.getAllCars();
		model.addObject("carList", carList);

		return model;
	}

	@GetMapping("/cars/add")
	public ModelAndView addArticle() {
		ModelAndView model = new ModelAndView();

		Car Car = new Car();
		model.addObject("carForm", Car);
		model.setViewName("car_form");

		return model;
	}

	@GetMapping("/cars/edit/{id}")
	public ModelAndView editCar(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Car car = carService.getCarById(id);
		model.addObject("carForm", car);
		model.setViewName("car_form");

		return model;
	}

	@PostMapping("/cars/save")
	public ModelAndView save(@ModelAttribute("CarForm") Car Car) {
		carService.saveOrUpdate(Car);

		return new ModelAndView("redirect:/cars/list");
	}

	@GetMapping("/cars/delete/{id}")
	public ModelAndView delete(@PathVariable("id") long id) {
		carService.deleteCar(id);

		return new ModelAndView("redirect:/cars/list");
	}
}
