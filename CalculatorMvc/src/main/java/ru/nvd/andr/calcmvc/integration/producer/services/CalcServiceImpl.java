package ru.nvd.andr.calcmvc.integration.producer.services;

import org.springframework.stereotype.Service;

import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperRequest;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperResponse;
import ru.nvd.andr.calcmvc.operations.Operation;
import ru.nvd.andr.calcmvc.operations.OperationFactory;

@Service
public class CalcServiceImpl implements CalcService {

    public ExecuteOperResponse executeOper(ExecuteOperRequest executeOperRequest) {
        String operationCode = executeOperRequest.getOperation();
        String firstArg = executeOperRequest.getFirstArg();
        String secondArg = executeOperRequest.getSecondArg();

        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.createOperation(operationCode);
        Long result = operation.excecute(Long.parseLong(firstArg), Long.parseLong(secondArg));

        ExecuteOperResponse executeOperResponse = new ExecuteOperResponse();

        executeOperResponse.setResult(result.toString());

        return executeOperResponse;

    }

}
