package ru.geekbrains.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.hibernate.*;

import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {
       PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

    try {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press customer id to watch products that client buy");
            long clientId = scanner.nextInt();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Customers customer = session.get(Customers.class, clientId);

            System.out.println(customer + "\n" + "buy");
            System.out.println(customer.getProducts());
        }
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        factory.close();
        if (session != null){
            session.close();
        }
    }


    }
}
