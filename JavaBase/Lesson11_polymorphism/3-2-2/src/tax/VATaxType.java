package tax;

import java.math.BigDecimal;

public class VATaxType extends TaxType {
    //  налог 18%
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {

        return amount.multiply(BigDecimal.valueOf(0.18));
    }
}
