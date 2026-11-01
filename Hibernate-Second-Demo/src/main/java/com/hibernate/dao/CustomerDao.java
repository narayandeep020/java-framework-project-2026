package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.CustomerEntity;
import com.hibernate.util.HibernateUtil;

public class CustomerDao {

	public static void main(String[] args) {
		System.out.println("CustomerDao Started..............!");

		CustomerEntity saveCust = new CustomerEntity();
		saveCust.setCustName("Neer");
		saveCust.setEmail("neeru.cust@gmail.com");
		saveCust.setCity("Katni");

		saveCustomer(saveCust);

		CustomerEntity retrievedCust = getCustomer(1);
		System.out.println("Retrieved Customer: " + retrievedCust);

		CustomerEntity updateCust = new CustomerEntity();
		updateCust.setCustId(3);
		updateCust.setCustName("Saumya");
		updateCust.setEmail("saumya2001@gmail.com");
		updateCust.setCity("Noida");

		updateCustomer(updateCust);

		deleteCustomer(4);

		System.out.println("CustomerDao Ended............!");
	}

	private static void saveCustomer(CustomerEntity saveCust) {
		System.out.println("Calling saveCustomer().........!");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			session.save(saveCust);
			tx.commit();

			System.out.println("Customer saved successfully with id: " + saveCust.getCustId());
		} catch (RuntimeException e) {
			System.err.println("Customer saved failed....!");
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

	private static CustomerEntity getCustomer(int custId) {
		System.out.println("Calling getCustomer()..........!");

		Session session = null;
		SessionFactory sessionFactory = null;
		CustomerEntity customer = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			customer = (CustomerEntity) session.get(CustomerEntity.class, custId);
			if (customer != null) {
				System.out.println("Customer fetched successfully!");
				System.out.println("Customer_Id: " + customer.getCustId() + "\nCustomer_Name: " + customer.getCustName()
						+ "\nEmail: " + customer.getEmail() + "\nCity: " + customer.getCity());
			} else {
				System.out.println("Customer not fetched..!");
			}
		} catch (RuntimeException e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.shutdownSessionFactory();
			}
		}
		return customer;
	}

	private static void updateCustomer(CustomerEntity updateCust) {
		System.out.println("Calling updateCustomer()........!");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		CustomerEntity cust = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			cust = (CustomerEntity) session.get(CustomerEntity.class, updateCust.getCustId());
			cust.setCustName(updateCust.getCustName());
			cust.setEmail(updateCust.getEmail());
			cust.setCity(updateCust.getCity());

			tx = session.beginTransaction();
			session.saveOrUpdate(cust);
			tx.commit();

			System.out.println("Customer updated successfully with id: " + updateCust.getCustId());
		} catch (RuntimeException e) {
			System.err.println("Customer update failed." + e.getMessage());
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

	private static void deleteCustomer(int custId) {
		System.out.println("Calling deleteCustomer().........!");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		CustomerEntity cust = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			cust = (CustomerEntity) session.get(CustomerEntity.class, custId);

			tx = session.beginTransaction();
			session.delete(cust);
			tx.commit();

			System.out.println("Customer deleted successfully with id: " + custId);
		} catch (RuntimeException e) {
			System.err.println("Customer delete failed!" + e.getMessage());

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

}
