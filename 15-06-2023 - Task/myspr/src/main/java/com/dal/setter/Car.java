package com.dal.setter;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;
@Component
public class Car {
		
	@Value("Ford")
		private String name;
	@Value("ECOSPORT")
		private String model;
	@Value("1234567")
		private int carNumber;
		public int getCarNumber() {
			return carNumber;
		}
		public void setCarNumber(int carNumber) {
			this.carNumber = carNumber;
		}
		@Override
		public String toString() {
			return "Car [name=" + name + ", model=" + model + ", carNumber=" + carNumber + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
}
