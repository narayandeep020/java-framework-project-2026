package org.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
//@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
@NamedQuery(query = "Select s from Student s where s.studentId = :studentId", name = "find student by id")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="student_id")
	private int studentId;

	private String address;

	private String city;

	@Column(name="roll_no")
	private String rollNo;

	@Column(name="stu_name")
	private String stuName;

	//bi-directional many-to-one association to Course
	@ManyToOne
@JoinColumn(name="course_id")
	private Course course;

	public Student() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRollNo() {
		return this.rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}