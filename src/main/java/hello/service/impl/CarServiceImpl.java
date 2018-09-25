package hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.model.Car;
import hello.service.CarRepository;
import hello.service.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(long id) {
		return carRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Car car) {
		if (car.getId() == null) {
			while (true) {
				long id = (long) (Math.random() * 57845748904L);
				if (!carRepository.findById(id).isPresent()) {
					car.setId(id);
					break;
				}
			}
		}
		carRepository.save(car);
	}

	@Override
	public void deleteCar(long id) {
		carRepository.deleteById(id);
	}

}
