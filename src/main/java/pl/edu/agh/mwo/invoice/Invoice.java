package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<Product>();

	public void addProduct(Product product) {
		// zakładamy ze dodajemy 1 produkt
		products.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		// 
		for (int i=0; i < quantity; i++) 
		{
			products.add(product);
		}
	}

	public BigDecimal getNetValue() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : products) // to ma służyc do iterwowania po każdym elemencie listy
		{
			sum = sum.add(product.getPrice());
		}
		return sum;
	}

	public BigDecimal getTax() {
		return null;
	}

	public BigDecimal getGrossValue() {
		return null;
	}
}
