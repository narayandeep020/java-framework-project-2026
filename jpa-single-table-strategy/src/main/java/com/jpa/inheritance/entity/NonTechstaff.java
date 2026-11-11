package com.jpa.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "NONTECH")

public class NonTechstaff extends Staff {

	private static final long serialVersionUID = 1L;

	private String areaexpertise;

	public NonTechstaff() {
		super();
	}

	public NonTechstaff(long sid, String sname, String areaexpertise) {
		super(sid, sname);
		this.areaexpertise = areaexpertise;
	}

	public String getAreaexpertise() {
		return areaexpertise;
	}

	public void setAreaexpertise(String areaexpertise) {
		this.areaexpertise = areaexpertise;
	}
}
