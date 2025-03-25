package main.java.org.example.hibernate.util;

import main.java.org.example.hibernate.entity.Employee;
import main.java.org.example.hibernate.entity.Job;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put("hibernate.connection.driver_class", "org.h2.Driver");
                settings.put("hibernate.hbm2ddl.auto", "create-drop");
                settings.put("hibernate.connection.url", "jdbc:h2:mem:default");
                settings.put("hibernate.connection.username", "admin");
                settings.put("hibernate.connection.password", "password");
                //settings.put("hibernate.show_sql", "true");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Job.class);
                configuration.addAnnotatedClass(Employee.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    };
}
