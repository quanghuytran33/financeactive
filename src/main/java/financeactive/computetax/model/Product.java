package financeactive.computetax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Product {

    private EFamilyProduct familyProduct;

    private String label;

    private BigDecimal priceBeforeTax;

    private BigDecimal taxAmount;

    private BigDecimal priceIncludeTax;

    private boolean isImported;
}
