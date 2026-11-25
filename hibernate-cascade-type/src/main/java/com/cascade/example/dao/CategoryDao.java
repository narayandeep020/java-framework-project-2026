package com.cascade.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cascade.example.modal.Category;
import com.cascade.example.modal.Product;
import com.cascade.example.util.HibernateUtil;

public class CategoryDao {

	public void saveCategoryWithProducts() {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Category category = new Category("Electronics");
			Product p1 = new Product("Laptop");
			Product p2 = new Product("SmartPhone");

			category.addProduct(p1);
			category.addProduct(p2);

			session.save(category);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void removeProductFromCategory(long categoryId, long productId) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Category category = (Category) session.get(Category.class, categoryId);
			if (category != null) {
				category.getProducts().removeIf(product -> product.getId().equals(productId));
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void deleteCategory(long categoryId) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Category category = (Category) session.get(Category.class, categoryId);
			if (category != null) {
				session.delete(category);
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
