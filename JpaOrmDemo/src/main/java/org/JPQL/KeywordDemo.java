package org.JPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.model.Student;

public class KeywordDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		// Between
		System.out.println("Using Between Keyword~~~~~~~~~~");
		Query q1 = em.createQuery("SELECT s FROM Student s WHERE s.studentId BETWEEN 201 and 210");
		List<Student> list = q1.getResultList();

		for (Student s1 : list) {
			System.out.println("Student Id : " + s1.getStudentId() + " Student Name: " + s1.getStuName());
		}

		// Like
		System.out.println("Using Like Keyword~~~~~~~~~~~~");
		Query q2 = em.createQuery("SELECT s FROM Student s WHERE s.stuName LIKE 'R%'");
		List<Student> list2 = q2.getResultList();

		for (Student s2 : list2) {
			System.out.println("Student ID: " + s2.getStudentId() + " Student Name: " + s2.getStuName());
		}

		// Order By Clause
		System.out.println("Using ASC Order By Clause~~~~~~~~~~~~");
		Query q3 = em.createQuery("SELECT s FROM Student s ORDER BY s.stuName ASC");
		List<Student> list3 = q3.getResultList();

		for (Student s3 : list3) {
			System.out.println("Student ID: " + s3.getStudentId() + " Student Name: " + s3.getStuName());
		}

		System.out.println("Using DESC Order By Clause~~~~~~~~~~~~");
		Query q4 = em.createQuery("SELECT s FROM Student s ORDER BY s.stuName DESC");
		List<Student> list4 = q4.getResultList();

		for (Student s4 : list4) {
			System.out.println("Student ID: " + s4.getStudentId() + " Student Name: " + s4.getStuName());
		}

		// @Named Query
		System.out.println("Using @NamedQuery~~~~~~~~~~~~");
		Query query = em.createNamedQuery("find student by id");
		query.setParameter("studentId", 203);
		List<Student> list5 = query.getResultList();

		for (Student s5 : list5) {
			System.out.print("Student ID :" + s5.getStudentId() + " Student Name :" + s5.getStuName());

		}
	}

}
