/*Display 8 item names and prices
 * Ask the user to enter an item name
 * 		if that item exists, display that item and price and add that item to the users order
 * 		it it does not exist, ask them for a new entry
 * Ask if they want to add another item. Repeat above. allow repeating the same item
 * once they answer no, display all items ordered and the total
 * display the average price of ordered items
 */

/*
 * Use a Map to keep track of the menu of items. It should have a String key (for item
 *		name) and Double value (for item price).
 *	Use parallel ArrayLists (one of strings, one of doubles) to store the items ordered and
 *		their prices.
 *	Write 3 methods to find 1) the average cost of the items ordered and the indexes of the
 *		2) highest and 3) lowest cost items.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
public class MenuMap {

	public static Scanner scnr;
	private static Map<String, Double> items = new TreeMap<>();
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrice = new ArrayList<>();
	private static double orderTotal = 0;
	public static void main(String[] args)
	{
		scnr = new Scanner(System.in);
		fillItemsMap();
		printMenu();
		String addItem;
		do
		{
		System.out.print("What item would you like to order?");
		String itemName = scnr.nextLine();
		do
		{
			if(items.containsKey(itemName)) break;
			else {System.out.println("Invalid input. Please order from the menu.");}
			itemName = scnr.nextLine();
		}
		while (true);
		double itemPrice = items.get(itemName);
		orderNames.add(itemName);
		orderPrice.add(itemPrice);
		orderTotal += itemPrice;
		System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
		System.out.println("Would you like to add another item? (y/n)");
		addItem = scnr.nextLine();
		do
		{
			if(addItem.equals("y")) break;
			else if(addItem.equals("n")) break;
			else {System.out.println("Invalid input. Please enter y or n.");}
			addItem = scnr.nextLine();
		}
		while (true);
		}
		while(addItem.equals("y"));
		
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");
		for (int i = 0; i < orderNames.size(); i++)
		{
            System.out.println(orderNames.get(i) +"\t" + items.get(orderNames.get(i))); 
		}
		System.out.println("Total\t" + orderTotal);
		double orderAverage = orderTotal / orderNames.size();
		double orderMinDou = orderMin(orderPrice);
		double orderMaxDou = orderMax(orderPrice);
		System.out.println("The average price of the items in your order is $" + orderAverage);
		System.out.println("The cheapest item you purchased was $" + orderMinDou);
		System.out.println("The most expensive item you purchased was $" + orderMaxDou);
		scnr.close();
	}
	
	private static void fillItemsMap()
	{
		items.put("apple", 5.03);
		items.put("grape", 8.19);
		items.put("turnip", 6.59);
		items.put("orange", 6.69);
		items.put("bagel", 5.79);
		items.put("bread", 7.19);
		items.put("melon", 4.99);
		items.put("beef", 4.19);
	}
	
	private static void printMenu()
	{
		System.out.println("Item\tPrice");
		System.out.println("=============");
		for (Map.Entry<String,Double> entry : items.entrySet())
		{
            System.out.println(entry.getKey() +"\t" + entry.getValue()); 
		}
	}
	
	private static double orderMin (List<Double> orderPrice)
	{
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < orderPrice.size(); i++)
		{
		min = Math.min(orderPrice.get(i), min);
		}
		return min;
	}
	private static double orderMax (List<Double> orderPrice)
	{
		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < orderPrice.size(); i++)
		{
		max = Math.max(orderPrice.get(i), max);
		}
		return max;
	}
} 