import java.util.HashSet;

public class TheNewHouseDivTwo {
	public int count(int[] x, int[] y) {
		Point[] points = new Point[x.length];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(x[i], y[i]);
		}
		HashSet<Point> locations = new HashSet<Point>();
		for (Point north : points) {
			for (Point south : points) {
				if (!(north.x == south.x && north.y - south.y > 1)) {
					continue;
				}
				for (Point west : points) {
					if (!(west.x < north.x && west.y < north.y && west.y > south.y)) {
						continue;
					}
					for (Point east : points) {
						if (!(west.y == east.y && east.x > north.x)) {
							continue;
						}
						locations.add(new Point(north.x, west.y));
					}
				}
			}
		}
		return locations.size();
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x * y;
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}