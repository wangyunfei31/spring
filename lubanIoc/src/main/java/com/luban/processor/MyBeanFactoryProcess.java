package com.luban.processor;

import com.luban.dao.IndexDao1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 12803
 * @Date 2020/7/9 14:46
 */
public class MyBeanFactoryProcess implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		IndexDao1 dao = (IndexDao1)beanFactory.getBean("userDao");
		Object dao1 = Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("代理对象");
				method.invoke(dao,args);
				return null;
			}
		});
		AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(dao1.getClass());
		((BeanDefinitionRegistry)beanFactory).registerBeanDefinition("myDao",annotatedGenericBeanDefinition);

	}
}
