public class BuyingFlowers {
	public int buy(int[] roses, int[] lilies) {
		int result = Integer.MAX_VALUE;
		for (int code = (1 << roses.length) - 1; code >= 1; code--) {
			boolean used[] = decode(code, roses.length);
			int roseTotal = 0;
			int lilyTotal = 0;
			for (int i = 0; i < roses.length; i++) {
				if (used[i]) {
					roseTotal += roses[i];
					lilyTotal += lilies[i];
				}
			}
			if (Math.abs(roseTotal - lilyTotal) <= 1) {
				int total = roseTotal + lilyTotal;
				for (int j = 1; j * j <= total; j++) {
					if (total % j == 0) {
						result = Math.min(result, total / j - j);
					}
				}
			}
		}
		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	boolean[] decode(int code, int size) {
		boolean used[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			used[i] = (code % 2 != 0);
			code /= 2;
		}
		return used;
	}
}
