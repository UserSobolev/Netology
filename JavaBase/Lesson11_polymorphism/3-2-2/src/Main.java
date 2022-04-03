import bill.Bill;
import tax.IncomeTaxType;
import tax.ProgressiveTaxType;
import tax.TaxService;
import tax.VATaxType;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        IncomeTaxType incomeTaxType = new IncomeTaxType();
        VATaxType vaTaxType = new VATaxType();
        ProgressiveTaxType progressiveTaxType = new ProgressiveTaxType();

        Bill[] payments = new Bill[] {
                // TODO создать платежи с различным типами налогообложения
                new Bill(new BigDecimal(10_000), incomeTaxType, taxService),
                new Bill(new BigDecimal(10_000), vaTaxType, taxService),
                new Bill(new BigDecimal(15_000), progressiveTaxType, taxService),
                new Bill(new BigDecimal(200_000), progressiveTaxType, taxService),
        };

        for (int i = 0; i < payments.length; ++i) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }
}
