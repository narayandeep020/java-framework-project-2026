package org.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.model.Course;
import org.model.Student;

public class CriteriaApi {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Insert data
		em.getTransaction().begin();
		Student student = new Student();
		student.setStudentId(210);
		student.setStuName("Maha");
		student.setRollNo("19089");
		student.setAddress("Dhanedi");
		student.setCity("Maiher");
		em.persist(student);
		em.getTransaction().commit();

		// Read data
		CriteriaQuery<Student> read = cb.createQuery(Student.class);
		Root<Student> r1 = read.from(Student.class);
		read.select(r1).where(cb.equal(r1.get("city"), "katni"));
		List<Student> list1 = em.createQuery(read).getResultList();
		for (Student stu : list1) {
			System.out.println(stu.getCity());
		}

		// Update data
		CriteriaUpdate<Student> update = cb.createCriteriaUpdate(Student.class);
		Root<Student> r2 = update.from(Student.class);
		update.set("city", "Dattavadi").where(cb.equal(r2.get("stuName"), "Rahul"));
		em.getTransaction().begin();
		em.createQuery(update).executeUpdate();
		em.getTransaction().commit();

		// Delete data
		CriteriaDelete<Student> delete = cb.createCriteriaDelete(Student.class);
		Root<Student> r3 = delete.from(Student.class);
		delete.where(cb.equal(r3.get("stuName"), "juliate"));
		em.getTransaction().begin();
		em.createQuery(delete).executeUpdate();
		em.getTransaction().commit();

		// select all records
		System.out.println("Select All Record");
		CriteriaQuery<Student> select = cb.createQuery(Student.class);
		Root<Student> root = select.from(Student.class);
		select.select(root);
		TypedQuery<Student> tq = em.createQuery(select);
		List<Student> list = tq.getResultList();

		for (Student s : list) {
			System.out.println("Sid: " + s.getStudentId() + " Sname: " + s.getStuName() + " Sroll: " + s.getRollNo()
					+ " Saddr: " + s.getAddress() + " Scity: " + s.getCity());
		}

		// Inner join student with course
		Root<Student> root1 = select.from(Student.class);
		Join<Student, Course> dept = root1.join("course");
		
		select.select(root1).where(cb.equal(dept.get("cname"), "Mtech"));
		List<Student> rList = em.createQuery(select).getResultList();
		
		for (Student s : rList) {
			System.out.println("Sid: " + s.getStudentId() + " Sname: " + s.getStuName() + " Sroll: " + s.getRollNo()
					+ " Saddr: " + s.getAddress() + " Scity: " + s.getCity() + " cousre: " + s.getCourse());
		}
		em.close();
		emf.close();
	}

}
