package com.modesty.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
* @author Modesty
* @Version 2020年4月7日 上午2:40:27
*/

@RestController
@Api("Batch测试程序")
@RequestMapping("/batch")
public class BatchTestController {
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;
	
	@GetMapping("startBatch")
	public void hello() {
		try {
			jobLauncher.run(job, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


/**
* Notes
*/
