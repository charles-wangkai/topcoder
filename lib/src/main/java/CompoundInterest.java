import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompoundInterest {
  public double getInterestRate(double starting, double ending) {
    return BigDecimal.valueOf((Math.exp(Math.log(ending / starting) / 8) - 1) * 100)
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
