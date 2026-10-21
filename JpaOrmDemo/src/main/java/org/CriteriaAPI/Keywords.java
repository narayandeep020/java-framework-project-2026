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

public class Keywords {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();

//		Using BETWEEN Keyword

		AbstractQuery<Student> aq1 = cb.createQuery(Student.class);
		Root<Student> root1 = aq1.from(Student.class);

		aq1.where(cb.between(root1.get("rollNo"), 19024, 19087));

		CriteriaQuery<Student> cq1 = ((CriteriaQuery<Student>) aq1).select(root1);
		TypedQuery<Student> tq1 = em.createQuery(cq1);
		List<Student> list1 = tq1.getResultList();

		System.out.println("Students having rollno between 19024 and 19087");
		System.out.println("sID" + "\t" + "sName" + "\t" + "sRollNo");
		for (Student s1 : list1) {
			System.out.println(s1.getStudentId() + "\t" + s1.getStuName() + "\t" + s1.getRollNo());
		}

//		Using LIKE Keyword

		AbstractQuery<Student> aq2 = cb.createQuery(Student.class);
		Root<Student> root2 = aq2.from(Student.class);

		aq2.where(cb.like(root2.get("stuName"), "R%"));

		CriteriaQuery<Student> cq2 = ((CriteriaQuery<Student>) aq2).select(root2);
		TypedQuery<Student> tq2 = em.createQuery(cq2);
		List<Student> list2 = tq2.getResultList();

		System.out.println("Students name starting with R");
		System.out.println("sID" + "\t" + "sName" + "\t" + "sRollNo");
		for (Student s2 : list2) {
			System.out.println(s2.getStudentId() + "\t" + s2.getStuName() + "\t" + s2.getRollNo());
		}

//		Using IN Keyword

		AbstractQuery<Student> aq3 = cb.createQuery(Student.class);
		Root<Student> root3 = aq3.from(Student.class);

		aq3.where(cb.in(root3.get("rollNo")).value(19023).value(19053));

		CriteriaQuery<Student> cq3 = ((CriteriaQuery<Student>) aq3).select(root3);
		TypedQuery<Student> tq3 = em.createQuery(cq3);
		List<Student> list3 = tq3.getResultList();

		System.out.println("Students having rollno 19023 and 19053");
		System.out.println("sID" + "\t" + "sName" + "\t" + "sRollNo");
		for (Student s3 : list3) {
			System.out.println(s3.getStudentId() + "\t" + s3.getStuName() + "\t" + s3.getRollNo());
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
