package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;
	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
	/*	if (name == null || name.isEmpty()) {
			// name.equals("")
			throw new IllegalArgumentException("Product name cannot be null");
		}

		if (price == null) {
			// name.equals("")
			throw new IllegalArgumentException("Price cannot be null");
		}
		*/
		if (name == null || name.isEmpty() || price ==null || price.compareTo(new BigDecimal(0)) <0) { 
			throw new IllegalArgumentException("Invalid product parameters");
		}
		
	//	price.signum() == -1

		this.name = name;
		this.price = price;
		this.taxPercent = tax;
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
		return price.add(price.multiply(taxPercent));
	}
}
