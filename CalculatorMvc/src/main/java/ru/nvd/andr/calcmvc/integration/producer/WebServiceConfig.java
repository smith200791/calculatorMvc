package ru.nvd.andr.calcmvc.integration.producer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
//
//@EnableWs
//@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
//	@Bean
//	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
//		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//		servlet.setApplicationContext(applicationContext);
//		servlet.setTransformWsdlLocations(true);
//		return new ServletRegistrationBean(servlet, "/ws/*");
//	}
//
//	@Bean(name = "calcService")
//	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema calcServiceSchema) {
//		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//		wsdl11Definition.setPortTypeName("CalcServicePort");
//		wsdl11Definition.setLocationUri("/ws");
//		wsdl11Definition.setTargetNamespace("http://spring.ru/nvd/andr/calcmvc/integration/generated");
//		wsdl11Definition.setSchema(calcServiceSchema);
//		return wsdl11Definition;
//	}
//
//	@Bean
//	public XsdSchema calcServiceSchema() {
//		return new SimpleXsdSchema(new ClassPathResource("calcService.xsd"));
//	}
}
