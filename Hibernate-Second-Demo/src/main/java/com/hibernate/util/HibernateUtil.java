package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * This method initializes and returns the Hibernate SessionFactory.
	 * 
	 * @return SessionFactory instance since version 4.x, service registry is being
	 *         used service registry is a new concept in Hibernate 4.x, it is a new
	 *         way of bootstrapping Hibernate and it is used to configure and build
	 *         the SessionFactory.
	 */

	private static SessionFactory buildSessionFactory() {

		if (sessionFactory == null) {
			try {
				System.out.println("Hibernate setup successfull");

				Configuration configuration = new Configuration().configure();

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				return configuration.buildSessionFactory(serviceRegistry);

			} catch (Throwable th) {
				System.out.println("SessionFactory creation failed: " + th);
				throw new ExceptionInInitializerError(th);
			}
		} else {
			return sessionFactory;
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;

	}

	public static void shutdownSessionFactory() {
		getSessionFactory().close();
	}
}
