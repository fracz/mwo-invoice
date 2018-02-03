package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products;
	private HashMap<Product, Integer> amout = new HashMap();

	public void addProduct(Product product) {
		// TODO: implement
		this.addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
		// this.products.add(product);
		this.amout.put(product, quantity);
	}

	public BigDecimal getSubtotal() {
		BigDecimal subtotal = BigDecimal.ZERO;
		for (Product item : amout.keySet()) {
			BigDecimal subPrice = item.getPrice().multiply(new BigDecimal(amout.get(item)));
			subtotal = subtotal.add(subPrice);
		}
		return subtotal;
	}

	public BigDecimal getTax() {
		BigDecimal tax = BigDecimal.ZERO;
		for (Product item : amout.keySet()) {
			BigDecimal subTax = item.getTaxPercent().multiply(item.getPrice())
					.multiply(new BigDecimal(amout.get(item)));
			tax = tax.add(subTax);
		}
		return tax;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Product item : amout.keySet()) {
			BigDecimal subTotal = item.getPriceWithTax().multiply(new BigDecimal(amout.get(item)));
			System.out.println(subTotal);
			total = total.add(subTotal);
			System.out.println(total);
		}
		return total;
	}
}
