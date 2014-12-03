package ru.nvd.andr.calcmvc.integration.producer.services;

import org.springframework.stereotype.Service;

import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperRequest;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperResponse;

@Service
public class CalcServiceImpl implements CalcService {

    public ExecuteOperResponse executeOper(ExecuteOperRequest executeOperRequest) {
        
        ExecuteOperResponse executeOperResponse = new ExecuteOperResponse();
        executeOperResponse.setResult("123");
        return executeOperResponse;
        
    }

}
