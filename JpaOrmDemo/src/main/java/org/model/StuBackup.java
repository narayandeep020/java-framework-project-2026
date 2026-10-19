package org.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stu_backup database table.
 * 
 */
@Entity
@Table(name="stu_backup")
@NamedQuery(name="StuBackup.findAll", query="SELECT s FROM StuBackup s")
public class StuBackup implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	private String city;

	@Column(name="course_id")
	private int courseId;

	@Column(name="roll_no")
	private String rollNo;

	@Column(name="stu_name")
	private String stuName;

	@Id
	@Column(name="student_id")
	private int studentId;

	public StuBackup() {
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

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}