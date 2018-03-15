package com.msp.dao;

import com.msp.dbHelper.DBHelper;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class UsersDaoFactory {
//        private static final String PATH_TO_PROPERTIES = "/com.msp.config.properties";
//
//        public static UsersDAO getUsersDAO(){
//            Properties property = new Properties();
//
//            try{
//                property.load(UsersDaoFactory.class.getResourceAsStream(PATH_TO_PROPERTIES));
//            } catch (IOException e){
//                System.err.println("file " + PATH_TO_PROPERTIES + " does not exist");
//            }
//
//            if(property.getProperty("com.msp.dao").equals("hibernate")){
//                return new UsersDaoHibernateImpl(createSessionFactory(DBHelper.getInstance().getConfiguration()));
//            } else {
//                return new UsersDaoJdbcImpl(DBHelper.getInstance().getConnection());
//            }
//        }
//
//    private static SessionFactory createSessionFactory(org.hibernate.cfg.Configuration configuration) {
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
//        builder.applySettings(configuration.getProperties());
//        ServiceRegistry serviceRegistry = builder.build();
//        return configuration.buildSessionFactory(serviceRegistry);
//    }
}
