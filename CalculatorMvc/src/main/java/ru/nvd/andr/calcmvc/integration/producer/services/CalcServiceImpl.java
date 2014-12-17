package ru.nvd.andr.calcmvc.integration.producer.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;
import ru.nvd.andr.calcmvc.integration.producer.faults.ValidationFault;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperRequest;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperResponse;
import ru.nvd.andr.calcmvc.operations.Operation;
import ru.nvd.andr.calcmvc.operations.OperationFactory;
import ru.nvd.andr.calcmvc.service.CalcOperationsService;


@Service
public class CalcServiceImpl implements CalcService {

    @Autowired
    private CalcOperationsService calcOperationsService;
    @Autowired
    private OperationFactory operationFactory;

    public ExecuteOperResponse executeOper(ExecuteOperRequest executeOperRequest) throws ValidationFault {
        if (executeOperRequest==null || executeOperRequest.getFirstArg()==null || executeOperRequest.getFirstArg().trim().isEmpty()) {
            throw new ValidationFault("FIRST ARGUMENT CAN NOT BE NULL OR EMPTY");
        }
        if (executeOperRequest==null || executeOperRequest.getSecondArg()==null || executeOperRequest.getSecondArg().trim().isEmpty()) {
            throw new ValidationFault("SECOND ARGUMENT CAN NOT BE NULL OR EMPTY");
        }
        String operationCode = executeOperRequest.getOperation();
        String firstArg = executeOperRequest.getFirstArg();
        String secondArg = executeOperRequest.getSecondArg();

        Operation operation = operationFactory.createOperation(operationCode);
        Long result = operation.excecute(Long.parseLong(firstArg), Long.parseLong(secondArg));

        TableCalcOperations tableCalcOperations  = new TableCalcOperations();
        tableCalcOperations.setFirstarg(firstArg);
        tableCalcOperations.setSecondarg(secondArg);
        tableCalcOperations.setOperation(operationCode);
        tableCalcOperations.setCreateDate(new Date());
        tableCalcOperations.setUserName("integration");
        calcOperationsService.addTableCalcOperations(tableCalcOperations);  
        ExecuteOperResponse executeOperResponse = new ExecuteOperResponse();
        executeOperResponse.setResult(result.toString());
        return executeOperResponse;

    }


}
