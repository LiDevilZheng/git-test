package com.jbit.dto;
/**
 *
 *@author 栗子
 *@description 单例模式--懒汉
 */
public class Singleton2 {
	private static Singleton2 singleton=null;
	private Singleton2(){
		
	}
	public static synchronized Singleton2 getIntance(){
		if(singleton==null){
			singleton=new Singleton2();
		}
		return singleton;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton2 s1=Singleton2.getIntance();
		Singleton2 s2=Singleton2.getIntance();
		System.out.println(s1==s2);
	}

}
