package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import pl.edu.agh.mwo.invoice.product.Product;
import sun.awt.image.BufferedImageGraphicsConfig;

public class Invoice {
	private Map<Product, Integer> products;

    public Invoice() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
		products.put(product, 1);
	}

	public void addProduct(Product product, Integer quantity) throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        } else {
            products.put(product, quantity);
        }
	}

	public BigDecimal getNetPrice() {
        return products.entrySet().stream()
                .map(p -> p.getKey().getPrice() .multiply(new BigDecimal(p.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getTaxPrice() {
        return products.entrySet().stream()
                .map(p -> {return p.getKey().getPrice().multiply(p.getKey().getTaxPercent()).multiply(new BigDecimal(p.getValue()));})
                .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getGrossPrice() {
		return getNetPrice().add(getTaxPrice());
	}
}
