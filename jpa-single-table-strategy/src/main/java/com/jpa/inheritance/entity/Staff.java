package com.jpa.inheritance.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@Table(name = "staff")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "staff_type")
@NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")

public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long sid;

	private String sname;

	public Staff(long sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public Staff() {
		super();
	}

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}