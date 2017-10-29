/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName Aplication
 * @Description: TODO
 * @author willie
 * @Date: 2017年6月18日 
 */
@SpringBootApplication
@ComponentScan(basePackages ="com.oneyear.bluework")
@MapperScan(basePackages = "com.oneyear.bluework.dao")
public class Application {
	
	
	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

}
