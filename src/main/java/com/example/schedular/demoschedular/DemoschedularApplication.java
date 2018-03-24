package com.example.schedular.demoschedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

@SpringBootApplication
public class DemoschedularApplication {

	@Autowired
	private ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(DemoschedularApplication.class, args);
	}

	private void stopExecutor(){
		ConcurrentTaskExecutor exec = (ConcurrentTaskExecutor) context.getBean("task");
		ExecutorService es = (ExecutorService) exec.getConcurrentExecutor();
		System.out.println(es.isShutdown());
		//es.shutdownNow();
	}

	/*@PostConstruct
	void registerShutDownHook(){

		stopExecutor();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Running Shutdown Hook");
			}
		});
	}*/
}
