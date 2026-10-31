package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.ProductBean;
import com.hibernate.util.HibernateUtil;

public class ProductDao {

	public static void main(String[] args) {
		System.out.println("Product Dao started..............!");

		ProductBean product = new ProductBean(104, "Bike", 100000);
		createProduct(product);

		ProductBean productById = getProduct(102);
		System.out.println("Product By Id: " + productById);

		updateProduct(new ProductBean(103, "Mobile", 20999));

		deleteProduct(104);

		System.out.println("Product Dao ended..............!");
	}

	private static void createProduct(ProductBean addProduct) {
		System.out.println("Calling createProduct() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			int newProduct = (int) session.save(addProduct);
			tx.commit();
			System.out.println("newProductId: " + newProduct);
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

	private static ProductBean getProduct(int id) {
		System.out.println("Calling getProduct() ");
		Session session = null;
		ProductBean product = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			product = (ProductBean) session.get(ProductBean.class, id);

			if (product != null) {
				System.out.println("Product ID: " + product.getProductId() + "\nProduct Name: "
						+ product.getProductName() + "\nPrice: " + product.getPrice());
			} else {
				System.out.println("Product not found ");
			}

		} catch (RuntimeException e) {
			System.out.println("Exception: " + e);
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Product record fetched successfully!");
		return product;
	}

	private static void updateProduct(ProductBean updateProduct) {
		System.out.println("Calling updateProduct() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			ProductBean product = (ProductBean) session.get(ProductBean.class, updateProduct.getProductId());
			product.setProductName(updateProduct.getProductName());
			product.setPrice(updateProduct.getPrice());

			session.saveOrUpdate(product);
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException e2) {
				System.out.println("Couldn't roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Product record updated successfully!");

	}

	@SuppressWarnings("unused")
	private static void deleteProduct(int id) {
		System.out.println("Calling deleteProduct ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			ProductBean product = (ProductBean) session.get(ProductBean.class, id);
			if (session != null) {
				session.delete(product);
				System.out.println("Product record deleted successfully!");

			} else {
				System.out.println("Product not found");
			}
			tx.commit();

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

}
