public class PaperAndPaintEasy {
	public long computeArea(int width, int height, int xfold, int cnt, int x1,
			int y1, int x2, int y2) {
		xfold = Math.min(xfold, width - xfold);
		int totalWidth = 0;
		if (x1 < xfold) {
			totalWidth += (Math.min(x2, xfold) - x1) * 2;
		}
		if (x2 > xfold) {
			totalWidth += x2 - Math.max(x1, xfold);
		}
		return (long) width * height - (long) totalWidth * (y2 - y1)
				* (cnt + 1);
	}
}
