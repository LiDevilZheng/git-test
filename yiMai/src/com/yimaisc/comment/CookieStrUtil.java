package com.yimaisc.comment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CookieStrUtil {
	public static String addValues(String oldStr,String id){
		if(oldStr==null&&oldStr.equals("")){
			return id;
		}else{
			String []arr=oldStr.split("a");
			List<String> li=Arrays.asList(arr);
			LinkedList<String> ll=new LinkedList<String>(li);
			if(ll.size()<5){//浏览不满5条
				if(ll.contains(id)){
					ll.remove(id);
				}		
			}else{
				if(ll.contains(id)){
					ll.remove(id);
				}else{
					ll.removeLast();
				}
			}
			ll.addFirst(id);
			StringBuffer sb=new StringBuffer();
			for(String temp:ll){
				sb.append(temp+"a");
			}
			String s=sb.substring(0, sb.length()-1);
			return s;
		}	
	}
	/*public static void main(String [] args){
		String str=CookieStrUtil.addValues("5a4a3a2a1", "6");
		System.out.println(str);
	}*/
}
