package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embedd_Demo {

    public static void main(String[] args) {
        // Making Session Factory
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Making Session,, session facrtory se ek session open karne ko bola or wo jab session
        // return karega toh usko session ke class ka ek object bana kar usme get kar lenge
        Session session = sessionFactory.openSession();


        // Making Object of Student
        Student student1 = new Student();
        student1.setCity("Haryana");
        student1.setName("VIKAS");
        student1.setId(101);

        Certification certification1 = new Certification();
        certification1.setDuration("2 Months");
        certification1.setCourse("Full Stack");
        student1.setCertification(certification1);

        Student student2 = new Student();
        student2.setCity("Haryana");
        student2.setName("AJAY");
        student2.setId(102);

        Certification certification2 = new Certification();
        certification2.setDuration("1 Months");
        certification2.setCourse("Hibernate");
        student2.setCertification(certification2);

        // Opening the session
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        // saving these object in Session class object ,, becoz this save method is in session factory
        session1.save(student1);
        session1.save(student2);


        transaction.commit();
        session1.close();
        sessionFactory.close();
    }
}
