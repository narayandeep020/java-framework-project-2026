package org.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int cid;

	private String cname;

	private int fees;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="course")
	private List<Student> students;

	public Course() {
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFees() {
		return this.fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setCourse(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setCourse(null);

		return student;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", fees=" + fees + ", students=" + students + "]";
	}

}