package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hello.model.Car;
import hello.service.CarRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private CarRepository repository;

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		repository
				.save(new Car(1L, "ACURA ILX", "In essence a more luxurious version of the Honda Civic Sedan", "FAIR"));
		repository.save(new Car(2L, "AUDI A6", "The eighth generation Audi A6", "GOOD"));
		repository.save(new Car(3L, "TOYOTA Avalon", "Toyota Avalon", "FAIR"));
		repository.save(new Car(4L, "TESLA MOTORS Model S", "Tesla Model S got a slight facelift", "GOOD"));
		repository.save(new Car(5L, "VOLVO XC60", "Safest car ever made", "FAIR"));
	}

}
