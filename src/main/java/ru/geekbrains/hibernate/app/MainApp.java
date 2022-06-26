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


        System.out.println("Press: '/customer' to inspect products that client buy");
        System.out.println("Press: '/product' to inspect customers that buy certain product");
        System.out.println("Press: '/break' to exit");
        System.out.println("Press: '/dell_customer' to delete customer");
        System.out.println("Press: '/dell_product' to delete customer");




        session = factory.getCurrentSession();
        session.beginTransaction();
//        Customers customer1 = session.get(Customers.class, 1);
//            System.out.println("Loaded item after remove: " + removedSimpleItem);
//            session.getTransaction().commit()


        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            if (name.equals("/customer")){
                while (true) {
                Scanner customerId = new Scanner(System.in);
                System.out.println("Press customer id to watch products that client buy");
                System.out.println("Press /break to exit");
                String clientId = customerId.nextLine();

                if (clientId.equals("/break")){
                    break;
                }else {
                    Customers customer = session.get(Customers.class, Long.parseLong(clientId));
                    System.out.println(customer + "\n" + "buy");
                    System.out.println(customer.getProducts());
                }
            }
        }else if (name.equals("/product")){
                while (true) {
                    Scanner customerId = new Scanner(System.in);
                    System.out.println("Press product id to watch customers that buy product");
                    System.out.println("Press /break to exit");

                    String productId = customerId.nextLine();

                    if (productId.equals("/break")) {
                        break;
                    } else {
                        Products product = session.get(Products.class, Long.parseLong(productId));
                        System.out.println(product + "\n" + "buy");
                        System.out.println(product.getCustomers());
                    }
                }
            } else if (name.equals("/dell_customer")) {
                while (true) {
                    System.out.println("Press customer_id to delete customer");
                    System.out.println("/break to exit");
                    Scanner scanner1 = new Scanner(System.in);
                    String customerId = scanner1.nextLine();
                    if (customerId.equals("/break")){
                        break;
                    }else {
                        Customers customer = session.get(Customers.class, Long.parseLong(customerId));
                        session.delete(customer);
                    }
                }
            }else if (name.equals("/dell_product")){
                while (true) {
                    System.out.println("Press product_id to delete product");
                    System.out.println("/break to exit");
                    Scanner scanner1 = new Scanner(System.in);
                    String productId = scanner1.nextLine();
                    if (productId.equals("/break")){
                        break;
                    }else {
                        Products product = session.get(Products.class, Long.parseLong(productId));
                        session.delete(product);
                    }
                }
            }
            session.getTransaction().commit();
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
