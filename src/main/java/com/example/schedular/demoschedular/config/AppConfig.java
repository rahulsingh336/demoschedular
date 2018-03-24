package com.example.schedular.demoschedular.config;

import com.example.schedular.demoschedular.schedular.AppSchedular;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public AppSchedular getSchedular(){
        return new AppSchedular();
    }

    @Bean(name = "task")
    public TaskScheduler taskExecutor () {
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        return new ConcurrentTaskScheduler((ScheduledExecutorService) scheduledExecutorService);
    }
}
