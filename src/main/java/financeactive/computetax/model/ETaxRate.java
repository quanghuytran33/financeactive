package financeactive.computetax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum ETaxRate {

    NORMAL(BigDecimal.TEN),
    EXEMPTED(BigDecimal.ZERO),
    IMPORTED(BigDecimal.valueOf(5));

    private BigDecimal rate;
}
