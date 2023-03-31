//Name:		Will Wetzel - 130251255
//Program:		Project two - PizzaChoice
//Module:		CSC1021 - Programming I
//Description:	A class that will show the user a menu of bases and toppings modeled on previous classes
//				and takes the user selection. It will then build a pizza modeled according to the pizza class
//				and call the method "pizza.total" to show a summary and the total cost of the pizza.

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaChoice
{
	private static ArrayList<PizzaBase> bases = new ArrayList<PizzaBase>();		//Array List for the pizza base menu.
	private static ArrayList<PizzaTopping> tops = new ArrayList<PizzaTopping>();	//Array List for the pizza topping menu.
	private static Scanner keyboard;						//Initialize scanner for user input.
	private static int bInput;							//Integer for user base selection.
	private static int tInput;							//Integer for user topping selection.
	
	public static void addBase(PizzaBase base)					//Method for adding bases to the base menu.
	{
		bases.add(base);
	}
	
	public static void addTop(PizzaTopping topping)					//Method for adding toppings to the topping menu.
	{
		tops.add(topping);
	}
		
	public static void main(String[] args) 						//Main method.
	{
		
		Pizza pizza = new Pizza();						//Creates new pizza object according to the pizza class.
		//************Adds pizza bases to the base menu************//
		addBase(new PizzaTopping("New hand tossed",0,false));
		addBase(new PizzaTopping("Wheat thin crust",0,false));
		addBase(new PizzaTopping("Cheese Burst",0,false));
		addBase(new PizzaTopping("Fresh pan pizza",0,false));
		
		baseMenu(pizza);							//Calls the bases menu.
		
		try
		{
		baseChoice(pizza);							//Tries the baseChoice method.
		}		
        catch(IllegalArgumentException iae)						//Catches error thrown by the baseChoice method.
		{
        		System.out.println("Invalid selection, please select again");	//Shows user error method.
        		baseChoice(pizza);						//Continues baseChoice method.
		}
		
		//************Adds pizza toppings to topping menu************//
		//**************************Veggie**************************//
		addTop(new PizzaTopping("Deluxe Veggie Regular",150, false));
		addTop(new PizzaTopping("Deluxe Veggie Medium", 200, false));
        addTop(new PizzaTopping("Deluxe Veggie Small", 325, false));
		//**************************Cheese**************************//
		addTop(new PizzaTopping("Cheese and corn Regular", 175, false));
		addTop(new PizzaTopping("Cheese and corn Medium", 375, false));
		addTop(new PizzaTopping("Cheese and corn Small", 475, false));
		//**************************Paneer**************************//
		addTop(new PizzaTopping("Paneer Tikka Regular", 160, true));
		addTop(new PizzaTopping("Paneer Tikka Medium", 290, true));
		addTop(new PizzaTopping("Paneer Tikka Small", 340, true));
		//**************************Non-Veg**************************//
		addTop(new PizzaTopping("Non-Veg Supreme Regular", 190, true));
		addTop(new PizzaTopping("Non-Veg Supreme Medium", 325, true));
		addTop(new PizzaTopping("Non-Veg Supreme Small", 425, true));
		//**************************Chicken**************************//
		addTop(new PizzaTopping("Chicken Tikka Regular", 210, false));
		addTop(new PizzaTopping("Chicken Tikka Medium", 370, false));
		addTop(new PizzaTopping("Chicken Tikka Small", 500, false));
        //**************************Chicken**************************//
		addTop(new PizzaTopping("Pepper Barbecue Chicken Regular", 220, false));
		addTop(new PizzaTopping("Pepper Barbecue Chicken Medium", 380, false));
		addTop(new PizzaTopping("Pepper Barbecue Chicken Small", 525, false));
		
		toppingMenu(pizza);							//Calls the topping menu method.
		try
		{
		toppingChoice(pizza);							//Tries the toppingChoice method.
		}
        catch(IllegalArgumentException iae)						//Catches the error thrown by toppingChoice method.
		{		
        		System.out.println("Invalid selection, please select again");	//Shows user error message.
        		toppingChoice(pizza);						//Continues toppingChoice method.
		}
		pizza.total();								//Calls total method that shows summary of pizza bases, toppings and price.
	}
	
	public static void baseMenu(Pizza pizza)					//Method for printing table of pizza bases (printing array list).
	{
		int i = 1;								//Int i for labelling bases for user.
		keyboard = new Scanner(System.in);					//Declaring keyboard as scanner, else null pointer exception will occur.
		
		System.out.println("Pizza base selection");											
		String newLine = System.getProperty("line.separator");			//Initialize "newLine" to enter a newline when entered in a system.out statement.
		System.out.print("\t------------------------------------" + newLine);	//Prints top border.
		System.out.format("\t%15s%21s", "-Bases-",  "-Price- "+ newLine);	//Prints header for the table.
		System.out.print("\t------------------------------------" + newLine);	//Prints border.
		
		for(PizzaBase base : bases)									//for loop for every pizza base in bases menu.
		{
			System.out.printf(newLine + "\t%5s. %-15s:%10s", i, base.getName(), base.getCost());	//Prints every pizza base and its price.
			i++;											//Adds 1 to i for base labeling.
		}
		
		System.out.print(newLine + "\t------------------------------------" + newLine);			//Prints border.
	}
	
	public static void baseChoice(Pizza pizza)								//Method for choosing the base.
	{	
		System.out.println("Please enter your choice of base by entering its respective number.");	//System out message for user.
		bInput = keyboard.nextInt();									//Uses user input as bInput.

		if(bInput<1||bInput>3)										//If statement for if the input is not valid.
		{
			throw new IllegalArgumentException("\nMust enter a number between 1 and 3.\nPlease run again.");	//Throws exception.
		}
		else if(bInput == 1)										//Else if loop for setting the pizza base.
		{
			pizza.setPizzaBase(new PizzaTopping("New hand tossed",0, false));				//Creates new pizza base and sets it for pizza.
			System.out.println("You've selected 'New hand tossed'.\n");					//Confirmation message for user.
		}
		else if(bInput == 2)
		{
			pizza.setPizzaBase(new PizzaTopping("Wheat thin crust",0, false));				//Creates new pizza base and sets it for pizza.
			System.out.println("You've selected 'Wheat thin crust'.\n");					//Confirmation message for user.
		}
		else if(bInput == 3)
		{
			pizza.setPizzaBase(new PizzaTopping("Cheese Burst",0, false));				//Creates new pizza base and sets it for pizza.
			System.out.println("You've selected 'Cheese Burst'.\n");				//Confirmation message for user.
		}
		else if(bInput == 4)
		{
			pizza.setPizzaBase(new PizzaTopping("Fresh pan pizza",0, false));				//Creates new pizza base and sets it for pizza.
			System.out.println("You've selected 'Fresh pan pizza'.\n");				//Confirmation message for user.
			
		}
		pizza.setbInput(bInput);									//Sets bInput .		
	}
	
	public static void toppingMenu(Pizza pizza)								//Method for printing table of pizza toppings (printing array list).
	{
		int i = 1;											//Int i for labelling bases for user.
		
		System.out.println("Pizza topping selection");
		String newLine = System.getProperty("line.separator");						//Initialize "newLine" to enter a newline when entered in a system.out statement.
		System.out.print("\t------------------------------------" + newLine);				//Prints top border.
		System.out.format("\t%15s%21s", "-Toppings-",  "-Price- "+ newLine);				//Prints header for the table.
		System.out.print("\t------------------------------------" + newLine);				//Prints border.
		
		for(PizzaTopping topping : tops)								//for loop for every pizza topping.
		{
			System.out.printf(newLine + "\t%5s. %-15s:%10s", i, topping.getName(), topping.getCost());	//Prints every pizza topping and its price.
			i++;											//Adds 1 to i for base labeling.
			
		}
		
		System.out.print(newLine + "\t------------------------------------" + newLine);			//Prints border.
	}
	
	public static void toppingChoice(Pizza pizza)								//Method for topping selection.
	{	
		System.out.println("Please select your toppings by entering their respective numbers."		//Print out statement for user.
					+ "\nEnter 0 at any time to end the selection.\n");	
		do												//Do while loop for while tInput does not equal 0.
		{
			tInput = keyboard.nextInt();								//Takes user input as tInput.
			pizza.settInput(tInput);								//Sets tInput.
		if(tInput<-1||tInput>13)									//If tInput is outside of selection throws error message.
		{
			throw new IllegalArgumentException("\nMust enter a number between 0 and 13.\nPlease run again.");
		}	
		else if(tInput == 0)										//Else if statement for topping selection.
		{
			System.out.println("End of topping selection.");					//If 0 is entered, break.
			break;
		}
		else if(tInput == 1)										//Topping selections.
		{
			pizza.addTopping(new PizzaTopping("Deluxe Veggie Regular",150, false));				//Creates new topping and adds to pizza.
			System.out.println("You've selected 'Deluxe Veggie Regular'.");					//Confirmation message.
		}
		else if(tInput == 2)
		{
			pizza.addTopping(new PizzaTopping("Deluxe Veggie Medium", 200, false));
			System.out.println("You've selected 'Deluxe Veggie Medium'.");
		}
		else if(tInput == 3)
		{
			pizza.addTopping(new PizzaTopping("Deluxe Veggie Small", 325, false));
			System.out.println("You've selected 'Deluxe Veggie Small'.");
		}
		else if(tInput == 4)
		{
			pizza.addTopping(new PizzaTopping("Cheese and corn Regular", 175, true));
			System.out.println("You've selected 'Cheese and corn Regular'.");
		}
		else if(tInput == 5)
		{
			pizza.addTopping(new PizzaTopping("Cheese and corn Medium", 375, true));
			System.out.println("You've selected 'Cheese and corn Medium'.");
			
		}
		else if(tInput == 6)
		{
			pizza.addTopping(new PizzaTopping("Cheese and corn Small", 475, true));
			System.out.println("You've selected 'Cheese and corn Small'.");
		}
		else if(tInput == 7)
		{
			pizza.addTopping(new PizzaTopping("Paneer Tikka Regular", 160, true));
			System.out.println("You've selected 'Paneer Tikka Regular'.");
		}
		else if(tInput == 8)
		{
			pizza.addTopping(new PizzaTopping("Paneer Tikka Medium", 290, true));
			System.out.println("You've selected 'Paneer Tikka Medium'.");
		}
		else if(tInput == 9)
		{
			pizza.addTopping(new PizzaTopping("Paneer Tikka Small", 340, false));
			System.out.println("You've selected 'Paneer Tikka Small'.");
		}
		else if(tInput == 10)
		{
			pizza.addTopping(new PizzaTopping("Non-Veg Supreme Regular", 190, false));
			System.out.println("You've selected 'Non-Veg Supreme Regular'.");
		}
		else if(tInput == 11)
		{
			pizza.addTopping(new PizzaTopping("Non-Veg Supreme Medium", 325, false));
			System.out.println("You've selected 'Non-Veg Supreme Medium'.");
		}
		else if(tInput == 12)
		{
			pizza.addTopping(new PizzaTopping("Non-Veg Supreme Small", 425, false));
			System.out.println("You've selected 'Non-Veg Supreme Small'.");
		}
		else if(tInput == 13)
		{
			pizza.addTopping(new PizzaTopping("Chicken Tikka Regular", 210, false));
			System.out.println("You've selected 'Chicken Tikka Regular'.");
		}
		else if(tInput == 14)
		{
			pizza.addTopping(new PizzaTopping("Chicken Tikka Medium", 370, false));
			System.out.println("You've selected 'Chicken Tikka Medium'.");
		}
		else if(tInput == 15)
		{
			pizza.addTopping(new PizzaTopping("Chicken Tikka Small", 500, false));
			System.out.println("You've selected 'Chicken Tikka Small'.");
		}
		else if(tInput == 16)
		{
			pizza.addTopping(new PizzaTopping("Pepper Barbecue Chicken Regular", 220, false));
			System.out.println("You've selected 'Pepper Barbecue Chicken Regular'.");
		}
		else if(tInput == 17)
		{
			pizza.addTopping(new PizzaTopping("Pepper Barbecue Chicken Medium", 380, false));
			System.out.println("You've selected 'Pepper Barbecue Chicken Medium'.");
		}
		else if(tInput == 18)
		{
			pizza.addTopping(new PizzaTopping("Pepper Barbecue Chicken Small", 525, false));
			System.out.println("You've selected 'Pepper Barbecue Chicken Small'.");
		}
		} while(tInput != 0);	//If tInput is 0 then do...while loop ends.
	}
	
}
