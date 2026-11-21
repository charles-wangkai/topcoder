public class MagicalGirlLevelOneDivTwo {
	public double theMinDistance(int d, int x, int y) {
		int dx;
		if (x > d) {
			dx = x - d;
		} else if (x < -d) {
			dx = -d - x;
		} else {
			dx = 0;
		}
		int dy;
		if (y > d) {
			dy = y - d;
		} else if (y < -d) {
			dy = -d - y;
		} else {
			dy = 0;
		}
		return Math.sqrt(dx * dx + dy * dy);
	}
}
