package com.acme.util;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	{
		day   = 1;
		month = 1;
		year  = 2000;
	}
	
	public MyDate(){
		this(1,1,1900);
	}
	
	public MyDate(int m, int d, int y){
		if(isValid(m, d, y)){
			month = m;
			day   = d;
			year  = y;
		}
	}
	
	public void setDate(int m, int d, int y){
		if(isValid(m, d, y)){
			month = m;
			day   = d;
			year  = y;
		}
	}
	
	public String toString(){
		
		return month + "/" + day + "/" + year;
	}
	
	public static void leapYears(){
		int startYear = 1752;
		int endYear = 2020;
		
		for(int i=startYear;i<=endYear;i++){
			if((i % 4 == 0) && ((i % 100 != 0) || (i % 400 == 0))){
				System.out.println("The year "+i+" is a leap year");
			}
		}
	}
	
	private boolean isValid(int date, int month, int year){
		if(month > 12 || month < 1 || date > 31 || date < 1){
			System.out.println("Attempted to create an invalid date.");
			return false;
		}
		switch(month){
		case 4:
		case 6:
		case 9:
		case 11: return  (day <= 30);
		case 2: return day <= 28 || (day == 29 && year % 4 == 0);
		}
		
		return true;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(isValid(day, month, year)){		
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
