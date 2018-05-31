package financeactive.computetax.service;

import com.google.common.annotations.VisibleForTesting;
import financeactive.computetax.model.ETaxRate;
import financeactive.computetax.model.Product;
import util.BigDecimals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ProductService {

    public void computePriceAndTax(final Product product) {
        BigDecimal taxAmount = computeTaxAmount(product);
        product.setTaxAmount(taxAmount);
        product.setPriceIncludeTax(taxAmount.add(product.getPriceBeforeTax()));
    }

    @VisibleForTesting
    BigDecimal computeTaxAmount(final Product product) {
        BigDecimal taxAmount = product.getPriceBeforeTax()
                                      .multiply(computeRate(product).divide(BigDecimal.valueOf(100)),
                                                new MathContext(3, RoundingMode.HALF_UP));
        return BigDecimals.roundToNearestHalf(taxAmount);
    }

    @VisibleForTesting
    BigDecimal computeRate(final Product product) {
        BigDecimal basicRate = product.getFamilyProduct().getTaxRate().getRate();
        return product.isImported() ? basicRate.add(ETaxRate.IMPORTED.getRate()) : basicRate;
    }
}
