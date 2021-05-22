package com.unla.tpejemplo.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Degree {
	private int id;
	private String name;
	
	@Size(min=3, max=12)
	private String institution;
	
	@Min(3)
	private int year;
	
	//constructor
	public Degree() {}
	public Degree(int id, String name, String institution, int year) {
		this.id = id;
		this.name = name;
		this.institution = institution;
		this.year = year;
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	//toString
	@Override
	public String toString() {
		return "name=" + name + ", institution=" + institution + ", year=" + year;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		return ((Degree)obj).getId() == this.getId();
	}
	
	
	
	
	
	
}
