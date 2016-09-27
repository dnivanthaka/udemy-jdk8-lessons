package com.acme.domain;
import com.acme.util.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
    public static double taxRate;
	
    static {
        taxRate = 0.05;
    }
	
	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}

	public Order(MyDate d, double amt, String c){
        this(d, amt, c, "Anvil", 1);
	}
	/**
	 * 
	 * @return Jobsize for an order
	 */
	public char jobSize(){
		char s = 'S';
		
		if(quantity > 25 && quantity <= 75){
			s = 'M';
		}else if(quantity > 75 && quantity <= 150){
			s = 'L';
		}else if(quantity > 150){
			s = 'X';
		}
		
		return s;
	}
	
	public double computeTotal(){
		double discount = 0.d;
		char category = this.jobSize();
		
		switch(category){
		case 'M':
			discount = orderAmount * 0.01;
		break;
		case 'L':
			discount = orderAmount * 0.02;
		break;
		case 'X':
			discount = orderAmount * 0.03;
		break;
		default:
		}
		return orderAmount - discount + computeTax();
	}
	
	public static void setTaxRate(double newRate){
		taxRate = newRate;
	}
	
	public static void computeTaxOn(double amount){
		System.out.println("The tax for "+amount+" is "+(amount * Order.taxRate));
	}
	
	public double computeTax(){
		System.out.println("The tax for this amount is "+(orderAmount * Order.taxRate));
		
		return orderAmount * Order.taxRate;
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
}
