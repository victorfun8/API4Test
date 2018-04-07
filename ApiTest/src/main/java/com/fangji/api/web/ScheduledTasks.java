package com.fangji.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by fangji on 2018/2/23.
 */
@Component
public class ScheduledTasks {
    private final static Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrTime() {
//        log.info("now is {}", dateFormat.format(new Date()));
    }
}
