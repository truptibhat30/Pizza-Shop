//Name:		Will Wetzel - 130251255
//Program:		Project two - PizzaBuild
//Module:		CSC1021 - Programming I
//Description:	A pizza build program that will build a predefined pizza to demonstrate
//				the Pizza, PizzaTopping and PizzaBase classes.

public class PizzaBuild 
{

	public static void main(String[] args) 						//Main method.
	{
		Pizza pizza = new Pizza();						//New pizza object.
		pizza.setPizzaBase(new PizzaTopping("New hand tossed",1, false));		//Creates and adds base object to the pizza object.
		pizza.addTopping(new PizzaTopping("Deluxe Veggie Regular", 150, false));	//Creates and adds topping object to the pizza object.		
		pizza.addTopping(new PizzaTopping("Deluxe Veggie Medium", 200, false));		//Creates and adds topping object to the pizza object.
		pizza.addTopping(new PizzaTopping("Deluxe Veggie Small", 325, true));			//Creates and adds topping object to the pizza object.
				
		pizza.total();								//Calls the total method for the pizza object.
		
	}

}
