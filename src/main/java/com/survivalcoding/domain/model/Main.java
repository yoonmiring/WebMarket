package com.survivalcoding.domain.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;

public class Main {
	public static void main(String[] args) {
		//현재 달력
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		System.out.println(calendar.get(Calendar.DATE));
		
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		System.out.println(date);
		
		//내년 내 생일
		calendar.set(2023, 10, 9); //11월 9일
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); //1~7 일~토
	}
}
