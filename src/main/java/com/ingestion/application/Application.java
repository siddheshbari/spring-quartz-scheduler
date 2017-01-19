package com.ingestion.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-quartz.xml")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quartz","root","password");  
		//here sonoo is database name, root is username and password  
		//Statement stmt=con.createStatement();  
		//ResultSet rs=stmt.executeQuery("select * from dual");  
		
		con.close();  
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
		
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
               // System.out.println(beanName);
            }

        };
    }


}
