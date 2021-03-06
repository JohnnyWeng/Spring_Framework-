package com.study.Spring.case04.mvc.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component

public class User implements Serializable{
	private String name;
	private int age;
	
	// 建構子共同實作段
	{
		System.out.println("User");
	}
	
	public User() { // 無參數建構子
	}
	
	public User(String name, int age) { 
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]"; 
	}
}




