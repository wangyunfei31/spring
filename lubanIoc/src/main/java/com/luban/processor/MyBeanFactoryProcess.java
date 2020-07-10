package com.luban.processor;

import com.luban.dao.Dao;
import com.luban.dao.IndexDao1;
import com.luban.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;

/**
 * @Author 12803
 * @Date 2020/7/9 14:46
 */
public class MyBeanFactoryProcess implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Dao dao = (Dao)beanFactory.getBean("userDao");
		System.out.println(dao.getClass());
		Iterator<String> itrator = beanFactory.getBeanNamesIterator();
		while(itrator.hasNext()){
			String next = itrator.next();
			System.out.println(next);
		}
//		Object dao1 = Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println("代理对象");
//				return method.invoke(dao,args);
//			}
//		});
//		AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(dao1.getClass());
//		annotatedGenericBeanDefinition.setBeanClass(Proxy.class);
		//((BeanDefinitionRegistry)beanFactory).registerBeanDefinition("myDao",annotatedGenericBeanDefinition);

	}
}
