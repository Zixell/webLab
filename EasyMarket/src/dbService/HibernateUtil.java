package dbService;

//import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //final static Logger logger = Logger.getLogger(HibernateUtil.class);
    //final static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
            sessionFactory =cfg.configure().buildSessionFactory();
        } catch (Throwable ex) {
            //logger.error("Error while init Hibernate");
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}




