public class LameKnight {
	public int maxCells(int height, int width) {
		if (height == 1) {
			return 1;
		} else if (height == 2) {
			return Math.min((width + 1) / 2, 4);
		} else if (width < 7) {
			return Math.min(width, 4);
		} else {
			return width - 2;
		}
	}
}
