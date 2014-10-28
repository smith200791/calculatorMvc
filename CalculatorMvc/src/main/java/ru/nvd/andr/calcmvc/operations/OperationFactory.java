package ru.nvd.andr.calcmvc.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OperationFactory {
    @Autowired
    private Operation oper;

    public Operation createOperation(String code) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("WEB-INF/spring/beans.xml");
        oper = (Operation) ac.getBean(code);
        ac.close();
        if (oper == null) {
            throw new RuntimeException("Bean by id = " + code + " not found coud not initialize or not found in spring config xml");
        }
        return oper;
    }
}
