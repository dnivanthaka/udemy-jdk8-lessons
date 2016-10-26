package com.acme.util;

public class ConversionService {
// Weight conversion values
	public static double kilogramToPounds = 2.2046;
	public static int kilogramToGrams  = 1000;
	public static double kilogramsToOunces = 35.274;
	
//Volume conversion rates
	public static float literToFluidOunce = 33.814f;
	public static float literToGallon     = 0.2642f;
	public static float	literToPints      = 2.1134f;
	public static short literToMilliliters = 1_000;
	
	public static double[][] allKgToPounds(double... kilogramValues){
		double [][] result = new double[kilogramValues.length][kilogramValues.length];
		
		for(int i=0;i<kilogramValues.length;i++){
			result[i][0] = kilogramValues[i];
			result[i][1] = kilogramValues[i] * kilogramToPounds;
		}
		
		return result;
	}
}
