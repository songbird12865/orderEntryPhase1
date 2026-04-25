// Melissa Joyce  CIS-406 OrderEntryPhase1  April 24, 2026

package orderEntryPhase1;

// Import utilities
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase1 
{
	// To create variables
	private String itemNumber;
	private String itemDescription;
	private double itemPrice;
	private int itemQuantity;
	private double itemTax;
	private double itemDiscount;
	private double itemNetPrice;
	
	
	private void getData()
	{
		// Declare Scanner object to get console data
		Scanner input = new Scanner(System.in);
		
		// To create user entry fields for the order
		
		System.out.print("Enter item number: ");
		itemNumber = input.nextLine();
		
		System.out.print("Enter item description: ");
		itemDescription = input.nextLine();

		// Exception handling for user entry regarding the item price - should be US currency with decimals
		try
		{
			System.out.print("Enter item price: $");
			itemPrice = input.nextDouble();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Data entered is not valid US currency. Program ending.");
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("Error occurred");
			System.exit(0);
		}
		
		// Exception handling for user entry regarding the item quantity - should be a whole number
		try
		{
			System.out.print("Enter the quantity: ");
			itemQuantity = input.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Data entered is not a valid number. Program ending.");
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("Error occurred");
			System.exit(0);
		}
		
		// Exception handling for user entry regarding the tax, discount, and net price - should be US currency with decimals
		
		try
		{
			System.out.print("Enter the item's tax: $");
			itemTax = input.nextDouble();
			
			System.out.print("Enter the item's discount: $");
			itemDiscount = input.nextDouble();
			
			System.out.print("Enter the net price of the item: $");
			itemNetPrice = input.nextDouble();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Data entered is not a valid US currency. Program ending.");
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("Error occurred");
			System.exit(0);
		}
		
		input.close();
		
	}
	
	// To generate order detail output
	public String toString()
	{
		return("\nOrder Details:\n" +
				String.format("\n%-15s %-20s %-15s %-20s %-12s %-20s %s", "Item Number", "Item Description", "Item Price", 
							"Quantity Ordered", "Total Tax", "Total Discount", "Net Price" ) +
				String.format("\n%-15s %-20s %-15s %-20s %-12s %-20s %s", "-----------", "----------------", "----------", "----------------",
							"---------", "--------------", "---------") +
				String.format("\n%-15s %-20s %-15s %-20s %-12s %-20s %s", itemNumber, itemDescription, "$" + String.format("%.2f", itemPrice),
							itemQuantity, "$" + String.format("%.2f", itemTax), "$" + String.format("%.2f", itemDiscount),
							"$" +String.format("%.2f", itemNetPrice)));
				
			    
				
	}

	// Creating the users order and generating output
	public static void main(String[] args) 
	{
		// To create a new order
		OrderEntryPhase1 myOrder = new OrderEntryPhase1();
		
		// To get the data for the order
		myOrder.getData();	
		
		// Display details to the console
		System.out.println(myOrder.toString());
			

	}

}
