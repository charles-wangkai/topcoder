public class Aquarium {
	public int peaceful(int minSize, int maxSize, int[] fishSizes) {
		int count = 0;
		for (int size = minSize; size <= maxSize; size++) {
			boolean peace = true;
			for (int fishSize : fishSizes) {
				if (eat(size, fishSize) || eat(fishSize, size)) {
					peace = false;
					break;
				}
			}
			if (peace) {
				count++;
			}
		}
		return count;
	}

	static boolean eat(int big, int small) {
		return big >= 2 * small && big <= small * 10;
	}
}
