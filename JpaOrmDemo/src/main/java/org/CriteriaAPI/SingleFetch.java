package org.CriteriaAPI;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.model.Student;

public class SingleFetch {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);

		query.select(root.get("stuName"));

		CriteriaQuery<Student> select = query.select(root);
		TypedQuery<Student> tq = em.createQuery(select);

		List<Student> list = tq.getResultList();
		System.out.println("sid" + " " + "sname");

		for (Student s : list) {
			System.out.println(s.getStudentId() + " " + s.getStuName());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
