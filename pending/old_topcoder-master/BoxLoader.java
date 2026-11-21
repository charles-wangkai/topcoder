public class BoxLoader {
	public int mostItems(int boxX, int boxY, int boxZ, int itemX, int itemY,
			int itemZ) {
		int orientations[][] = { { itemX, itemY, itemZ },
				{ itemX, itemZ, itemY }, { itemY, itemX, itemZ },
				{ itemY, itemZ, itemX }, { itemZ, itemX, itemY },
				{ itemZ, itemY, itemX } };
		int maxItemNum = -1;
		for (int orientation[] : orientations) {
			int itemNum = (boxX / orientation[0]) * (boxY / orientation[1])
					* (boxZ / orientation[2]);
			maxItemNum = Math.max(maxItemNum, itemNum);
		}
		return maxItemNum;
	}
}
