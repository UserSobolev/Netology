package tax;

import java.math.BigDecimal;

public class ProgressiveTaxType extends TaxType {
    //  прогрессивный до 100 тысяч = 10%, больше 100 тысяч = 15%
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(100_000)) < 1 ) {
            return amount.multiply(BigDecimal.valueOf(0.1));
        } else {
            return amount.multiply(BigDecimal.valueOf(0.15));
        }
    }
}
