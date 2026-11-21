public class BeautifulString {
	public int maximumLength(int countA, int countB, int maxA, int maxB) {
		int counts[] = { countA, countB };
		int maxs[] = { maxA, maxB };
		int maxBlocks[] = new int[2];
		for (int i = 0; i < maxBlocks.length; i++) {
			maxBlocks[i] = getMaxBlock(counts[i], maxs[i]);
		}
		int maxLength = 0;
		for (int i = 0; i < 2; i++) {
			int diffs[] = { -1, 0, 1 };
			for (int diff : diffs) {
				int block = maxBlocks[i] + diff;
				if (block >= 0 && block <= maxBlocks[1 - i]) {
					maxLength = Math.max(
							maxLength,
							getLength(counts[i], maxs[i], maxBlocks[i])
									+ getLength(counts[1 - i], maxs[1 - i],
											block));
				}
			}
		}
		return maxLength;
	}

	int getMaxBlock(int count, int max) {
		return (max == 0) ? 0 : count;
	}

	int getLength(int count, int max, int block) {
		return (int) Math.min((long) block * max, count);
	}
}
