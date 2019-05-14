package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {


    public static void main(String[] args) {


        // create session factory
        SessionFactory theSessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session theSession = theSessionFactory.getCurrentSession();

        try {
            //use the session object to save Java object
            // create 3 student object

            Student tempStudent1 = new Student("Ting01", "Zheng", "Ting@gmail.com");
            Student tempStudent2 = new Student("Ting02", "Zheng", "Ting@gmail.com");
            Student tempStudent3 = new Student("Ting03", "Zheng", "Ting@gmail.com");
            // start a transaction
            theSession.beginTransaction();
            // save the student object
            theSession.save(tempStudent1);
            theSession.save(tempStudent2);
            theSession.save(tempStudent3);
            System.out.println("Saving the student ...");
            // commit transaction
            theSession.getTransaction().commit();

            theSession.close();


        } finally {
            theSessionFactory.close();
        }

    }
}
