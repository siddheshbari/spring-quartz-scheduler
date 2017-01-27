package com.ingestion.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;



public class UploadFileJob extends QuartzJobBean {

	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		 PigConnection pigConnect = (PigConnection) ApplicationContextProvider.getBean("pigConnection", PigConnection.class);
		 pigConnect.excute();
	}


}
