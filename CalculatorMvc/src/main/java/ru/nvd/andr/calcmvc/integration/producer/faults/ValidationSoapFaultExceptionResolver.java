package ru.nvd.andr.calcmvc.integration.producer.faults;

import java.util.Properties;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultAnnotationExceptionResolver;

public class ValidationSoapFaultExceptionResolver extends SoapFaultAnnotationExceptionResolver {
    private static final QName CODE = new QName("VALID");
    private static final QName SUB_CODE = new QName("001");
    private static final QName REASON = new QName("REASON");
    private Properties exceptionMappings;

    public Properties getExceptionMappings() {
        return exceptionMappings;
    }

    public void setExceptionMappings(Properties exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }
    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        SoapFaultDetail detail = fault.addFaultDetail();
        detail.addFaultDetailElement(CODE).addText(ex.getClass().toString());
        detail.addFaultDetailElement(SUB_CODE);
        detail.addFaultDetailElement(REASON).addText(ex.getStackTrace().toString());;

    }

}
