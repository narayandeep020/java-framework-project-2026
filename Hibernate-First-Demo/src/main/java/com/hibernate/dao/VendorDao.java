package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.VendorBean;
import com.hibernate.util.HibernateUtil;

public class VendorDao {

	public static void main(String[] args) {
		System.out.println("Vendor Dao started..............!");

		VendorBean vendor = new VendorBean(104, "Kali", "Maiher");
		createVendor(vendor);

		VendorBean vendorById = getVendor(101);
		System.out.println("Vendor By Id: " + vendorById);

		updateVendor(new VendorBean(101, "Deep", "Maiher"));

		deleteVendor(104);

		System.out.println("Vendor Dao ended..............!");

	}

	private static void createVendor(VendorBean vendor) {
		System.out.println("Calling createVendor() ");

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			int newVendorId = (int) session.save(vendor);
			tx.commit();
			System.out.println("newVendorId " + newVendorId);

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

	private static VendorBean getVendor(int id) {
		System.out.println("Calling getVendor() ");
		Session session = null;
		VendorBean vendor = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			vendor = (VendorBean) session.get(VendorBean.class, id);
			if (vendor != null) {
				System.out.println("vendor id: " + vendor.getVendorId());
				System.out.println("name: " + vendor.getVendorName());
				System.out.println("location: " + vendor.getLocation());

			} else {
				System.out.println("Vendor not found.");
			}

		} catch (RuntimeException e) {
			System.out.println("Exception: " + e);
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Vendor record fetched successfully!");
		return vendor;
	}

	private static void updateVendor(VendorBean updateVendor) {
		System.out.println("Calling updateVendor() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			VendorBean vendor = (VendorBean) session.get(VendorBean.class, updateVendor.getVendorId());
			vendor.setVendorId(updateVendor.getVendorId());
			vendor.setVendorName(updateVendor.getVendorName());
			vendor.setLocation(updateVendor.getLocation());

			session.saveOrUpdate(vendor);
			tx.commit();

		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException ex) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Vendor record updated successfully!");

	}

	@SuppressWarnings("unused")
	private static void deleteVendor(int id) {
		System.out.println("Calling deleteVendor()");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			VendorBean vendor = (VendorBean) session.get(VendorBean.class, id);
			if (session != null) {
				session.delete(vendor);
				System.out.println("Vendor record deleted successfully!");
			} else {
				System.out.println("Vendor not found");
			}
			tx.commit();
		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Vendor record deleted successfully!");
	}
}