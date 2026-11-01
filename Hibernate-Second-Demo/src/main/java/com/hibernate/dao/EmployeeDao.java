package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.EmployeeEntity;
import com.hibernate.util.HibernateUtil;

public class EmployeeDao {

	public static void main(String[] args) {
		System.out.println("EmployeeDao started.............!");

		EmployeeEntity saveEmp = new EmployeeEntity();

		saveEmp.setEmail("rama-employee@gmail.com");
		saveEmp.setFirstName("Ram");
		saveEmp.setLastName("Singh");

		saveEmployee(saveEmp);

		EmployeeEntity retrievedEmp = getEmployee(1);
		System.out.println("Retrieved Employee: " + retrievedEmp);

		EmployeeEntity updateEmp = new EmployeeEntity();
		updateEmp.setEmployeeId(1);
		updateEmp.setEmail("maha.maya@gmail.com");
		updateEmp.setFirstName("Maha");
		updateEmp.setLastName("Maya");

		updateEmployee(updateEmp);

		deleteEmployee(5);

		System.out.println("EmployeeDao ended...........!");
	}

	private static void saveEmployee(EmployeeEntity saveEmp) {
		System.out.println("Calling saveEmployee() ");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			session.save(saveEmp);

			tx.commit();
			System.out.println("Employee Saved Successfully with ID: " + saveEmp.getEmployeeId());

		} catch (RuntimeException e) {
			System.err.println("Employee Saved Failed! " + e.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.shutdownSessionFactory();
			}
		}

	}

	private static EmployeeEntity getEmployee(int id) {
		System.out.println("Calling getEmployee() ");

		Session session = null;
		SessionFactory sessionFactory = null;
		EmployeeEntity entity = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			entity = (EmployeeEntity) session.get(EmployeeEntity.class, id);

			if (entity != null) {
				System.out.println("Employee fetched successfully!");
				System.out.println("Employee ID: " + entity.getEmployeeId() + "\nEmployee Email: " + entity.getEmail()
						+ "\nEmployee First Name: " + entity.getFirstName() + "\nEmployee Last Name: "
						+ entity.getLastName());
			} else {
				System.out.println("Employee not fetched.");

			}
		} catch (RuntimeException e) {
			System.out.println("Exception " + e.getMessage());
		} finally {
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.shutdownSessionFactory();
			}
		}
		return entity;
	}

	private static void updateEmployee(EmployeeEntity updateEmp) {
		System.out.println("Calling updateEmployee() ");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		EmployeeEntity emp = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			emp = (EmployeeEntity) session.get(EmployeeEntity.class, updateEmp.getEmployeeId());

			emp.setEmail(updateEmp.getEmail());
			emp.setFirstName(updateEmp.getFirstName());
			emp.setLastName(updateEmp.getLastName());

			tx = session.beginTransaction();
			session.saveOrUpdate(emp);

			tx.commit();
			System.out.println("Employee updated succesfully with id: " + updateEmp.getEmployeeId());

		} catch (RuntimeException e) {
			System.err.println("Employee update failed! " + e.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.shutdownSessionFactory();
			}
		}

	}

	private static void deleteEmployee(int empid) {
		System.out.println("Calling deleteEmployee().........!");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		EmployeeEntity emp = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			emp = (EmployeeEntity) session.get(EmployeeEntity.class, empid);

			tx = session.beginTransaction();
			session.delete(emp);
			tx.commit();

			System.out.println("Employee deleted successfully with ID: " + empid);

		} catch (RuntimeException e) {
			System.err.println("Employee delete failed! " + e.getMessage());

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.getSessionFactory();
			}
		}

	}
}
