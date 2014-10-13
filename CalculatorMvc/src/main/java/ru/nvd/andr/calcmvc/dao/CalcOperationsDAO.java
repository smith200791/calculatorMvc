package ru.nvd.andr.calcmvc.dao;

import java.util.List;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

public interface CalcOperationsDAO {

    public void addCalcOperaton(TableCalcOperations calcOperations);

    public List<TableCalcOperations> listCalcOperations();

    public void removeCalcOperation(long objid);

}
