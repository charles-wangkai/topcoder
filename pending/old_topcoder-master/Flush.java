import java.math.BigInteger;

public class Flush {
	double result;

	public double size(int[] suits, int number) {
		int cardTotal = 0;
		for (int suit : suits) {
			cardTotal += suit;
		}
		long wayTotal = C(cardTotal, number);
		result = 0;
		search(0, new int[suits.length], suits, number, wayTotal);
		return result;
	}

	long C(int n, int m) {
		BigInteger result = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= m; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result.longValue();
	}

	void search(int index, int selected[], int suits[], int rest, long wayTotal) {
		if (index == selected.length - 1) {
			selected[index] = rest;
			long way = 1;
			long largest = 0;
			for (int i = 0; i < selected.length; i++) {
				way *= C(suits[i], selected[i]);
				largest = Math.max(largest, selected[i]);
			}
			result += (double) way / wayTotal * largest;
		} else {
			for (int i = 0; i <= rest; i++) {
				selected[index] = i;
				search(index + 1, selected, suits, rest - i, wayTotal);
			}
		}
	}
}
