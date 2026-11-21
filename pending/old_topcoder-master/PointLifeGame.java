import java.util.TreeSet;

public class PointLifeGame {
	public String simulate(int[] xs, int[] ys, int rnds) {
		TreeSet<Point> points = new TreeSet<Point>();
		for (int i = 0; i < xs.length; i++) {
			points.add(new Point(xs[i], ys[i]));
		}
		for (int i = rnds; i > 0; i--) {
			for (int j = points.size() - rnds - 1; j > 0; j--) {
				points.remove(points.last());
			}
			points = generate(points);
		}
		Point best = points.first();
		return format(best.x) + " " + format(best.y);
	}

	String format(double value) {
		int whole = (int) (value * 10000);
		return String.format("%04d.%04d", whole / 10000, whole % 10000);
	}

	TreeSet<Point> generate(TreeSet<Point> points) {
		TreeSet<Point> nextPoints = new TreeSet<Point>();
		for (Point p1 : points) {
			for (Point p2 : points) {
				if (!p1.equals(p2)) {
					nextPoints.add(new Point((p1.x + p2.x) / 2,
							(p1.y + p2.y) / 2));
				}
			}
		}
		return nextPoints;
	}
}

class Point implements Comparable<Point> {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	public int compareTo(Point other) {
		if (y != other.y) {
			return (int) Math.signum(other.y - y);
		} else {
			return (int) Math.signum(other.x - x);
		}
	}
}