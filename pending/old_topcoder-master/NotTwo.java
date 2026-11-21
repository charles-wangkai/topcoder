public class NotTwo {
	public int maxStones(int width, int height) {
		int result = 0;
		for (int i = 0; i < height; i++) {
			if (i / 2 % 2 == 0) {
				result += width / 4 * 2 + Math.min(2, width % 4);
			} else {
				result += width / 4 * 2 + (width % 4 == 3 ? 1 : 0);
			}
		}
		return result;
	}
}
