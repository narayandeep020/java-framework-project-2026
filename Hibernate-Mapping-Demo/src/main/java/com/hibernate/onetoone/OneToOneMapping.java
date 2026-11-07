package com.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.util.HibernateUtil;

public class OneToOneMapping {

	public static void main(String[] args) {

		// Save Employee and Company
		@SuppressWarnings("deprecation")
		SessionFactory sesstionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(EmployeeEntity.class).addAnnotatedClass(CompanyEntity.class).buildSessionFactory();

		try {
			Session session = sesstionFactory.openSession();

			CompanyEntity company = new CompanyEntity();
			EmployeeEntity employee = new EmployeeEntity();

			company.setCompanyName("TCS");
			company.setEmployee(employee);

			employee.setEmployeeName("Abhi Jha");
			employee.setEmail("abhi_emp@gmail.com");
			employee.setCompany(company);

			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();

			System.out.println("Entry added successfully....!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		getEmployee(101);

		getCompany(4);

		updateEmployee(101);

		updateCompany(4);

		deleteEmployee(101);

		deleteCompany(1);
	}

	private static void getEmployee(int empId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		EmployeeEntity emp = (EmployeeEntity) session.get(EmployeeEntity.class, empId);
		if (emp != null) {
			System.out.println("EmployeeId: " + emp.getEmployeeId() + "\nEmployeeName: " + emp.getEmployeeName()
					+ "\nEmployeeEmail: " + emp.getEmail());
		}

		session.close();
		System.out.println("Employee Fetched.........!");
	}

	private static void getCompany(int compId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		CompanyEntity comp = (CompanyEntity) session.get(CompanyEntity.class, compId);
		if (comp != null) {
			System.out.println("CompanyId: " + comp.getCompanyId() + "\nCompanyName: " + comp.getCompanyName());
		}

		session.close();
		System.out.println("Company Fetched........!");
	}

	private static void updateEmployee(int empid) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		EmployeeEntity emp = (EmployeeEntity) session.get(EmployeeEntity.class, empid);
		if (emp != null) {
			emp.setEmployeeName("Satya Lodhi");
			emp.setEmail("satya_emp@gmail.com");
			emp.getCompany().setCompanyId(1);
		}

		tx.commit();
		session.close();
		System.out.println("Employee Updated......!");
	}

	private static void updateCompany(int compid) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		CompanyEntity comp = (CompanyEntity) session.get(CompanyEntity.class, compid);
		if (comp != null) {
			comp.setCompanyId(1);
			comp.setCompanyName("Cognizent");
		}

		tx.commit();
		session.close();
		System.out.println("Company Updated.......!");

	}

	private static void deleteEmployee(int empid) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		EmployeeEntity emp = (EmployeeEntity) session.get(EmployeeEntity.class, empid);
		if (emp != null) {
			session.delete(emp);
		}

		tx.commit();
		session.close();
		System.out.println("Employee Deleted...!");

	}

	private static void deleteCompany(int compid) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		CompanyEntity comp = (CompanyEntity) session.get(CompanyEntity.class, compid);
		if (comp != null) {
			session.delete(comp);
		}

		tx.commit();
		session.close();
		System.out.println("Company Deleted...!");
	}

}
