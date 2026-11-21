public class RectangularGrid {
	public long countRectangles(int width, int height) {
		long result = (width + 1L) * width / 2 * (height + 1) * height / 2;
		while (width > 0 && height > 0) {
			result -= width * height;
			width--;
			height--;
		}
		return result;
	}
}
