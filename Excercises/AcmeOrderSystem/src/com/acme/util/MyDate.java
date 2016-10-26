package com.acme.util;

public class MyDate {
	private byte day;
	private byte month;
	private short year;
	private static MyDate[] holidays;
	
	static{
		System.out.println("In static block");
		
		holidays = new MyDate[6];
		holidays[0] = new MyDate(1, 1, 2016);
		holidays[1] = new MyDate(9, 5, 2016);
		holidays[2] = new MyDate(5, 30, 2016);
		holidays[3] = new MyDate(11, 24, 2016);
		holidays[4] = new MyDate(7, 4, 2016);
		holidays[5] = new MyDate(12, 25, 2016);
	}
	
	{
		System.out.println("In init block");
		day   = 1;
		month = 1;
		year  = 2000;
	}
	
	public MyDate(){
		this(1,1,1900);
	}
	
	public MyDate(int m, int d, int y){
		if(isValid(m, d, y)){
			month = (byte)m;
			day   = (byte)d;
			year  = (short)y;
		}
	}
	
	public static MyDate[] getHolidays(){
		return holidays;
	}
	
	public static void listHolidays(){
		System.out.println("The holidays are:");
		for(int x=0;x<holidays.length;x++){
			System.out.println(holidays[x]);
			
		}
	}
	
	public void setDate(int m, int d, int y){
		if(isValid(d, m, y)){
			month = (byte)m;
			day   = (byte)d;
			year  = (short)y;
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
			System.out.println("Attempted to create an invalid date. d-m-y "+date+"-"+month+"-"+year);
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
			this.day = (byte)day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = (byte)month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = (short)year;
	}
	
	public boolean equals(Object o){
		if(o instanceof MyDate){
			MyDate d = (MyDate)o;
			if((d.day == day) && (d.month == month) && (d.year == year)){
				return true;
			}
		}
		
		return false;
	}
}
