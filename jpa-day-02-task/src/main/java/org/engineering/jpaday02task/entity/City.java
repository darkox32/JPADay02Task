package org.engineering.jpaday02task.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 18022021113800L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Long number;
	private String name;

	public City() {

	}

	public City(int id, Long number, String name) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [ID = " + id + ", NUMBER = " + number + ", NAME = " + name + "]";
	}

}
