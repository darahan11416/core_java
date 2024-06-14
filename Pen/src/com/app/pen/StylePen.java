package com.app.pen;

import java.sql.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class StylePen {

	private static List<Pen> pens = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choos;
		
		while (true) {
			
			 System.out.println("\n1. Add new Pen");
	            System.out.println("2. Update stock of a Pen");
	            System.out.println("3. Set discount of 20% for all pens not sold in last 3 months");
	            System.out.println("4. Remove Pens never sold in 9 months");
	            System.out.println("5.display all pen");
	            System.out.println("6. Exit");
	            choos=sc.nextInt();
	            
	            
	            
	            switch (choos) {
				case 1:
					addpen(sc);
					
					break;
				
					
				case 2:
					updatestock(sc);
					
					break;
					
				case 3:
					setDiscount();
					
					break;
					
				case 4:
					unSoldPen();
					break;
					
				case 5:
					displaypen();
					break;
					
					
					

				default:
					break;
				}
		
			
		}
		
		
		
		
	}
	
//	public Pen(String brand, String color, String inkColor, String material, int stock, Date stockUpdateDate,
//			Date stockListingDate, double price,x double discount)
	private static void addpen(Scanner sc)
	{
		System.out.println("public Pen(String brand, String color, String inkColor, String material, int stock, Date stockUpdateDate,\r\n"
				+ "//			Date stockListingDate, double price,x double discount)");
		Pen p1 = new Pen(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextInt()	,LocalDate.parse(sc.next()),   LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextDouble());
		
		pens.add(p1);
		System.out.println("pen added ");
		
		
	}
	
	private static void updatestock(Scanner sc)
	
	{
		System.out.println("enter id of pen");
		int id = sc.nextInt();
		
		System.out.println("enter updated  stock");
		int newstock = sc.nextInt();
		for(Pen pen: pens)
		{
			if(pen.getId() == id)
			{
				pen.setStock(newstock);
				System.out.println("Stock updated successfully");
				return;
				
				
			}
		}
		System.out.println("pen id not found");
		
	}
	
	
	private static void setDiscount()
	{
		LocalDate threemonthago = LocalDate.now().minus(3,ChronoUnit.MONTHS);
		
		for(Pen pen: pens)
		{
			if(pen.getStockUpdateDate().isBefore(threemonthago))
			{
				pen.setDiscount(20);
				System.out.println("discount set for pen "+pen);
			}
		}
	}
	
	
	
	private static void unSoldPen()
	{
		
		LocalDate ninemonth = LocalDate.now().minus(9,ChronoUnit.MONTHS);
		
		Iterator<Pen> itr = pens.iterator();
		
		while(itr.hasNext())
		{
			Pen pen = itr.next();
			if(pen.getStockListingDate().isBefore(ninemonth))
			{
				System.out.println("removing pen "+ pen);
				itr.remove();
			}
		}
 		
		
		
	}
	
	private static void displaypen()
	{
		
		if(pens.isEmpty())
		{
			System.out.println("no pen avilable");
		}
		else
		{
			for(Pen p:pens)
			{
				System.out.println(p);
			}
		}
		
		
	}
	
}
