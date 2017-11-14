package dbService;

import dao.historyHistorytableEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import dao.*;
import org.hibernate.query.Query;

/**
 * Created by Roman Zhuravlev on 10.11.2017.
 */
public class CommentsDAO {
    final static Logger logger = Logger.getLogger(CommentsManager.class);
    public static void addData(commentsCommentsEntity orderEntity) throws SQLException {
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
    public static Collection getCustomerComments(String customerName){
        logger.info("getting comment list (DAO)!");
        Session session = null;
        Transaction tx = null;
        List list = new ArrayList<commentsCommentsEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("FROM commentsCommentsEntity  WHERE userNameItem = :customerName ");
            query.setParameter("customerName", customerName);
            list = query.list();
            logger.info("getting comment list (DAO)!_> success!");
// Запрос к БД

            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                commentsCommentsEntity cur = (commentsCommentsEntity) iterator.next();
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
