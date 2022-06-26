package ru.geekbrains.hibernate;

//import com.flamexander.hibernate.PrepareDataApp;


import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.Collections;

public class MainApp {

    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();
    }
}
