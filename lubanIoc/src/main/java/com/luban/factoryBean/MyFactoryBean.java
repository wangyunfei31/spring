package com.luban.factoryBean;

import com.luban.anno.MySelect;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 12803
 * @Date 2020/7/9 20:29
 */
public class MyFactoryBean implements FactoryBean , InvocationHandler {
	private Class obj;
	public MyFactoryBean(Class obj){
		this.obj = obj;
	}
	@Override
	public Object getObject() throws Exception {
		Class[] clazzs = new Class[]{obj};
		return Proxy.newProxyInstance(obj.getClassLoader(),clazzs,this);
	}

	@Override
	public Class<?> getObjectType() {
		return obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy");

		Class[] types = null;
		String arg = "";
		if(args != null){
			types = new Class[args.length];
			for(int i=0;i<args.length;i++){
				if(args[i] instanceof  String){
					types[i] = String.class;
					arg = (String)args[i];
				}
			}
		}

		Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(),types);
		MySelect mySelect = method1.getDeclaredAnnotation(MySelect.class);
		System.out.println(mySelect.value()+"属性"+arg);
		return null;
		//return method.invoke(obj,args);
	}
}
