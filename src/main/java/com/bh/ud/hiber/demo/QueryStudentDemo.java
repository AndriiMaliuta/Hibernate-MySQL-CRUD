package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

//            List<Student> students = session.createQuery("from Student where s.lastName='Doe'").list();

//            displayStudents(students);



            session.getTransaction().commit();

            System.out.println("Success!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
