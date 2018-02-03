package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<Product>();

	public void addProduct(Product product) {
		if (product != null) {
			products.add(product);
		}
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity > 0) {
			for (int i = 0; i < quantity; i++) {
				if (product != null) {
					if (product != null) {
						products.add(product);
					}
				}
			} 
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public BigDecimal getNetTotal() {
		BigDecimal netTotal = new BigDecimal("0");
		if (products.size() != 0) {
			for (Product p : products) {
				if (p != null) {
					netTotal=netTotal.add(p.getPrice());
				}
			}
		}
		return netTotal;
	}

	public BigDecimal getTax() {
		BigDecimal taxToPay=new BigDecimal("0");
		for (Product p: products) {
			taxToPay=taxToPay.add(p.getPrice().multiply(p.getTaxPercent()));
		}
		return taxToPay;
	}

	public BigDecimal getGrossValue() {
		BigDecimal taxToPay=new BigDecimal("0");
		for (Product p: products) {
			taxToPay=taxToPay.add(p.getPrice());
			taxToPay=taxToPay.add(p.getPrice().multiply(p.getTaxPercent()));
		}
		return taxToPay;
		
	}
}
