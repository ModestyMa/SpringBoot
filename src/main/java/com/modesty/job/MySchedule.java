package com.modesty.job;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
* @author Modesty
* @Version 2020年4月7日 上午12:17:44
*/

@Component
public class MySchedule {
	private static final Logger log = LoggerFactory.getLogger(MySchedule.class); 

	@Scheduled(fixedDelay = 5000)				//当前任务结束5s,开启另一个任务
	public void fixedDelay() {
		log.info("[MySchedule]fixedDelay:"+new Date());
	}
	
	@Scheduled(fixedRate = 10000)				//当前任务执行10s后,开启另一个任务
	public void fixedRate() {
		log.info("[MySchedule]fixedRate:"+new Date());
	}
	
	@Scheduled(initialDelay = 12000,fixedDelay = 2000)	//首次执行延迟时间12s,2s后开启另一个任务
	public void initialDelay() {
		log.info("[MySchedule]initialDelay:"+new Date());
	}
	
	@Scheduled(cron = "0 * * * * ?")					//每分钟执行一次
	public void cron() {
		log.info("[MySchedule]cron:"+new Date());
	}
}


/**
* Notes
*/
