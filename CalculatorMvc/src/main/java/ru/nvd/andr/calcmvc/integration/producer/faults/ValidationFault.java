package ru.nvd.andr.calcmvc.integration.producer.faults;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class ValidationFault extends Exception {

    /**
     * 
     */
    
    private static final long serialVersionUID = 1L;

    public ValidationFault() {
        super();
    }

    public ValidationFault(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidationFault(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationFault(String message) {
        super(message);
    }

    public ValidationFault(Throwable cause) {
        super(cause);
    }
    

}
