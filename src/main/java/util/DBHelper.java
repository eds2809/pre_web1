package util;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public static DBHelper instance = new DBHelper();

    /*private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }*/

    @SuppressWarnings("UnusedDeclaration")
   /* private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(DailyReport.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "Bcv8wsr");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        //То что добавлял я
        configuration.setProperty("hibernate.connection.zeroDateTimeBehavior", "convertToNull");
        configuration.setProperty("hibernate.connection.CharSet", "utf8");
        configuration.setProperty("hibernate.connection.characterEncoding", "utf8");
        configuration.setProperty("hibernate.connection.useUnicode", "true");

        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cars?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf-8");


        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }*/

    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("users?").          //db name
                    append("user=root&").          //login
                    append("password=Bcv8wsr");       //password

            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

}
