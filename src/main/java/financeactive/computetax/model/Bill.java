package financeactive.computetax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {

    private List<Product> products;
    private BigDecimal totalTaxAmount;
    private BigDecimal totalPrice;
}
