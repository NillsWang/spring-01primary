package com.wmz.service;

public class SomeServiceImpl implements ISomeService {
	
	//一个没有成员变量的对象在堆内存中占8个字节
	//一个有成员变量的对象在堆内存中占8个字节+成员变量所占字节数
	
	public SomeServiceImpl() {
		System.out.println("=======创建对象========");
	}

	@Override
	public String doFirst() {
		// TODO Auto-generated method stub
		System.out.println("执行doFirst方法");
		return "abcde";
	}

	@Override
	public void doSecond() {
		// TODO Auto-generated method stub
		System.out.println("执行doSecond方法");

	}

}
