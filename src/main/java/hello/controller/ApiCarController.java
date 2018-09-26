package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Car;
import hello.service.CarService;

@RestController
@RequestMapping("api/")
public class ApiCarController {
	@Autowired
	CarService carService;

	@RequestMapping(value = "cars", method = RequestMethod.GET)
	public List<Car> list() {
		return carService.getAllCars();
	}

	@RequestMapping(value = "cars", method = RequestMethod.POST)
	public Car create(@RequestBody Car car) {
		carService.saveOrUpdate(car);
		return car;
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.GET)
	public Car get(@PathVariable Long id) {
		return carService.getCarById(id);
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.PUT)
	public Car update(@PathVariable Long id, @RequestBody Car car) {
		carService.saveOrUpdate(car);
		return car;
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.DELETE)
	public Car delete(@PathVariable Long id) {
		Car car = carService.getCarById(id);
		if (car != null)
			carService.deleteCar(id);
		return car;
	}

}
