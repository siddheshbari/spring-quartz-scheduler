package com.ingestion.job;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.pig.PigTemplate;
import org.springframework.stereotype.Service;

@Service("pigConnection")
public class PigConnection {

	@Autowired
	private PigTemplate template;
	
	private String name;
	String script ="A = LOAD 'src/main/resources/Upload.csv' USING PigStorage() AS (name:chararray, age:int);" ;
	
	@PostConstruct
	public void testPigScript() {
		template.executeScript(script);
		System.out.println("test pig script");
	}

	public void excute() {
		template.executeScript(script);
	}
	
	

	
}
