package com.bain.baristamatic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class maintains the inventory of drink ingredients to ensure a coffee drink can be ordered
 */
public class Inventory {
	private static Inventory instance = null;

	protected static Inventory getInstance() {
		if (instance == null) {
			synchronized (Inventory.class) {
				if (instance == null) {
					instance = new Inventory();
					instance.restock();
				}
			}
		}
		return instance;
	}

	private Map<DrinkIngredient, Integer> inventory = new LinkedHashMap<DrinkIngredient, Integer>();

	protected Map<DrinkIngredient, Integer> getInventory() {
		return inventory;
	}

	/**
	 * 
	 * @param ingredient
	 * @return the inventory count for the given ingredient 
	 */
	protected int checkIngredientCount(DrinkIngredient ingredient) {
		int currentValue = inventory.get(ingredient).intValue();
		return currentValue;
	}
	
	/**
	 * @return boolean to show if enough ingredients are in the inventory in
	 *         order to make the selected drink.
	 */
	protected boolean isInstock(DrinkRecipe recipe) {
		boolean instock = true;
		List<DrinkIngredient> ingredients = recipe.getIngredients();
		Map<DrinkIngredient, Integer> tempCount = new HashMap<DrinkIngredient, Integer>();
		int count = 0;
		for (DrinkIngredient ingredient : ingredients) {
			int currentCount = checkIngredientCount(ingredient);
			if (currentCount < 1) {
				instock = false;
				break;
			}
			if (tempCount.containsKey(ingredient)) {
				count = tempCount.get(ingredient).intValue();
				count++;
				if (currentCount - count < 0) {
					instock = false;
					break;
				}
				tempCount.put(ingredient, count);
			} else {
				count++;
				tempCount.put(ingredient, count);
			}
		}
		return instock;
	}
	
	/**
	 * The method will decrease the inventory value of the ingredient by 1
	 * @param ingredient The ingredient whose value is to be decreased
	 */
	protected void adjustInventory(DrinkIngredient ingredient) {
		int currentValue = inventory.get(ingredient).intValue();
		currentValue--;
		inventory.put(ingredient, currentValue);
		return;
	}
	
	/**
	 * method to display inventory
	 */
	protected void displayInventory() {
		System.out.println("Inventory:");
		Iterator<DrinkIngredient> iter = inventory.keySet().iterator();
		while (iter.hasNext()) {
			DrinkIngredient test = (DrinkIngredient) iter.next();
			System.out.println(test.getDescription() + ", " + inventory.get(test));
		}
		return;
	}

	/**
	 * Method to loop through the drink ingredients enumeration and 
	 * reset the Barista ingredients inventory to the required value
	 */
	protected void restock() {
		inventory.clear();
		for (DrinkIngredient ingredient : DrinkIngredient.values()) {
			inventory.put(ingredient, ingredient.getRestockValue());
		}
	}
}
