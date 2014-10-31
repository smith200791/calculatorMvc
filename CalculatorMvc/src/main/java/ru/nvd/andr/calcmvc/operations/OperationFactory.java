package ru.nvd.andr.calcmvc.operations;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OperationFactory {

    public Operation createOperation(String code) {
        // Андрей, запомни и запиши, путь пишется такой, где реально лежит твой файл, а лежит он на сервере
        // на понимание этого ушла неделя
        // понял 31.10
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"file:/opt/tomcat8/apache-tomcat-8.0.12/webapps/CalculatorMvc/WEB-INF/spring/beans.xml"});
        //не гибко однако 
        Operation oper = (Operation) ac.getBean(code);
        ac.close();
        if (oper == null) {
            throw new RuntimeException("Bean by id = " + code + " not found coud not initialize or not found in spring config xml");
        }

        return oper;

    }
}
