package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	
	private final String name;
	private final BigDecimal price;
	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		
		if (name ==""|| name==null || price == null|| price.signum()==-1){
			throw new IllegalArgumentException("producnt narme or price cannot be null"); 
			//no product name or price, cant be null
		}
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
		return price.add(price.multiply(this.taxPercent));
	}

	public BigDecimal tax() {
		
		return tax.multiply(this.taxPercent);
		return null;
	}
}
