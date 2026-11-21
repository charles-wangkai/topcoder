public class DreamingAboutCarrots {
	public int carrotsBetweenCarrots(int x1, int y1, int x2, int y2) {
		int diffX = Math.abs(x1 - x2);
		int diffY = Math.abs(y1 - y2);
		int common = gcd(diffX, diffY);
		return common - 1;
	}

	int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
