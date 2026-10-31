package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.StudentBean;
import com.hibernate.util.HibernateUtil;

public class StudentDao {

	public static void main(String[] args) {

		System.out.println("Student Dao started..............!");

		StudentBean student = new StudentBean(104, "Deep", "EC", "Katni");
		createStudent(student);

		StudentBean studentById = getStudent(102);
		System.out.println("Student By Id: " + studentById);

		updateStudent(new StudentBean(103, "Satya", "BA", "Katni"));

		deleteStudent(104);

		System.out.println("Student Dao ended..............!");
	}

	private static void createStudent(StudentBean addStudent) {
		System.out.println("Calling createStudent() ");

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			int newStudentId = (int) session.save(addStudent);
			tx.commit();
			System.out.println("newStudentId " + newStudentId);

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException ex) {
				System.out.println("Couldn't roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
	}

	private static StudentBean getStudent(int studentId) {
		System.out.println("Calling getStudent() ");
		Session session = null;
		StudentBean student = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			student = (StudentBean) session.get(StudentBean.class, studentId);
			if (student != null) {
				System.out.println("roll no: " + student.getRollNo());
				System.out.println("name: " + student.getStudName());
				System.out.println("branch: " + student.getBranch());
				System.out.println("city: " + student.getCity());

			} else {
				System.out.println("Student not found.");
			}

		} catch (RuntimeException e) {
			System.out.println("Exception: " + e);
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record fetched successfully!");
		return student;
	}

	private static void updateStudent(StudentBean updateStudent) {
		System.out.println("Calling updateStudent() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			StudentBean student = (StudentBean) session.get(StudentBean.class, updateStudent.getRollNo());
			student.setStudName(updateStudent.getStudName());
			student.setBranch(updateStudent.getBranch());
			student.setCity(updateStudent.getCity());

			session.saveOrUpdate(student);
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException ex) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record updated successfully!");

	}

	@SuppressWarnings("unused")
	private static void deleteStudent(int deleteNo) {
		System.out.println("Calling deleteStudent() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			StudentBean student = (StudentBean) session.get(StudentBean.class, deleteNo);

			if (session != null) {
				session.delete(student);

				System.out.println("Student record deleted successfully!");
			} else {
				System.out.println("Student not found.");
			}
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record deleted successfully!");
	}

}
