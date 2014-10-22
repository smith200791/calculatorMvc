package ru.nvd.andr.calcmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

@Repository
@Transactional
public class CalcOperationsDAOImpl implements CalcOperationsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCalcOperaton(TableCalcOperations calcOperations) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(calcOperations);
        currentSession.flush();
    }

    @SuppressWarnings("unchecked")
    public List<TableCalcOperations> listCalcOperations() {
        return sessionFactory.getCurrentSession().createQuery("from TableCalcOperations").list();
    }

    public void removeCalcOperation(long objid) {
        Session currentSession = sessionFactory.getCurrentSession();
        TableCalcOperations calcOperations = (TableCalcOperations) currentSession.load(TableCalcOperations.class, objid);
        if (calcOperations != null) {
            currentSession.delete(calcOperations);
            currentSession.flush();
        }
    }

}
