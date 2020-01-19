package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		if (name == null)
		{
			throw new IllegalArgumentException("Product name can't be null!");
		}
		if (name.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		if (price == null)
		{
		throw new IllegalArgumentException();
		}
		BigDecimal a = new BigDecimal ("0");
		if (price.compareTo(a) < 0)
		{
		throw new IllegalArgumentException();
		}
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
		BigDecimal a = new BigDecimal ("1");
		return (price.multiply((taxPercent.add(a))));

	}
}
