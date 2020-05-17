package com.wmz.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.wmz.service.ISomeService;
import com.wmz.service.SomeServiceImpl;

@SuppressWarnings("deprecation")
public class MyTest {
	
	@Test
	public void test01() {
		ISomeService service = new SomeServiceImpl();
		service.doFirst();
		service.doSecond();
			
	}
	
	@Test
	public void test02() {
		//从类路径中找xml文件，这里的配置文件存放在src下
		//加载spring配置文件，创建spring容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容其中获取指定bean对象
		ISomeService service = ac.getBean("someService", ISomeService.class);
		service.doFirst();
		service.doSecond();
			
	}

	@Test
	public void test03() {
		//从文件系统中找xml文件，这里的配置文件存放在项目下
		//加载spring配置文件，创建spring容器对象
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		//从容其中获取指定bean对象
		ISomeService service = (ISomeService) ac.getBean("someService");
		service.doFirst();
		service.doSecond();
			
	}
	
	@Test
	public void test04() {
		//从文件系统中找xml文件，这里的配置文件存放在d:/下
		//加载spring配置文件，创建spring容器对象
		ApplicationContext ac = new FileSystemXmlApplicationContext("d:/applicationContext.xml");
		//从容其中获取指定bean对象
		ISomeService service = (ISomeService) ac.getBean("someService");
		service.doFirst();
		service.doSecond();
			
	}
	//ApplicationContext与BeanFactory的区别：
	// 1）ApplicationContext容器在进行初始化的时候会将容器中的所有Bean(对象)进行创建
	//		缺点：占系统资源
	//		优点：响应快
	// 2）BeanFactory容器中的对象，在进容器行初始化的时不会被创建，而是在真正获取对象时才创建
	//		优点：占系统资源少
	//		缺点：响应相对慢
	
	@Test
	public void test05() {
		//这个容器中的对象不是在容器初始化时创建的而是在真正使用时创建，类似延迟加载
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//从容其中获取指定bean对象
		ISomeService service = (ISomeService) bf.getBean("someService");
		service.doFirst();
		service.doSecond();
			
	}
	
}
