package com.msp.dbHelper;

import com.msp.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
//    private static DBHelper instance;
//    private java.sql.Connection connection;
//    private SessionFactory sessionFactory;
//
//    private DBHelper() {
//    }
//
//    public static synchronized DBHelper getInstance(){
//        if(instance == null){
//            instance = new DBHelper();
//        }
//        return instance;
//    }
//
//
//    public Connection getConnection() {
//        Properties properties = new Properties();
//        try {
//            properties.load(DBHelper.class.getResourceAsStream("/com.msp.config.properties"));
//        } catch (IOException e) {
//            System.err.println("IOException in method getConnection");
//        }
//
//        try {
//            Class.forName(properties.getProperty("db.driver_class"));
//        } catch (ClassNotFoundException e){
//            System.err.println("ClassNotFoundException in method getConnection");
//        }
//        try {
//            connection = DriverManager.getConnection(properties.getProperty("db.url"),
//                    properties.getProperty("db.username"), properties.getProperty("db.password"));
//        } catch (SQLException e) {
//            System.err.println("SQLException in method getConnection");
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public Configuration getConfiguration(){
//        //path to properties
//        Properties properties = new Properties();
//        try {
//            properties.load(DBHelper.class.getResourceAsStream("/com.msp.config.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Create configuration
//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(User.class);
//
//        configuration.setProperty("hibernate.dialect", properties.getProperty("hibernate.dialect"));
//        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("db.driver_class"));
//        configuration.setProperty("hibernate.connection.url", properties.getProperty("db.url"));
//        configuration.setProperty("hibernate.connection.username", properties.getProperty("db.username"));
//        configuration.setProperty("hibernate.connection.password", properties.getProperty("db.password"));
//        configuration.setProperty("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
//        configuration.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
//
//        return configuration;
//    }
}
