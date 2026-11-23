import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Paycheck {
  public double solve(int[] hours) {
    double[] pays =
        Arrays.stream(hours).mapToDouble(hour -> 10 * hour + 1.5 * Math.max(0, hour - 8)).toArray();
    pays[0] *= 1.5;
    pays[6] *= 2.25;

    return BigDecimal.valueOf(
            Arrays.stream(pays).sum()
                + 2.5 * Math.max(0, IntStream.rangeClosed(1, 5).map(i -> hours[i]).sum() - 40))
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
