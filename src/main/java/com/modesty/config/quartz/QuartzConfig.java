package com.modesty.config.quartz;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.modesty.job.MyFirstSimpleJob;
import com.modesty.job.MySecondCronJob;

/**
* @author Modesty
* @Version 2020年4月7日 上午12:39:48
*/

@Configuration
public class QuartzConfig {
//	@Bean
//	MethodInvokingJobDetailFactoryBean jobDetail1() {
//		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
//		bean.setTargetClass(MyFirstSimpleJob.class);
//		bean.setTargetMethod("firstJob");
//		return bean;
//	}
	
	@Bean
	JobDetailFactoryBean jobDetail2() {
		JobDetailFactoryBean bean = new JobDetailFactoryBean();
		bean.setJobClass(MySecondCronJob.class);
		JobDataMap jobData = new JobDataMap();
		jobData.put("name", "马谦理");
		bean.setJobDataMap(jobData);
		bean.setDurability(true);
		return bean;
	}
	
//	@Bean
//	SimpleTriggerFactoryBean simpleTrigger() {
//		SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
//		bean.setJobDetail(jobDetail1().getObject());
//		bean.setRepeatCount(3);
//		bean.setStartDelay(8000);
//		bean.setRepeatInterval(5000);
//		return bean;
//	}
	
	@Bean
	CronTriggerFactoryBean cronTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(jobDetail2().getObject());
		bean.setCronExpression("0/15 * * * * ?");
		return bean;
	}
	
	@Bean
	SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
//		SimpleTrigger simpleTrigger = simpleTrigger().getObject();
		CronTrigger cronTrigger = cronTrigger().getObject();
//		bean.setTriggers(simpleTrigger,cronTrigger);
		bean.setTriggers(cronTrigger);
		return bean;
	}
}


/**
* Notes
* 1.1 JobDetail 通过MethodInvokingJobDetailFactoryBean指定实例和调用方法,无法传递参数
* 1.2 JobDetail 通过JobDetailFactoryBean实现,只需指定对应JobClass,通过JobData传递到Job中,Job需提供属性名
* 
* 2. SimpleTrigger   CronTrigger
* 3. SchedulerFactoryBean进行注册
*/
