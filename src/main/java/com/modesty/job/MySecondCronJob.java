package com.modesty.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;


/**
* @author Modesty
* @Version 2020年4月7日 上午12:58:43
*/
@Component
public class MySecondCronJob extends QuartzJobBean{
	private static final Logger log = LoggerFactory.getLogger(MySecondCronJob.class); 
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		log.info("Modesty[secondJob]:"+new Date()+" name:"+name);
	}
}


/**
* Notes
*/
