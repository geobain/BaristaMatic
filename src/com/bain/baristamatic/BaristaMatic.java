package com.bain.baristamatic;

import java.util.Scanner;

/**
 * Top level class to control BaristaMatic display and functionality
 */
public class BaristaMatic {

	Inventory inventory = Inventory.getInstance();
	BaristaMenu menu = null;

	public BaristaMatic() {
		menu = new BaristaMenu();
	}

	/**
	 * call methods to display ingredient inventory followed by coffee menu
	 */
	public void displayInventoryAndMenu() {
		inventory.displayInventory();
		menu.displayMenu();
	}

	/**
	 * call inventory restock method
	 */
	public void restock() {
		inventory.restock();
	}

	public static void main(String[] args) {
		String input = null;
		Scanner scanner = new Scanner(System.in);
		BaristaMatic barista = new BaristaMatic();
		barista.displayInventoryAndMenu();
		input = scanner.nextLine();
		Drink drinkSelection = null;
		while (!"Q".equals(input.toUpperCase())) {
			switch (input.toUpperCase()) {
			case "R":
				barista.restock();
				barista.displayInventoryAndMenu();
				break;
			case "":
				break;
			case "1":
				drinkSelection = new Drink(DrinkRecipe.CAFE_AMERICANO);
				drinkSelection.confirmOrder();
				barista.displayInventoryAndMenu();
				break;
			case "2":
				drinkSelection = new Drink(DrinkRecipe.CAFE_LATTE);
				drinkSelection.confirmOrder();
				barista.displayInventoryAndMenu();
				break;
			case "3":
				drinkSelection = new Drink(DrinkRecipe.CAFE_MOCHA);
				drinkSelection.confirmOrder();
				barista.displayInventoryAndMenu();
				break;
			case "4":
				drinkSelection = new Drink(DrinkRecipe.CAPPUCCINO);
				drinkSelection.confirmOrder();
				barista.displayInventoryAndMenu();
				break;
			case "5":
				drinkSelection = new Drink(DrinkRecipe.COFFEE);
				drinkSelection.confirmOrder();
				barista.displayInventoryAndMenu();
				break;
			case "6":
				drinkSelection = new Drink(DrinkRecipe.DECAF_COFFEE);
				drinkSelection.confirmOrder();
				barista.displayInventoryAndMenu();
				break;
			default:
				System.out.println("Invalid selection: " + input);
				barista.displayInventoryAndMenu();
				break;
			}
			input = scanner.nextLine();
		}
		scanner.close();
	}
}
