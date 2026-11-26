package com.custom.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.custom.entity.UserNative;
import com.custom.util.HibernateUtil;

public class UserDao {

	public static void main(String[] args) {

		saveUser();
		getUser();
		updateUser();
		deleteUser();
	}

	private static void deleteUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String sql = "DELETE FROM user_native WHERE user_id = :user_id";
		int query = session.createSQLQuery(sql)
				.setParameter("user_id", 4)
				.executeUpdate();
		System.out.println("Deleted row: " + query);
		
		System.out.println("User Deleted.......!");
		tx.commit();
		session.close();
	}

	private static void updateUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String sql = "UPDATE user_native SET user_name = :user_name WHERE user_id = :user_id";
		int query = session.createSQLQuery(sql).setParameter("user_name", "Satya").setParameter("user_id", 3)
				.executeUpdate();

		System.out.println("Updated row: " + query);

		tx.commit();
		session.close();

	}

	private static void getUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String sql = "SELECT * FROM user_native";

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(UserNative.class);
		@SuppressWarnings("unchecked")
		List<UserNative> result = query.list();

		for (UserNative user : result) {
			System.out.println(user);
		}

		session.close();

	}

	private static void saveUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String sql = "INSERT INTO user_native(user_id, user_city, user_name)VALUES(:user_id, :user_city, :user_name)";
		
		session.createSQLQuery(sql)
		.setParameter("user_id", 4)
		.setParameter("user_city", "Delhi")
		.setParameter("user_name", "Samya")
		.executeUpdate();

		System.out.println("User Saved.........!");
		tx.commit();
		session.close();

	}

}
