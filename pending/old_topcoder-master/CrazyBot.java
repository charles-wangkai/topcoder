import java.util.HashSet;

public class CrazyBot {
	double simpleProb = 0;
	HashSet<Point> path = new HashSet<Point>();
	final static int OFFSET_X[] = { 1, -1, 0, 0 };
	final static int OFFSET_Y[] = { 0, 0, -1, 1 };

	public double getProbability(int n, int east, int west, int south, int north) {
		Point point = new Point(0, 0);
		path.add(point);
		search(new int[] { east, west, south, north }, n, 1, point);
		return simpleProb;
	}

	void search(int percents[], int restStep, double prob, Point point) {
		if (restStep == 0) {
			simpleProb += prob;
			return;
		}
		for (int i = 0; i < percents.length; i++) {
			Point nextPoint = new Point(point.x + OFFSET_X[i], point.y
					+ OFFSET_Y[i]);
			if (!path.contains(nextPoint)) {
				path.add(nextPoint);
				search(percents, restStep - 1, percents[i] / 100.0 * prob,
						nextPoint);
				path.remove(nextPoint);
			}
		}
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
		Point another = (Point) obj;
		return x == another.x && y == another.y;
	}
}