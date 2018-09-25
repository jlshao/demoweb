package hello.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.model.Car;

public interface CarRepository extends MongoRepository<Car, Long> {
	public Car findByName(String name);

	public List<Car> findByCondition(String condition);
}
