package com.ingestion.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class UploadFileJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		 System.out.println("Upload file job");
	}

}
