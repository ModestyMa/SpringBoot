package com.modesty.job;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* @author Modesty
* @Version 2020年4月7日 上午12:57:41
*/

@Component
public class MyFirstSimpleJob {
	private static final Logger log = LoggerFactory.getLogger(MyFirstSimpleJob.class); 
	public void firstJob() {
		log.info("Modesty[fistJob]:"+new Date());
	}
}


/**
* Notes
*/
