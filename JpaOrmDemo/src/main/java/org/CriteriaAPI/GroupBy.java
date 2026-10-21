package org.CriteriaAPI;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.model.Student;

public class GroupBy {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Student> root = cq.from(Student.class);

		cq.multiselect(root.get("city"), cb.count(root)).groupBy(root.get("city"));

		System.out.println("Scity" + "\t" + "Scount");
		List<Object[]> list = em.createQuery(cq).getResultList();
		for (Object[] obj : list) {
			System.out.println(obj[0] + "\t" + obj[1]);
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
