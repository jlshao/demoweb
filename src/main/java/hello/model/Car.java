package hello.model;

import lombok.Data;

public class Car {
	Long id;
	String name;
	String description;
	String condition;

	public Car() {
	}

	public Car(Long id, String name, String description, String condition) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.condition = condition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
