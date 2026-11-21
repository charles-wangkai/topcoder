public class KingdomAndTrees {
	public int minLevel(int[] heights) {
		int result = 0;
		for (int i = 0; i < heights.length; i++) {
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[i] + (j - i) > heights[j]) {
					int x;
					if (1 + (j - i) > heights[j] + (heights[i] - 1)) {
						x = 1 + (j - i) - heights[j];
					} else {
						x = (heights[i] + (j - i) - heights[j] + 1) / 2;
					}
					result = Math.max(result, x);
				}
			}
		}
		return result;
	}
}
