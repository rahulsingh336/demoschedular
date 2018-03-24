package com.example.schedular.demoschedular.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

@RestController
@Slf4j
public class ShutDownController {

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public String shutDownPoller() throws InterruptedException {
      log.info("Shuting Down Poller, Start");

        ConcurrentTaskExecutor exec = (ConcurrentTaskExecutor) context.getBean("task");
        ExecutorService es = (ExecutorService) exec.getConcurrentExecutor();
        es.shutdown();
        while (!es.isTerminated()){
            log.info("signaled shutdown, waiting for tasks to complete");
            Thread.sleep(2000);
        }

      log.info("Shutdown Poller, Done");

        return "OK";
    }
}
