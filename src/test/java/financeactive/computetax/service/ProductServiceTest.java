package financeactive.computetax.service;

import financeactive.computetax.model.EFamilyProduct;
import financeactive.computetax.model.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductService productService = new ProductService();

    @Test
    public void should_return_imported_additional_rate() {
        assertEquals(productService.computeRate(Product.builder()
                                                       .familyProduct(EFamilyProduct.FOOD)
                                                       .priceBeforeTax(BigDecimal.TEN)
                                                       .isImported(true)
                                                       .build()),
                     BigDecimal.valueOf(5));
    }

    @Test
    public void should_round_tax_amount() {
        assertEquals(productService.computeTaxAmount(Product.builder()
                                                            .familyProduct(EFamilyProduct.OTHER)
                                                            .priceBeforeTax(BigDecimal.valueOf(47.50))
                                                            .isImported(true)
                                                            .build()),
                     BigDecimal.valueOf(7.15));
    }

}