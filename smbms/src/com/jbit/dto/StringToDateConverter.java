package com.jbit.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 *
 *@author 栗子
 *@description 
 */
public class StringToDateConverter implements Converter<String,Date>{
	private SimpleDateFormat[] sdfs={new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yyyyMMdd")};
	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		Date d=null;
		for(SimpleDateFormat sdf:sdfs){
			try {
				d=sdf.parse(arg0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return d;
	}

}
