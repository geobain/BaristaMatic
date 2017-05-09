package com.bain.baristamatic;

import java.math.BigDecimal;

/**
 * Enumeration of ingredients for coffee drinks including method for ingredient price
 */
public enum DrinkIngredient {

	COCAO
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.90);
		}
	},
	COFFEE
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.75);
		}
	},
	CREAM
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.25);
		}
	},
	DECAF_COFFEE
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.75);
		}
	},
	ESPRESSO
	{
		public BigDecimal getPrice() {
			return new BigDecimal(1.10);
		}
	},
	FOAMED_MILK
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.35);
		}
	},
	STEAMED_MILK
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.35);
		}	
	},
	SUGAR
	{
		public BigDecimal getPrice() {
			return new BigDecimal(0.25);
		}
	},
	WHIPPED_CREAM
	{
		public BigDecimal getPrice() {
			return new BigDecimal(1.00);
		}
	};
	public static final int RESTOCK_VALUE = 10;
	
	public String getDescription() {
		switch (this) {
		case COFFEE:
			return "Coffee";
		case DECAF_COFFEE:
			return "Decaf Coffee";	
		case SUGAR:
			return "Sugar";
		case CREAM:
			return "Cream";
		case STEAMED_MILK:
			return "Steamed Milk";
		case FOAMED_MILK:
			return "Foamed Milk";
		case ESPRESSO:
			return "Espresso";
		case COCAO:
			return "Cocao";
		case WHIPPED_CREAM:
			return "Whipped Cream";
		default:
			return "Invalid";
		}
		
	}
	
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getRestockValue() {
		return new Integer (RESTOCK_VALUE);
	}
}
