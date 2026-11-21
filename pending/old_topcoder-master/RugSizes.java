public class RugSizes {
	public int rugCount(int area) {
		int rugNum = 0;
		for (int i = 1; i * i <= area; i++) {
			if (area % i != 0) {
				continue;
			}
			int size = area / i;
			if (i != size && i % 2 == 0 && size % 2 == 0) {
				continue;
			}
			rugNum++;
		}
		return rugNum;
	}
}
