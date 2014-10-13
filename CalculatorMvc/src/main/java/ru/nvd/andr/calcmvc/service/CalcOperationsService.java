package ru.nvd.andr.calcmvc.service;

import java.util.List;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

public interface CalcOperationsService {
    public void addTableCalcOperations(TableCalcOperations TableCalcOperations);

    public List<TableCalcOperations> listTableCalcOperations();

    public void removeTableCalcOperations(Integer objid);

}
