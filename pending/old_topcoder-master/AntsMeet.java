import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class AntsMeet {
	public int countAnts(int[] x, int[] y, String direction) {
		final int MOVE_NUM = 4001;

		HashMap<Point, Direction> point2direction = new HashMap<Point, Direction>();
		for (int i = 0; i < x.length; i++) {
			point2direction.put(new Point(x[i] * 2, y[i] * 2),
					Direction.fromString(direction.charAt(i) + ""));
		}
		for (int i = 0; i < MOVE_NUM; i++) {
			HashMap<Point, ArrayList<Direction>> nextPoint2directions = new HashMap<Point, ArrayList<Direction>>();
			for (Entry<Point, Direction> entry : point2direction.entrySet()) {
				Point point = entry.getKey();
				Direction d = entry.getValue();
				Point nextPoint = new Point(point.x + d.offsetX, point.y
						+ d.offsetY);
				if (!nextPoint2directions.containsKey(nextPoint)) {
					nextPoint2directions.put(nextPoint,
							new ArrayList<Direction>());
				}
				nextPoint2directions.get(nextPoint).add(d);
			}
			point2direction.clear();
			for (Entry<Point, ArrayList<Direction>> entry : nextPoint2directions
					.entrySet()) {
				if (entry.getValue().size() == 1) {
					point2direction
							.put(entry.getKey(), entry.getValue().get(0));
				}
			}
		}
		return point2direction.size();
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		return x * y;
	}

	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}

enum Direction {
	N(0, 1), E(1, 0), S(0, -1), W(-1, 0);
	int offsetX;
	int offsetY;

	private Direction(int offsetX, int offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}

	static Direction fromString(String str) {
		return Direction.valueOf(str);
	}
}