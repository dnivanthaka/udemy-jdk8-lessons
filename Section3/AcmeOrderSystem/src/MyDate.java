
public class MyDate {
	int day;
	int month;
	int year;
	
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
