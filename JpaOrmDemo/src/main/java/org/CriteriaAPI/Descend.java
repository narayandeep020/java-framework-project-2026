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

public class Descend {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);

		cq.orderBy(cb.desc(root.get("rollNo")));

		CriteriaQuery<Student> select = cq.select(root);
		TypedQuery<Student> tq = em.createQuery(select);
		List<Student> list = tq.getResultList();

		System.out.println("sID" + "\t sName" + "\t sRollNo");

		for (Student s : list) {
			System.out.println(s.getStudentId() + "\t" + s.getStuName() + "\t" + s.getRollNo());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
