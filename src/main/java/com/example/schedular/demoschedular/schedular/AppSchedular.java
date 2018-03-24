package com.example.schedular.demoschedular.schedular;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

@Slf4j
public class AppSchedular {

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void poll1() throws InterruptedException {
      log.info("Polling 1 method Start - Running scheduled task thread: {}, time: {}",
              Thread.currentThread().getName(),
              LocalTime.now());
      Thread.sleep(10000);
      log.info("Polling 1 method End");
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void poll2() throws InterruptedException {
        log.info("Polling 2 method Start - Running scheduled task thread: {}, time: {}",
                Thread.currentThread().getName(),
                LocalTime.now());
        Thread.sleep(10000);
        log.info("Polling 2 method End");
    }
}
