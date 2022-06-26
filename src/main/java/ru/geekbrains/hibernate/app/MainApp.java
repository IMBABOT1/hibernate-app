package ru.geekbrains.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.hibernate.*;


public class MainApp {

    public static void main(String[] args) {
       PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
