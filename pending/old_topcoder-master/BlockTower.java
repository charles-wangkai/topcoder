public class BlockTower {
	public int getTallest(int[] blockHeights) {
		int maxTotalHeight = 0;
		int totalHeightEven = 0;
		for (int i = 0; i < blockHeights.length; i++) {
			if (blockHeights[i] % 2 == 0) {
				totalHeightEven += blockHeights[i];
				maxTotalHeight = Math.max(maxTotalHeight, totalHeightEven);
			} else {
				int totalHeightOdd = totalHeightEven + blockHeights[i];
				for (int j = i + 1; j < blockHeights.length; j++) {
					if (blockHeights[j] % 2 != 0) {
						totalHeightOdd += blockHeights[j];
					}
				}
				maxTotalHeight = Math.max(maxTotalHeight, totalHeightOdd);
			}
		}
		return maxTotalHeight;
	}
}
