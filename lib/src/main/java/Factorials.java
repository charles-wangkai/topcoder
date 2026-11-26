import java.math.BigInteger;

public class Factorials {
  public int largestPower(int n, int b) {
    BigInteger rest = BigInteger.ONE;
    for (int i = 1; i <= n; ++i) {
      rest = rest.multiply(BigInteger.valueOf(i));
    }

    int result = 0;
    while (rest.mod(BigInteger.valueOf(b)).equals(BigInteger.ZERO)) {
      rest = rest.divide(BigInteger.valueOf(b));
      ++result;
    }

    return result;
  }
}
