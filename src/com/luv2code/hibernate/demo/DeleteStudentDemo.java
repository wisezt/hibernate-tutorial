package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudentDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory theSessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session theSession = theSessionFactory.getCurrentSession();

        try {




            // start a transaction
            theSession.beginTransaction();
            // read the student object


           List<Student> theStudents =  theSession.createQuery("From Student s where  s.firstName = 'Ting01'").getResultList();

            displayStudents(theStudents);


            // commit transaction
            theSession.getTransaction().commit();

            theSession.close();


        } finally {
            theSessionFactory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }


}
