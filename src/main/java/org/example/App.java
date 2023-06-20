package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Projected Started..." );

        // session factory ek tarike se connection ka kaam karta hai,, or ek project ke liye
        // ek hi session factory hona chahiye
        // hum session factory ko new session factory se object nahi bana sakte becoz ye ek interface hai
        // toh hume kisi class ki jarurat padegi uska object banane ke liye
        // jo hai configuration class (org.hibernate) waali
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();



        // hum upar waale step ko aisa bhi kar sakte hai
        Configuration configuration = new Configuration();
        configuration.configure();
        // waise toh ye automatically detect kar lega hibernat.cfg.xml file ko
        // but agar kabhi nahi detect kar paya toh hume path provide karna padeg configure method mein
//        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // ab hum iss session factory ke object se session nikal sakte hai


        // Creating Student Object to make student
        Student ajay = new Student();
        ajay.setId(102);
        ajay.setName("Abhay");
        ajay.setCity("Lucknow");
        System.out.println(ajay);

        // ab hume  iss object (AJAY) ko save karna hai hibernate mein
        // toh hum Save() method se kar kar sakte hai , but dikkat ye hai ki , java mein ye save method
        // kisi na kisi class ke pass hona chahiye or ye static ya non static koi sa bhi method ho sakta hai
        // toh hum isko direct call nahi karenge ,, ye save method , session ke paas hai
        // or sessionfactory object mujhe session dega ,, jo bhi current session chal rha hoga
        // hum uss session ko le lenge session factory se
        // but hum yaha session ko open kar rhe hai first time ,, isliye open session
        // but ek baar session open ho gaya toh uske baad get current session bhi use kar sakte hai
        Session session = sessionFactory.openSession();

        /*
        // save karne se pehle transaction begin karna padega or fir commit karna padega, physical change karne ke liye
        session.beginTransaction();
        // ab session ko bola ki mere object(ajay) ko save kar do
        session.save(ajay);
        // ab database mein physically changes karne ke liye , jo transaction chal rha hai usko commit karna padega
        session.getTransaction().commit();
        */
        // aisa bhi kar sakte hai,,, hum session begin kar rhe hai ,, isliye begin transaction
        Transaction transaction = session.beginTransaction();
        session.save(ajay);
        transaction.commit();
        session.close();



    }
}
