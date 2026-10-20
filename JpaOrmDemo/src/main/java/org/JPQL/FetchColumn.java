package org.JPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.model.Student;

public class FetchColumn {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

//		Fetch single column from database by using createQuery() method .
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT s.stuName FROM Student s");
		@SuppressWarnings("unchecked")
		List<String> list = query.getResultList();
		System.out.println("Students Name: ");

		for (String s : list) {
			System.out.println(s);
		}

//		Fetch single row from database by using createNamedQuery() method.
		Query query1 = em.createNamedQuery("find student by id");
		query1.setParameter("studentId", 203);
		@SuppressWarnings("unchecked")
		List<Student> li = query1.getResultList();
		System.out.println("Student Data :");
		for (Student s : li) {

			System.out.println(s.getStudentId() + " " + s.getStuName() + " " + s.getCity() + " " + s.getAddress());

		}

		em.close();
		emf.close();
	}
}
