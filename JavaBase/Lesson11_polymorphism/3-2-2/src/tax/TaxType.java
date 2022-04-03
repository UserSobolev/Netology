package tax;

import java.math.BigDecimal;

public class TaxType {
    public BigDecimal calculateTaxFor(BigDecimal amount) {

        return amount.multiply(BigDecimal.valueOf(0.0));
    }
}
