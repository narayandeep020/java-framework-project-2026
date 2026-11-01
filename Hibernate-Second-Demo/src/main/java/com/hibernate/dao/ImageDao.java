package com.hibernate.dao;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.entity.ImageEntity;
import com.hibernate.util.HibernateUtil;

public class ImageDao {

	public static void main(String[] args) {
		System.out.println("ImageDao started..............!");
		saveImage();
		readImage(2);
		System.out.println("ImageDao ended................!");

	}

	private static void saveImage() {
		System.out.println("saveImage started..........");

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		try {
			Configuration config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();

			sessionFactory = config.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			File imgFile = new File("C:\\Users\\HP\\OneDrive\\Pictures\\Camera Roll\\the_moon.jpg");
			byte[] imgData = new byte[(int) imgFile.length()];
			try {
				FileInputStream imgInputStream = new FileInputStream(imgFile);
				imgInputStream.read(imgData);
				imgInputStream.close();

			} catch (Exception e) {
				System.err.println("Image save failed..........");
				e.printStackTrace();
			}

			File photoFile = new File("C:\\Users\\HP\\OneDrive\\Pictures\\Camera Roll\\sun_flower.jpg");
			byte[] photoData = new byte[(int) photoFile.length()];
			try {
				FileInputStream photoInputStream = new FileInputStream(photoFile);
				photoInputStream.read(photoData);
				photoInputStream.close();

			} catch (Exception e) {
				System.err.println("Photo save failed...........");
				e.printStackTrace();
			}

			ImageEntity imgEntity = new ImageEntity();
			imgEntity.setImageData(imgData);
			imgEntity.setImageName("gallery.png");
			imgEntity.setPhotoData(photoData);

			session.save(imgEntity);
			tx.commit();
			System.out.println("Image saved successfully...........!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Image save exception...........!");
			e.printStackTrace();
		} finally {
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.shutdownSessionFactory();
			}
		}

	}

	private static void readImage(int imgId) {
		System.out.println("readImage started............!");
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			Configuration config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();

			sessionFactory = config.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();

			ImageEntity retrievedImg = (ImageEntity) session.get(ImageEntity.class, imgId);
			if (retrievedImg != null) {
				System.out.println("Found Image Record: " + retrievedImg.getImageName());

				// Extract the byte array
				byte[] imageBytes = retrievedImg.getImageData();
				byte[] photoBytes = retrievedImg.getPhotoData();

				// 5. Save the byte array to a physical file
				Path imgPath = Paths.get("output_images/" + retrievedImg.getImageName());
				Path photoPath = Paths.get("output_photo/" + "photo_" + retrievedImg.getImageName());

				// Ensure parent directories exist
				Files.createDirectories(imgPath.getParent());
				Files.write(imgPath, imageBytes);

				// Ensure parent directories exist
				Files.createDirectories(photoPath.getParent());
				Files.write(photoPath, photoBytes);

				System.out.println("Image successfully saved to: " + imgPath.toAbsolutePath());

			} else {
				System.out.println("No image record found with imageId: " + imgId);
			}

		} catch (Exception e) {
			System.err.println("Image read exception..........!");
			e.printStackTrace();
		} finally {
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				HibernateUtil.shutdownSessionFactory();
			}
		}

	}

}
