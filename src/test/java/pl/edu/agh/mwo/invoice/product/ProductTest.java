package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import pl.edu.agh.mwo.invoice.product.Product;

public class ProductTest {
	@Test //adnotacja do kodu, ze to bedzie test
	public void testProductNameIsCorrect() {
		Product product = new OtherProduct("buty", new BigDecimal("100.0"));
		Assert.assertEquals("buty", product.getName());//asert zapewnie ze zworcilismy to co wsadzilismy
	}
	
	//mouseless dirven development
	//ctrl  + 
	//ctr f11 - run test
	//pom.xml zawiera informacje na temat zaleznosci zwiazanych z projektem i dociaga co jest potrzebne (maven)
	//repozyterium mavena zawiera gotowe rozwiązania, sa jarki, bez zrodel

	@Test
	public void testProductPriceAndTaxWithDefaultTax() {
		Product product = new OtherProduct("Ogorki", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("100"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("0.23"), Matchers.comparesEqualTo(product.getTaxPercent()));
	}

	@Test
	public void testProductPriceAndTaxWithDairyProduct() {
		Product product = new DairyProduct("Szarlotka", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("100"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("0.08"), Matchers.comparesEqualTo(product.getTaxPercent()));
	}

	@Test
	public void testPriceWithTax() {
		Product product = new DairyProduct("Oscypek", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("108"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNullName() {
		new OtherProduct(null, new BigDecimal("100.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithEmptyName() {
		new TaxFreeProduct("", new BigDecimal("100.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNullPrice() {
		new DairyProduct("Banany", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNegativePrice() {
		new TaxFreeProduct("Mandarynki", new BigDecimal("-1.00"));
	}
}
