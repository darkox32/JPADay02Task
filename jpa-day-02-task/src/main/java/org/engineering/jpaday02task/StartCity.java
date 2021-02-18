package org.engineering.jpaday02task;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.engineering.jpaday02task.entity.City;
import org.engineering.jpaday02task.service.CityService;

public class StartCity {
	private EntityManagerFactory emf;

	private CityService cityService;

	private StartCity() {
		cityService = new CityService(Persistence.createEntityManagerFactory("JPADay02Task"));
	}

	public static void main(String[] args) {
		StartCity startCity = new StartCity();

	}

	private void save(int id, long number, String name) {
		City city = new City();
		city.setNumber(11000l);
		city.setName("Beograd");
		try {
			cityService.save(city);
			System.out.println("Main: uspesno izvrsena save metoda...");
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}

}
