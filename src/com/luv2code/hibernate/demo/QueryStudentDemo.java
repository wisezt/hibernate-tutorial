package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory theSessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session theSession = theSessionFactory.getCurrentSession();

        try {


            Student theStudent = new Student();
            Student theStudent2 = new Student("Ting0012", "Zheng","Ting@gmail.com");
            // start a transaction
            theSession.beginTransaction();
            // read the student object

            System.out.println("before saving: " + theStudent2);
            theSession.save(theStudent2);
            System.out.println("after saving: " + theStudent2);


            theStudent=  theSession.get(Student.class, 1);

            System.out.println(theStudent);

            // commit transaction
            theSession.getTransaction().commit();

            theSession.close();


        } finally {
            theSessionFactory.close();
        }

    }


}
