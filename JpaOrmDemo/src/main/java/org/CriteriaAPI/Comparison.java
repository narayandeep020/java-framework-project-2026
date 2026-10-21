package org.CriteriaAPI;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.model.Student;

public class Comparison {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		AbstractQuery<Student> aq1 = cb.createQuery(Student.class);
		AbstractQuery<Student> aq2 = cb.createQuery(Student.class);

		Root<Student> root1 = aq1.from(Student.class);
		aq1.where(cb.greaterThan(root1.get("rollNo"), 19053));

		CriteriaQuery<Student> cq1 = ((CriteriaQuery<Student>) aq1).select(root1);
		TypedQuery<Student> tq1 = em.createQuery(cq1);
		List<Student> list1 = tq1.getResultList();

		System.out.println("Students having rollno greater than 19053");
		System.out.println("sID" + "\t" + "sName" + "\t" + "sRollNo");
		for (Student s1 : list1) {
			System.out.println(s1.getStudentId() + "\t" + s1.getStuName() + "\t" + s1.getRollNo());
		}

		Root<Student> root2 = aq2.from(Student.class);
		aq2.where(cb.lessThan(root2.get("rollNo"), 19053));

		CriteriaQuery<Student> cq2 = ((CriteriaQuery<Student>) aq2).select(root2);
		TypedQuery<Student> tq2 = em.createQuery(cq2);
		List<Student> list2 = tq2.getResultList();

		System.out.println("Students having rollno less than 19053");
		System.out.println("sID" + "\t" + "sName" + "\t\t" + "sRollNo");
		for (Student s2 : list2) {
			System.out.println(s2.getStudentId() + "\t" + s2.getStuName() + "\t" + s2.getRollNo());
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
