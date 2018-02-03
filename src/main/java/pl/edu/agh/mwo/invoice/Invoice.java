package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<Product>();

	
	public void addProduct(Product product) {
		this.products.add(product);
		
	}

	public void addProduct(Product product, Integer quantity) {
		for (int i=0; i<quantity; i++){
			this.products.add(product);
		}//end for
	}

	public BigDecimal getNetPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : this.products ) {
			sum = sum.add(product.getPrice());
		}//end for each
		
		return sum;
	}

	public BigDecimal getTax() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : this.products ) {
			sum = sum.add(product.getTaxPercent());
		}//end for each
		
		return sum;
	}

	public BigDecimal getGrossPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : this.products ) {
			sum = sum.add(product.getPriceWithTax());
		}//end for each
		
		return sum;
	}
}
