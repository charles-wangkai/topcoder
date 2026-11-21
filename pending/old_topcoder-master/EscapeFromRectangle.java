public class EscapeFromRectangle {
	public int shortest(int x, int y, int w, int h) {
		return Math.min(Math.min(x, y), Math.min(w - x, h - y));
	}
}
