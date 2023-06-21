package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch_Data {
    public static void main(String[] args) {

        // Making Session Factory
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Making Session,, session facrtory se ek session open karne ko bola or wo jab session
        // return karega toh usko session ke class ka ek object bana kar usme get kar lenge
        Session session = sessionFactory.openSession();


        /* To Fetch the data we have two methods
        1. GET METHOD
        2. LOAD METHOD
         */
        //GET the DATA  (when we know the primary key value , which to get)
        // ye ek student class ka object return karega isliye humne isko student class mein type cast kar liya
        Student student1 = (Student) session.get(Student.class,102);
        System.out.println(student1);

        // it will give null becoz we don'y have any student in DB whose id is 103
        Student student2 = (Student) session.get(Student.class,103);
        System.out.println(student2);



        // LOAD
        // iss method se hum 1-1 alag -alag data le sakte hai ,,but get se hume object milta hai
        Address address1 = (Address) session.load(Address.class,2);
        System.out.println(address1.getStreet() + "," + address1.getCity());

        // it will exception, becoz we don't have any adress id as 3 in our DB(student_address table)
        Address address2 = (Address) session.load(Address.class,3);
        System.out.println(address2.getStreet() + "," + address2.getCity());

        // closing the session
        session.close();
        sessionFactory.close();
    }
}

/*
   Get :- it returns the null if object not found
   Load :- it return the objectNotfound exception if object not found

   Get :- use when you are not sure if the object exits or not
   Load :- use when you are sure that objects exists

   Get :- jab hum session ke object se get ko call karte hai toh wo object laakar session ke cache memory mein store
          kar deta hai, and agar hum firse get ko call karenge toh wo pehele apne cache memory mein dekhega ki waha wo
          object hai ya nahi , agar nahi hoga , tab wo database se laakar dega
   Load :- isme jab hum session se load method ko call karte hai toh ye object laakar apne paas rkh leta hai
           but ye database ko abhi hit nahi karta hai, ye database ko tab hit karega means select ki query tab lagayega
           jab hum uss object se koi data ko call kar dega, e.g address.getCity()  ,, jab hum object se kisi property ko
           fetch kar rhe hai ,, tab ye database pe select query lagayega.
           isko lazy initialization bhi bolte hai ,, or isse performance increase ho jaati hai
 */