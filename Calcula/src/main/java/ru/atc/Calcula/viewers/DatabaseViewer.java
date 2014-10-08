package ru.atc.Calcula.viewers;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.atc.Calcula.database.HibernateUtils;
import ru.atc.Calcula.database.TableCalcOperations;
import ru.atc.Calcula.intf.Viewer;

public class DatabaseViewer implements Viewer {

    private static SessionFactory sessionFactory;

    public void onView(Double result) {
        try {
           
            sessionFactory = HibernateUtils.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            TableCalcOperations tableCalcOperations = new TableCalcOperations();
            tableCalcOperations.setResult(result.toString());
            tableCalcOperations.setCreateDate(new Date());
            session.save(tableCalcOperations);
            session.getTransaction().commit();
            System.out.println("insert success");
            selectResult(session);
        } catch (Exception e) {
            throw new HibernateError("Error of exceute insert in database - result : " + result, e);
        }
    }

    private void selectResult(Session session) {
        @SuppressWarnings("unchecked")
        List<TableCalcOperations> tableCalcOperations = (List<TableCalcOperations>) session.createQuery("from TableCalcOperations").list();
        for (TableCalcOperations tableCalcOperations2 : tableCalcOperations) {
            System.out.println(tableCalcOperations2.getResult());
        }
    }

}
