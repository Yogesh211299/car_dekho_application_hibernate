package com.jspiders.cardekho_case_study3.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Car {

	@Id
	private int carId;
	private String name;
	private String brand;
	private String model;
	private String fuelType;
	private double price;
}
