package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;

public class ManyToManyMapping {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		Question q1 = new Question();
		q1.setqName("What is java?");
		Question q2 = new Question();
		q2.setqName("What is servlet?");

		Answer a1 = new Answer();
		a1.setAnsName("Java is a programming language");
		a1.setPostedBy("Deep");
		Answer a2 = new Answer();
		a2.setAnsName("Java is a platform");
		a2.setPostedBy("Ajay");

		Answer a3 = new Answer();
		a3.setAnsName("Servlet is an interface");
		a3.setPostedBy("Deva");
		Answer a4 = new Answer();
		a4.setAnsName("Servetl is an API");
		a4.setPostedBy("Deva");

		a1.getQuestions().add(q1);
		a2.getQuestions().add(q1);

		a3.getQuestions().add(q2);
		a4.getQuestions().add(q2);

		q1.getAnswers().add(a1);
		q1.getAnswers().add(a2);

		q2.getAnswers().add(a3);
		q2.getAnswers().add(a4);

		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		session.persist(a4);

		tx.commit();
		session.close();
		System.out.println("Saved Succesfully....!");
	}

}
