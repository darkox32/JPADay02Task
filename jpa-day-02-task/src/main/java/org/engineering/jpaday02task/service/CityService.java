package org.engineering.jpaday02task.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.engineering.jpaday02task.entity.City;

public class CityService {
	private EntityManagerFactory emf;
	
	public CityService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(City city) throws Exception {
		EntityManager em = emf.createEntityManager();
		try {
			City existingCity = em.find(City.class, city.getId());
			if (existingCity != null)
				throw new Exception("Grad sa tim brojem vec postoji!");

			em.getTransaction().begin();
			em.persist(city);
			em.getTransaction().commit();

			System.out.println("Sacuvan je grad...");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error: " + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void printAll() {
		EntityManager em = emf.createEntityManager();
		List<City> cities = em.createQuery("SELECT c FROM City c").getResultList();
		for (City city : cities) {
			System.out.println(city);
		}
		em.close();
	}
	

}
