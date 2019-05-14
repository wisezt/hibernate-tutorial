package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

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
            // create a student object
            Student tempStudent = new Student("Ting", "Zheng", "Ting@gmail.com");

            // start a transaction
            theSession.beginTransaction();
            // save the student object
            theSession.save(tempStudent);
            System.out.println("Saving the student ...");
            // commit transaction
            theSession.getTransaction().commit();

            theSession.close();


        } finally {
            theSessionFactory.close();
        }

    }

}
