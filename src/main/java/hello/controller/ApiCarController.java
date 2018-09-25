package hello.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Car;
import hello.service.CarStub;

@RestController
@RequestMapping("api/")
public class ApiCarController {
	@RequestMapping(value = "cars", method = RequestMethod.GET)
	public List<Car> list() {
		return CarStub.list();
	}

	@RequestMapping(value = "cars", method = RequestMethod.POST)
	public Car create(@RequestBody Car Car) {
		return CarStub.create(Car);
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.GET)
	public Car get(@PathVariable Long id) {
		return CarStub.get(id);
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.PUT)
	public Car update(@PathVariable Long id, @RequestBody Car Car) {
		return CarStub.update(id, Car);
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.DELETE)
	public Car delete(@PathVariable Long id) {
		return CarStub.delete(id);
	}

}
