package ru.atc.Calcula.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.atc.Calcula.intf.Operation;


public class OperationFactory {
	@SuppressWarnings("resource")
	public Operation createOperation(String code) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"file:src/main/resources/META-INF/config.xml"});
		return (Operation)ac.getBean(code);
	}
}
