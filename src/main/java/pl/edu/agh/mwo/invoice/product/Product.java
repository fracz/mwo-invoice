package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;
	
	//private final BigDecimal priceWithTax;

	protected Product(String name, BigDecimal price, BigDecimal tax, BigDecimal priceWithTax) {
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		
		//this.priceWithTax = priceWithTax;
		
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		//BigDeciaml priceWithTax = 
		return null;
		//add price with tax ?
	}
}
