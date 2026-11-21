import java.math.BigInteger;
import java.util.HashMap;

public class MatchNumbersEasy {
	HashMap<Integer, BigInteger> history = new HashMap<Integer, BigInteger>();

	public String maxNumber(int[] matches, int n) {
		return search(matches, n).toString();
	}

	BigInteger search(int matches[], int left) {
		if (history.containsKey(left)) {
			return history.get(left);
		}
		BigInteger result = BigInteger.ZERO;
		for (int i = 0; i < matches.length; i++) {
			if (matches[i] <= left) {
				BigInteger next = search(matches, left - matches[i]).multiply(
						new BigInteger("10")).add(new BigInteger(i + ""));
				if (next.compareTo(result) > 0) {
					result = next;
				}
			}
		}
		history.put(left, result);
		return result;
	}
}
