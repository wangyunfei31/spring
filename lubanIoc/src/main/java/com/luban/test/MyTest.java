package com.luban.test;

import com.luban.app.Appconfig;
import com.luban.dao.Dao;
import com.luban.dao.IndexDao1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author 12803
 * @Date 2020/7/9 11:43
 */
public class MyTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
		Dao dao = (Dao)annotationConfigApplicationContext.getBean("myDao");
		dao.query();
	}
}
