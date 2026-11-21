public class TrophyShelf {
	public int[] countVisible(int[] trophies) {
		return new int[] { visible(trophies, 0, 1),
				visible(trophies, trophies.length - 1, -1) };
	}

	int visible(int trophies[], int startIndex, int offset) {
		Integer tallest = -1;
		int count = 0;
		int index = startIndex;
		for (int i = 0; i < trophies.length; i++) {
			if (trophies[index] > tallest) {
				tallest = trophies[index];
				count++;
			}
			index += offset;
		}
		return count;
	}
}
