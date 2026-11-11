package com.jpa.inheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TECH")

public class Techstaff extends Staff {

	private static final long serialVersionUID = 1L;

	@Column(name = "subject_expert")
	private String subjectExpert;

	private String qualification;

	public Techstaff() {
		super();
	}

	public Techstaff(long sid, String sname, String subjectExpert, String qualification) {
		super(sid, sname);
		this.subjectExpert = subjectExpert;
		this.qualification = qualification;
	}

	public String getSubjectExpert() {
		return subjectExpert;
	}

	public void setSubjectExpert(String subjectExpert) {
		this.subjectExpert = subjectExpert;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
}
