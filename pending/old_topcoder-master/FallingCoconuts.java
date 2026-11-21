import java.util.HashSet;

public class FallingCoconuts {
	public String[] harvest(int[] drops) {
		final int MAX_Y = drops.length - 1;
		HashSet<Point> history = new HashSet<Point>();
		for (int drop : drops) {
			Point point = new Point(drop, MAX_Y);
			while (true) {
				Point downPoint = point.getDownPoint();
				Point leftDownPoint = point.getLeftDownPoint();
				Point rightDownPoint = point.getRightDownPoint();
				if (point.y == 0
						|| (history.contains(downPoint)
								&& history.contains(leftDownPoint) && history
									.contains(rightDownPoint))) {
					break;
				}
				if (!history.contains(downPoint)) {
					point = downPoint;
				} else if (!history.contains(rightDownPoint)) {
					point = rightDownPoint;
				} else {
					point = leftDownPoint;
				}
			}
			history.add(point);
		}
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (Point point : history) {
			minX = Math.min(minX, point.x);
			maxX = Math.max(maxX, point.x);
			minY = Math.min(minY, point.y);
			maxY = Math.max(maxY, point.y);
		}
		String config[] = new String[maxY - minY + 1];
		for (int i = 0; i < config.length; i++) {
			config[i] = "";
			for (int j = 0; j < maxX - minX + 1; j++) {
				config[i] += "-";
			}
		}
		for (Point point : history) {
			String old = config[point.y - minY];
			config[point.y - minY] = old.substring(0, point.x - minX) + "O"
					+ old.substring(point.x - minX + 1);
		}
		return config;
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

	Point getDownPoint() {
		return new Point(x, y - 1);
	}

	Point getLeftDownPoint() {
		return new Point(x - 1, y - 1);
	}

	Point getRightDownPoint() {
		return new Point(x + 1, y - 1);
	}
}