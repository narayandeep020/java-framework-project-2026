package org.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.model.Product;

public class ProductImpl {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		// Create
		em.getTransaction().begin();
		Product product = new Product();
		product.setName("Laptop");
		product.setPrice(1000.0);
		em.persist(product);
		em.getTransaction().commit();

		// Read
		Product retrievedProduct = em.find(Product.class, 1L);
		System.out.println(retrievedProduct.getName()); // Output: Laptop

		// Update
		em.getTransaction().begin();
		retrievedProduct.setPrice(1200.0);
		em.getTransaction().commit();

		// Delete
		em.getTransaction().begin();
		em.remove(retrievedProduct);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
