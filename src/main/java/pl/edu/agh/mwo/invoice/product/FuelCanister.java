package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuelCanister extends ExciseProduct{
    public FuelCanister(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }

    @Override
    public BigDecimal getPriceWithTax() {
        LocalDate date = LocalDate.now();
        if (date.getDayOfMonth() == 26 && date.getMonthValue() == 4 ){
            return super.getPriceWithTax().subtract(BigDecimal.valueOf(excise));
        }
        return super.getPriceWithTax();
    }
}
