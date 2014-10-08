package factory;

import intf.Operation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OperationFactory {
	@SuppressWarnings("resource")
	public Operation createOperation(String code) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
		return (Operation)ac.getBean(code);
	}
}
