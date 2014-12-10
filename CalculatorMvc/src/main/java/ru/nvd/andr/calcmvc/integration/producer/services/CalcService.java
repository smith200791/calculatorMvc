package ru.nvd.andr.calcmvc.integration.producer.services;

import ru.nvd.andr.calcmvc.integration.producer.faults.ValidationFault;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperRequest;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperResponse;

public interface CalcService {
    
    public ExecuteOperResponse executeOper(ExecuteOperRequest executeOperRequest) throws ValidationFault;
}
