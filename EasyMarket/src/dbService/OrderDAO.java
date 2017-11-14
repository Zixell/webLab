package dbService;

//import org.apache.log4j.Logger;
import dao.historyHistorytableEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class OrderDAO {
    final static Logger logger = Logger.getLogger(OrderDAO.class);
    public static void addData(historyHistorytableEntity orderEntity) throws SQLException {
        logger.info("Adding OrderEntity to DB");
        Session session = null;
        try {
            logger.info("Try to add OrderEntity to DB");
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(orderEntity);
            session.getTransaction().commit();
            logger.info("Try to add OrderEntity to DB _ > Success!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "������ ��� �������", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }
    public static Collection getCustomerOrders(){
        logger.info("Try to get Customer orders by ID  from DB _ > Success!");
        Session session = null;
        Transaction tx = null;
        List list = new ArrayList<historyHistorytableEntity>();
        try {
            logger.info("Try to get Customer orders by ID  from DB");
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            list = session.createQuery("FROM historyHistorytableEntity").list();
            logger.info("Try to get Customer orders by ID  from DB _ > Success!");
// Запрос к БД

            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                historyHistorytableEntity cur = (historyHistorytableEntity) iterator.next();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}
