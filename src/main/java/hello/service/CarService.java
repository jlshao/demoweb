package hello.service;

import java.util.List;

import hello.model.Car;

public interface CarService {
	public List<Car> getAllCars();

	public Car getCarById(long id);

	public void saveOrUpdate(Car car);

	public void deleteCar(long id);
}
