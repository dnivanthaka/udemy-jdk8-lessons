package com.acme.domain;
import com.acme.util.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
    private static double taxRate;
    private static Rushable rushable;
	
    static {
        taxRate = 0.05;
    }
	
	public Order(MyDate d, double amt, String c, Product p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}

	public Order(MyDate d, double amt, String c){
        //this(d, amt, c, "Anvil", 1);
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

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if(orderAmount > 0){
			this.orderAmount = orderAmount;
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity > 0){
			this.quantity = quantity;
		}
	}

	public static double getTaxRate() {
		return taxRate;
	}

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}
	
	public boolean isPriorityOrder(){
		boolean priorityOrder = false;
		
		if(rushable != null){
			
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
			
		}
		
		return priorityOrder;
	}
}
