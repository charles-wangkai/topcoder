public class BritishCoins {
	public int[] coins(int pence) {
		int units[] = { 240, 12, 1 };
		int result[] = new int[3];
		for (int i = 0; i < result.length; i++) {
			result[i] = pence / units[i];
			pence %= units[i];
		}
		return result;
	}
}
