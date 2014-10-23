    package ru.nvd.andr.calcmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.nvd.andr.calcmvc.dao.CalcOperationsDAO;
import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

@Service
public class CalcOperationsServiceImpl implements CalcOperationsService {

    @Autowired
    private CalcOperationsDAO calcOperationsDAO;
            

    @Transactional //обязательная анотация, говорит о том это это транзакционная операция
    public void addTableCalcOperations(TableCalcOperations calcOperations) {
        calcOperationsDAO.addCalcOperaton(calcOperations);
    }


    @Transactional
    public List<TableCalcOperations> listTableCalcOperations() {
        return calcOperationsDAO.listCalcOperations();
    }


    @Transactional
    public void removeTableCalcOperations(Long objid) {
        calcOperationsDAO.removeCalcOperation(objid);
    }

}
