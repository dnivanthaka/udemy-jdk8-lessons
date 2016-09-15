package com.acme.util;

public class MyDate {
	public int day;
	public int month;
	public int year;
	
	{
		day   = 1;
		month = 1;
		year  = 2000;
	}
	
	public MyDate(){}
	
	public MyDate(int m, int d, int y){
		month = m;
		day   = d;
		year  = y;
	}
	
	public void setDate(int m, int d, int y){
		month = m;
		day   = d;
		year  = y;
	}
	
	public String toString(){
		
		return month + "/" + day + "/" + year;
	}
}