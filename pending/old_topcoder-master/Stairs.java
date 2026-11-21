public class Stairs {
	public int designs(int maxHeight, int minWidth, int totalHeight,
			int totalWidth) {
		int designNum = 0;
		for (int i = 1; i <= maxHeight; i++) {
			if (totalHeight % i == 0) {
				int treadNum = totalHeight / i - 1;
				if (treadNum > 0 && totalWidth % treadNum == 0
						&& totalWidth / treadNum >= minWidth) {
					designNum++;
				}
			}
		}
		return designNum;
	}
}
