package Util;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory SESSION_FACTORY =null;
    static {
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SESSION_FACTORY=configuration.buildSessionFactory();

    }
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
