import java.math.BigInteger;

public class LuckyRemainder {
	final int MODULO = 9;

	public int getLuckyRemainder(String X) {
		int luckyReminder = 0;
		for (int i = X.length() - 1; i >= 0; i--) {
			for (int j = i; j < X.length(); j++) {
				int occurrence = multiplyMod(powMod(2, i),
						CMod(X.length() - i - 1, X.length() - j - 1));
				luckyReminder = addMod(luckyReminder,
						multiplyMod(X.charAt(i) - '0', occurrence));
			}
		}
		return luckyReminder;
	}

	int powMod(int base, int exponent) {
		int result = 1;
		for (int i = 0; i < exponent; i++) {
			result = multiplyMod(result, base);
		}
		return result;
	}

	int addMod(int a, int b) {
		return (a + b) % MODULO;
	}

	int multiplyMod(int a, int b) {
		return a * b % MODULO;
	}

	int CMod(int n, int m) {
		BigInteger result = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= m; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result.mod(new BigInteger(MODULO + "")).intValue();
	}
}
