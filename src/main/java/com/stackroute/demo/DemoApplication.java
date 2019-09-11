package com.stackroute.demo;

//import com.stackroute.demo.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//DataService dataService=new DataService();
//dataService.send();
//		ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
//		DataService dataService = context.getBean("dataService", DataService.class);
////		dataService.send();
//		dataService.listen("hello");
//		DemoApplication d=new DemoApplication();
//		d.listen("message");
	}
//	@KafkaListener(topics = "userTopic5",groupId = "sample-group",containerFactory = "KafkaListener")
//	public void listen(String message) {
//		System.out.println("Received Messasge in group foo: " + message);
//	}

}
