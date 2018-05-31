package financeactive.computetax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EFamilyProduct {

    BOOK(ETaxRate.EXEMPTED),
    FOOD(ETaxRate.EXEMPTED),
    MEDICINE(ETaxRate.EXEMPTED),
    OTHER(ETaxRate.NORMAL);

    //It should be replaced by a reference entity if we have a database
    private ETaxRate taxRate;
}
