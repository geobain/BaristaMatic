package com.bain.baristamatic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Enumeration of coffee drinks with methods for price and ingredients
 */
public enum DrinkRecipe {

	CAFE_AMERICANO {
		public BigDecimal getTotalPrice() {
			BigDecimal totalPrice = new BigDecimal(0.00);
			totalPrice = DrinkIngredient.ESPRESSO.getPrice()
					.multiply(new BigDecimal(3.00).setScale(2, BigDecimal.ROUND_HALF_UP));
			return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		public List<DrinkIngredient> getIngredients() {
			List<DrinkIngredient> ingredients = new ArrayList<DrinkIngredient>();
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.ESPRESSO);
			return ingredients;
		}
	},
	CAFE_LATTE {
		public BigDecimal getTotalPrice() {
			BigDecimal totalPrice = new BigDecimal(0.00);
			totalPrice = DrinkIngredient.ESPRESSO.getPrice()
					.multiply(new BigDecimal(2.00).setScale(2, BigDecimal.ROUND_HALF_UP));
			totalPrice = totalPrice.add(DrinkIngredient.CREAM.getPrice());
			return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		public List<DrinkIngredient> getIngredients() {
			List<DrinkIngredient> ingredients = new ArrayList<DrinkIngredient>();
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.STEAMED_MILK);
			return ingredients;
		}
	},
	CAFE_MOCHA {
		public BigDecimal getTotalPrice() {
			BigDecimal totalPrice = new BigDecimal(0.00);
			totalPrice = DrinkIngredient.ESPRESSO.getPrice();
			totalPrice = totalPrice.add(DrinkIngredient.COCAO.getPrice());
			totalPrice = totalPrice.add(DrinkIngredient.STEAMED_MILK.getPrice());
			totalPrice = totalPrice.add(DrinkIngredient.WHIPPED_CREAM.getPrice());
			return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		public List<DrinkIngredient> getIngredients() {
			List<DrinkIngredient> ingredients = new ArrayList<DrinkIngredient>();
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.COCAO);
			ingredients.add(DrinkIngredient.STEAMED_MILK);
			ingredients.add(DrinkIngredient.WHIPPED_CREAM);
			return ingredients;
		}
	},
	CAPPUCCINO {
		public BigDecimal getTotalPrice() {
			BigDecimal totalPrice = new BigDecimal(0.00);
			totalPrice = DrinkIngredient.ESPRESSO.getPrice()
					.multiply(new BigDecimal(2.00).setScale(2, BigDecimal.ROUND_HALF_UP));
			totalPrice = totalPrice.add(DrinkIngredient.STEAMED_MILK.getPrice());
			totalPrice = totalPrice.add(DrinkIngredient.FOAMED_MILK.getPrice());
			return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		public List<DrinkIngredient> getIngredients() {
			List<DrinkIngredient> ingredients = new ArrayList<DrinkIngredient>();
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.ESPRESSO);
			ingredients.add(DrinkIngredient.STEAMED_MILK);
			ingredients.add(DrinkIngredient.FOAMED_MILK);
			return ingredients;
		}
	},
	COFFEE {
		public BigDecimal getTotalPrice() {
			BigDecimal totalPrice = new BigDecimal(0.00);
			totalPrice = DrinkIngredient.COFFEE.getPrice().multiply(new BigDecimal(3.00));
			totalPrice = totalPrice.add(DrinkIngredient.SUGAR.getPrice());
			totalPrice = totalPrice.add(DrinkIngredient.CREAM.getPrice());
			return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		public List<DrinkIngredient> getIngredients() {
			List<DrinkIngredient> ingredients = new ArrayList<DrinkIngredient>();
			ingredients.add(DrinkIngredient.COFFEE);
			ingredients.add(DrinkIngredient.COFFEE);
			ingredients.add(DrinkIngredient.COFFEE);
			ingredients.add(DrinkIngredient.SUGAR);
			ingredients.add(DrinkIngredient.CREAM);
			return ingredients;
		}
	},
	DECAF_COFFEE {
		public BigDecimal getTotalPrice() {
			BigDecimal totalPrice = new BigDecimal(0.00);
			totalPrice = DrinkIngredient.DECAF_COFFEE.getPrice().multiply(new BigDecimal(3.00));
			totalPrice = totalPrice.add(DrinkIngredient.SUGAR.getPrice());
			totalPrice = totalPrice.add(DrinkIngredient.CREAM.getPrice());
			return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		public List<DrinkIngredient> getIngredients() {
			List<DrinkIngredient> ingredients = new ArrayList<DrinkIngredient>();
			ingredients.add(DrinkIngredient.DECAF_COFFEE);
			ingredients.add(DrinkIngredient.DECAF_COFFEE);
			ingredients.add(DrinkIngredient.DECAF_COFFEE);
			ingredients.add(DrinkIngredient.SUGAR);
			ingredients.add(DrinkIngredient.CREAM);
			return ingredients;
		}
	};
	/**
	 * 
	 * @return the drink description
	 */
	public String getDescription() {
		switch (this) {
		case COFFEE:
			return "Coffee";
		case DECAF_COFFEE:
			return "Decaf Coffee";
		case CAFE_LATTE:
			return "Cafe Latte";
		case CAFE_AMERICANO:
			return "Cafe Americano";
		case CAFE_MOCHA:
			return "Cafe Mocha";
		case CAPPUCCINO:
			return "Cappuccino";
		default:
			return "Invalid";
		}
	}

	/**
	 * @return total drink price based on ingredients
	 */
	public BigDecimal getTotalPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return returns list of ingredients for the drink
	 */
	public List<DrinkIngredient> getIngredients() {
		// TODO Auto-generated method stub
		return null;
	};
}
