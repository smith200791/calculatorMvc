package ru.nvd.andr.calcmvc.integration.producer.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperRequest;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperResponse;
import ru.nvd.andr.calcmvc.integration.producer.services.CalcService;


@Endpoint
public class CalcServiceEndpoint {

    private static final String NAMESPACE_URI = "http://spring.ru/nvd/andr/calcmvc/integration/generated";
    
    @Autowired
    private CalcService calcService;

    @PayloadRoot(localPart = "executeOper", namespace = NAMESPACE_URI)
    public @ResponsePayload ExecuteOperResponse executeOper(@RequestPayload ExecuteOperRequest request) {
        return calcService.executeOper(request);
    }

}
