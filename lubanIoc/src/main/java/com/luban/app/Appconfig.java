package com.luban.app;

import com.luban.anno.EanbleScan;
import org.springframework.context.annotation.*;
@ComponentScan({"com.luban"})
@Configuration
@EanbleScan
public class Appconfig {

//	@Bean
//	public IndexDao1 indexDao1(){
//
//		return new IndexDao1();
//	}
//
//	@Bean
//	public IndexDao indexDao(){
//		indexDao1();
//		indexDao1();
//		return new IndexDao();
//	}
}
