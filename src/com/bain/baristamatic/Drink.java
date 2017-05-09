package com.bain.baristamatic;

import java.util.List;

/**
 * The Drink class
 */
public class Drink {

	/**
	 * Constructor for drink object
	 * 
	 * @param DrinkRecipe
	 *            - contains recipe for drink ingredients
	 */
	public Drink(DrinkRecipe recipe) {
		this.recipe = recipe;
		description = recipe.getDescription();
		instock = setInstock();
	}

	DrinkRecipe recipe = null;
	private String description;
	private boolean instock;

	public boolean isInstock() {
		return instock;
	}

	/**
	 * @return boolean to show if enough ingredients are in the inventory in
	 *         order to make the selected drink.
	 */
	public boolean setInstock() {
		setInstock(true);
		Inventory currentInventory = Inventory.getInstance();
		setInstock(currentInventory.isInstock(recipe));
		return instock;
	}

	/**
	 * This method is called when the a drink has been ordered. It will check
	 * the ingredients for the drink and call the Inventory.adjustInventory
	 * method to reduce the inventory.
	 */
	public void confirmOrder() {
		if (isInstock()) {

			List<DrinkIngredient> ingredients = recipe.getIngredients();
			Inventory currentInventory = Inventory.getInstance();

			for (DrinkIngredient ingredient : ingredients) {
				currentInventory.adjustInventory(ingredient);
			}
			System.out.println("Dispensing: " + recipe.getDescription());
		} else {
			System.out.println("Out of stock: " + recipe.getDescription());
		}
	}

	private void setInstock(boolean instock) {
		this.instock = instock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
