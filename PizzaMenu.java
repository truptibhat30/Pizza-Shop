//Name:		Will Wetzel - 130251255
//Program:		Project two - PizzaChoice
//Module:		CSC1021 - Programming I
//Description:	A class that will show the user a menu of bases and toppings modeled on previous classes
//				and takes the user selection. It will then build a pizza modeled according to the pizza class
//				and call the method "pizza.total" to show a summary and the total cost of the pizza.

import java.util.Scanner;

public class PizzaMenu
{
	private static int pIn;					//Initialize variable for pizza selection.
	private static Scanner keyboard;			//Initialize scanner for user input.
	
	public static void main(String[] args) 			//Main method
	{
		Pizza pizza = new Pizza();			//New pizza object.
		menu(pizza);					//Calls menu method.
		try						//Try menu selection method (user input)
		{
			menuSelect(pizza);
		}
        catch(IllegalArgumentException iae)			//Catches error thrown by the menu selection method.
		{
        		System.out.println("Invalid selection, please select again");		//Shows user error method.
        		menuSelect(pizza);							//Continues menu selection method.
		}
		pizza.total();					//Pizza summary method.
	}
	
	public static void menu(Pizza pizza)			//Method for printing table of pizzas.
	{
		keyboard = new Scanner(System.in);		//Declaring keyboard as scanner, else null pointer exception will occur.
		
		System.out.println("Pizza selection");
		String newLine = System.getProperty("line.separator");					//Initialize "newLine" to enter a newline when entered in a system.out statement.
		System.out.print("\t-----------------------------------------" + newLine);		//Prints top border.
		System.out.format("\t%15s%25s", "-Extra-",  "-Description- "+ newLine);		//Prints header for the table.
		System.out.print("\t-----------------------------------------" + newLine);		//Prints border.
		
		System.out.format("\t%-5s%1s\t\t%10s", "1.", "Black olive", "Veg Toppings" + newLine);		//Prints strings that contain pizza name and a brief...
		System.out.format("\t%-5s%1s\t\t%10s", "2.", "Capsicum", "-" + newLine);			//... description.
		System.out.format("\t%-5s%1s\t\t%10s", "3.", "Paneer", "-" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "4.", "Mushroom", "-" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "5.", "Fresh Tomato", "-" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "6.", "Chicken tikka", "Non-Veg Toppings" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "7.", "Barbeque chicken", "-" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "8.", "Grilled chicken", "-" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "9.", "Extra cheese", "-" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "10.", "Cold drink", "Sides" + newLine);
		System.out.format("\t%-5s%1s\t\t%10s", "11.", "Mousse cake", "-" + newLine);
	
		System.out.print(newLine + "\t-----------------------------------------" + newLine);	//Prints border.
	}
	
	public static void menuSelect(Pizza pizza)
	{
		System.out.println("Please enter your pizza by entering its respective number.");	//System out message for user.
		pIn = keyboard.nextInt();								//Uses user input as pIn.

		if(pIn<1||pIn>11)									//If statement for if the input is not valid.
		{
			throw new IllegalArgumentException("\nMust enter a number between 1 and 5.\nPlease run again.");	//Throws exception.
		}
		else if(pIn == 1)									//Else if loop for setting the pizza base.
		{
			blackolive(pizza);								//Calls margherita method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Black olive",20,false));
			System.out.println("You've selected 'Black olive'.\n");				//Confirmation message for user.
		}
		else if(pIn == 2)
		{
			capsicum(pizza);								//Calls hawaiian method that builds the pizza.																					
			pizza.addTopping(new PizzaTopping("Capsicum",25,false));
			System.out.println("You've selected 'Capsicum'.\n");				//Confirmation message for user.
		}
		else if(pIn == 3)
		{
			paneer(pizza);								//Calls americano method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Paneer",35,false));
			System.out.println("You've selected 'Paneer'.\n");				//Confirmation message for user.
		}
		else if(pIn == 4)
		{
			mushroom(pizza);								//Calls texasBBQ method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Mushroom",30,false));
			System.out.println("You've selected 'Mushroom'.\n");				//Confirmation message for user.
		}
		else if(pIn == 5)
		{
			freshtomato(pizza);																//Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Fresh Tomato",10,false));
			System.out.println("You've selected 'Fresh Tomato'.\n");				//Confirmation message for user.
		}
		else if(pIn == 6)
		{
			chickentikka(pizza);																//Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Chicken tikka",35,false));
			System.out.println("You've selected 'Chicken tikka'.\n");				//Confirmation message for user.
		}
		else if(pIn == 7)
		{
			barbequechicken(pizza);																//Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Barbeque chicken",45,false));
			System.out.println("You've selected 'Barbeque chicken'.\n");				//Confirmation message for user.
		}
		else if(pIn == 8)
		{
			grilledchicken(pizza);																//Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Grilled chicken",40,false));
			System.out.println("You've selected 'Grilled chicken'.\n");				//Confirmation message for user.
		}
		else if(pIn == 9)
		{
			extracheese(pizza);																//Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Extra cheese",35,false));
			System.out.println("You've selected 'Extra cheese'.\n");				//Confirmation message for user.
		}
		else if(pIn == 10)
		{
			colddrink(pizza);			                                            //Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Cold drink",55,false));
			System.out.println("You've selected 'Cold drink'.\n");				//Confirmation message for user.
		}
		else if(pIn == 11)
		{
			moussecake(pizza);	//Calls veggie method that builds the pizza.
			pizza.addTopping(new PizzaTopping("Mousse cake",90,false));
			System.out.println("You've selected 'Mousse cake'.\n");				//Confirmation message for user.
		}
		pizza.setpIn(pIn);
	}
	
	
	//******************************Predefined pizza methods for the menu******************************//


	
	
	public static void blackolive(Pizza pizza)
	{
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Black olive",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	
	public static void capsicum(Pizza pizza)
	{
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Capsicum",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}	
	
	public static void paneer(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Paneer",0.50, false));			//Creates and adds topping object to the pizza object.
		
	}
	
	public static void mushroom(Pizza pizza)
	{
	    
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Mushroom",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	
	public static void freshtomato(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Fresh Tomato",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	public static void chickentikka(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Chicken tikka",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	public static void barbequechicken(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Barbeque chicken",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	public static void grilledchicken(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Grilled chicken",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	public static void extracheese(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Extra cheese",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	public static void colddrink(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Cold drink",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}
	public static void moussecake(Pizza pizza)
	{
		
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));
		//pizza.addTopping(new PizzaTopping("Mousse cake",0.50, false));			//Creates and adds topping object to the pizza object.	
		
	}

}
	
	

