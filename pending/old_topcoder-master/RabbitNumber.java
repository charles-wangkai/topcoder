public class RabbitNumber {
	public int theCount(int low, int high) {
		int count = 0;
		int limit = (int) Math.round(Math.pow(4, 10));
		for (int i = 0; i < limit; i++) {
			long x = Long.parseLong(Long.toString(i, 4));
			if (x >= low && x <= high) {
				int sxx = S(x * x + "");
				int sx = S(x + "");
				if (sxx == sx * sx) {
					count++;
				}
			}
		}
		return count;
	}

	int S(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			result += str.charAt(i) - '0';
		}
		return result;
	}
}
