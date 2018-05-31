package financeactive.computetax.service;

import lombok.AllArgsConstructor;
import financeactive.computetax.model.Bill;
import financeactive.computetax.model.Product;

import java.math.BigDecimal;

@AllArgsConstructor
public class BillService {

    private ProductService productService;

    public Bill computeTotalTaxAmountAndPrice(final Bill bill) {
        computeTaxAllProduct(bill);
        bill.setTotalTaxAmount(computeTotalTaxAmount(bill));
        bill.setTotalPrice(computeTotalPrice(bill));
        return bill;
    }

    private void computeTaxAllProduct(final Bill bill) {
        bill.getProducts().stream().forEach(product -> productService.computePriceAndTax(product));
    }

    private BigDecimal computeTotalTaxAmount(final Bill bill) {
        return bill.getProducts().stream().map(Product::getTaxAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal computeTotalPrice(final Bill bill) {
        return bill.getProducts().stream().map(Product::getPriceIncludeTax).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
