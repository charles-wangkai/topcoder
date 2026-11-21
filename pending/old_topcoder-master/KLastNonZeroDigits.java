import java.math.BigInteger;

public class KLastNonZeroDigits {
	public String getKDigits(int N, int K) {
		BigInteger factorial = BigInteger.ONE;
		BigInteger ten = new BigInteger("10");
		for (int i = 2; i <= N; i++) {
			factorial = factorial.multiply(new BigInteger(i + ""));
			while (factorial.mod(ten).equals(BigInteger.ZERO)) {
				factorial = factorial.divide(ten);
			}
		}
		String factorialStr = factorial.toString();
		return factorialStr.substring(Math.max(0, factorialStr.length() - K),
				factorialStr.length());
	}
}
