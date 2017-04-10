package com.finra.schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class FinraScheduler {
	private static final Logger log = LoggerFactory.getLogger(FinraScheduler.class);
    
    private static final long INITIAL_DELAY = 60000L; // 60 seconds
    private static final long PERIOD = 60000L;

    /*
     * task scheduled for every hour (a 60s after completion of previous task)
     */
    @Scheduled(initialDelay=INITIAL_DELAY, fixedDelay = PERIOD)
    public void pollAndEmail() {
    	
    	
    }
}
