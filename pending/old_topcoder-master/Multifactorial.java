import java.math.BigInteger;

public class Multifactorial {
	public String calcMultiFact(int n, int k) {
		BigInteger LIMIT = new BigInteger("10").pow(18);
		BigInteger result = new BigInteger(n + "");
		while (true) {
			if (result.compareTo(LIMIT) > 0) {
				return "overflow";
			}
			if (n <= k) {
				break;
			}
			n -= k;
			result = result.multiply(new BigInteger(n + ""));
		}
		return result.toString();
	}
}
