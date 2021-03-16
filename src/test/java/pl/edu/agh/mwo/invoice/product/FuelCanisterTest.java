package pl.edu.agh.mwo.invoice.product;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FuelCanisterTest extends TestCase {

    @Test
    public void testGetPriceWithTax() {
        FuelCanister fuelCanister = new FuelCanister("Karnister", new BigDecimal(100));
        Assert.assertThat(new BigDecimal("128.56"), Matchers.comparesEqualTo(fuelCanister.getPriceWithTax()));
    }

}