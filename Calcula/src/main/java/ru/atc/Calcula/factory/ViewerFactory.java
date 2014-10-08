package ru.atc.Calcula.factory;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.atc.Calcula.intf.Viewer;
@SuppressWarnings("resource")
public class ViewerFactory {
	public Viewer createView(String code) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"file:src/main/resources/META-INF/config.xml"});
        return (Viewer)ac.getBean(code);
	}
}
