package com.bain.baristamatic;

import java.text.DecimalFormat;

/**
 * 
 * This class displays the BaristaMatic menu options
 */
public class BaristaMenu {

	/**
	 * display the Barista menu
	 */
	public void displayMenu() {
		 System.out.println("Menu:");
		 int menuOptionNumber = 1;
		 StringBuffer sb = new StringBuffer();
		 for (DrinkRecipe drinkRecipe : DrinkRecipe.values())
		 {
			sb.append(menuOptionNumber + ", ");
			sb.append(drinkRecipe.getDescription() + ", ");
			DecimalFormat df = new DecimalFormat("$###.##");
			df.setMinimumFractionDigits(2);
			sb.append(df.format(drinkRecipe.getTotalPrice()) + ", ");
			Inventory currentInventory = Inventory.getInstance();
			sb.append(currentInventory.isInstock(drinkRecipe));
	//		sb.append(new Drink(drinkRecipe).isInstock());
			System.out.println(sb);
			sb.delete(0, sb.length());
			menuOptionNumber++;
		 }
	 }
}
