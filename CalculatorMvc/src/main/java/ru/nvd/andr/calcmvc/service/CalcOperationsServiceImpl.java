package ru.nvd.andr.calcmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.nvd.andr.calcmvc.dao.CalcOperationsDAO;
import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

public class CalcOperationsServiceImpl implements CalcOperationsService {

    @Autowired
    private CalcOperationsDAO calcOperationsDAO;

    @Override
    public void addTableCalcOperations(TableCalcOperations calcOperations) {
        calcOperationsDAO.addCalcOperaton(calcOperations);
    }

    @Override
    public List<TableCalcOperations> listTableCalcOperations() {
        return calcOperationsDAO.listCalcOperations();
    }

    @Override
    public void removeTableCalcOperations(Integer objid) {
        calcOperationsDAO.removeCalcOperation(objid);
    }

}
