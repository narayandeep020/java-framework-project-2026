package com.cascade.example;

import com.cascade.example.dao.CategoryDao;

public class Main {

	public static void main(String[] args) {

		CategoryDao categoryDao = new CategoryDao();

		// Save category with products
		categoryDao.saveCategoryWithProducts();
		System.out.println("Category and Products saved.");

		// Remove a product from category
//		categoryDao.removeProductFromCategory(1L, 2L);
//		System.out.println("Product remove from Category");

		// Delete a category
//		categoryDao.deleteCategory(1L);
//		System.out.println("Category deleted.");
	}

}
