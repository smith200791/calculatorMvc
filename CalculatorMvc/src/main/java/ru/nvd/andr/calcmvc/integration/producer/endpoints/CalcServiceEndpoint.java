package ru.nvd.andr.calcmvc.integration.producer.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.nvd.andr.calcmvc.integration.producer.faults.ValidationFault;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperRequest;
import ru.nvd.andr.calcmvc.integration.producer.gen.ExecuteOperResponse;
import ru.nvd.andr.calcmvc.integration.producer.services.CalcService;


@Endpoint
public class CalcServiceEndpoint {
    private static final String TARGET_NAMESPACE = "http://webservices.samples.blog.com";

    
    @Autowired
    private CalcService calcService;

    @PayloadRoot(localPart = "executeOperRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload ExecuteOperResponse executeOper(@RequestPayload ExecuteOperRequest executeOperRequest) throws  ValidationFault {
        return calcService.executeOper(executeOperRequest);
    }

}
