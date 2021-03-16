package pl.edu.agh.mwo.invoice.product;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class BottleOfWineTest extends TestCase {

    @Test
    public void testGetPriceWithTax() {
        BottleOfWine bottleOfWine = new BottleOfWine("Wino gruzińskie", new BigDecimal(100));
        Assert.assertThat(new BigDecimal("133.56"), Matchers.comparesEqualTo(bottleOfWine.getPriceWithTax()));
    }

}