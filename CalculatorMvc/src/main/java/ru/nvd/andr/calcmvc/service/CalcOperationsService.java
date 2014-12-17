package ru.nvd.andr.calcmvc.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

public interface CalcOperationsService {
//    
//    @Secured("ROLE_USER")
    public void addTableCalcOperations(TableCalcOperations TableCalcOperations);

    public List<TableCalcOperations> listTableCalcOperations();
//    
//    @Secured("ROLE_ADMIN")  
    public void removeTableCalcOperations(Long objid);

}
