package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimals {

    public static BigDecimal roundToNearestHalf(BigDecimal number) {
        return new BigDecimal(Math.ceil(number.doubleValue() * 20) / 20).setScale(2, RoundingMode.HALF_UP);
    }
}
