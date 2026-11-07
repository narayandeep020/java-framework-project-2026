package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;

public class OneToManyMapping {

	public static void main(String[] args) {
		System.out.println("Operation Started.........!");

		saveCourse();

		getCourse((long) 3);

		updateCourse((long) 1);

		updateStudent((long) 1);

		deleteStudent((long) 2);

		deleteCourse((long) 3);

		System.out.println("Operation Ended.........!");

	}

	private static void saveCourse() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		CourseEntity c = new CourseEntity();
		c.setCourseName("Python");

		StudentEntity s1 = new StudentEntity();
		s1.setStudentName("Ajay Singh");
//		StudentEntity s2 = new StudentEntity();
//		s2.setStudentName("Amit");

		s1.setCourse(c);
//		s2.setCourse(c);

		c.getStudents().add(s1);
//		c.getStudents().add(s2);

		session.persist(c);

		tx.commit();
		session.close();

		System.out.println("Data Saved Successfully..!");
	}

	private static void getCourse(long courseId) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		CourseEntity course = (CourseEntity) session.get(CourseEntity.class, courseId);
		// Fetch Course Data
		if (course != null) {
			System.out.println("CourseId: " + course.getCourseId() + "\nCourseName: " + course.getCourseName());

			// Fetch Student Data
			for (StudentEntity s : course.getStudents()) {
				System.out.println("StudentId: " + s.getStudentId() + "\nStudentName: " + s.getStudentName()
						+ "\nCourseId: " + s.getCourse());
			}
		}
		session.close();
		System.out.println("Data Fetch successfully......!");
	}

	private static void updateCourse(long courseId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		CourseEntity course = (CourseEntity) session.get(CourseEntity.class, courseId);
		if (course != null) {
			course.setCourseName("Advanced Java");
		}
		tx.commit();
		session.close();
		System.out.println("Course Updated.........!");

	}

	private static void updateStudent(long studentId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		StudentEntity student = (StudentEntity) session.get(StudentEntity.class, studentId);
		if (student != null) {
			student.setStudentName("Deep Lodhi");
		}
		tx.commit();
		session.close();
		System.out.println("Student Updated......!");

	}

	private static void deleteStudent(long studentId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		StudentEntity student = (StudentEntity) session.get(StudentEntity.class, studentId);
		if (student != null) {
			session.delete(student);
		}
		tx.commit();
		session.close();
		System.out.println("Student Deleted......!");

	}

	private static void deleteCourse(long courseId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		CourseEntity course = (CourseEntity) session.get(CourseEntity.class, courseId);

		if (course != null) {
			session.delete(course);
		}

		tx.commit();
		session.close();

		System.out.println("Course Deleted........!");
	}
}
