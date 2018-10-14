package com.jbit.dto;
/**
 *
 *@author 栗子
 *@description 单例模式--饿汉
 */
public class Singleton {
	private Singleton(){//1.构造私有化化
		
	}
	private static Singleton singleton=new Singleton();
	public static Singleton getIntance(){
		return singleton;
	}
	public static void main(String []args){
		Singleton s1=Singleton.getIntance();
		Singleton s2=Singleton.getIntance();
		System.out.println(s1==s2);
	}
}
