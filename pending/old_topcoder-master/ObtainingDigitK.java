import java.math.BigInteger;

public class ObtainingDigitK {
	public int minNumberToAdd(String originalNumber, int k) {
		BigInteger number = new BigInteger(originalNumber);
		for (int i = 0;; i++) {
			if (number.toString().indexOf(k + '0') >= 0) {
				return i;
			}
			number = number.add(BigInteger.ONE);
		}
	}
}
