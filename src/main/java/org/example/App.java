package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started..." );



        // Making Session Factory
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        // Creating Student Object to make student
        Student ajay = new Student();
        ajay.setId(102);
        ajay.setName("Abhay");
        ajay.setCity("Lucknow");
        System.out.println(ajay);


        // creating object of address class
        Address address = new Address();
        address.setStreet("Street2");
        address.setCity("Haryana");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(2.2);

        // Reading image
        try{
            FileInputStream fileInputStream = new FileInputStream("D:\\java project\\MAVEN\\Maven_first_Project\\icon\\fb.png");
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            address.setImage(data);
        }
        catch (Exception e){
            throw new RuntimeException("Image not found");
        }


        // saving the objects
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ajay);
        session.save(address);
        transaction.commit();
        session.close();

        System.out.println("Done");


    }
}
