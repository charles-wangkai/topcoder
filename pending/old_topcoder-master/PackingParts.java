public class PackingParts {
	public int pack(int[] partSizes, int[] boxSizes) {
		int packNum = 0;
		int boxIndex = 0;
		for (int partSize : partSizes) {
			while (boxIndex < boxSizes.length && partSize > boxSizes[boxIndex]) {
				boxIndex++;
			}
			if (boxIndex == boxSizes.length) {
				break;
			}
			packNum++;
			boxIndex++;
		}
		return packNum;
	}
}
