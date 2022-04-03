package tax;

import java.math.BigDecimal;

public class IncomeTaxType  extends TaxType {
    //  налог 13%
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.13));
    }
}
