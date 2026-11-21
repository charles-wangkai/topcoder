import java.util.HashSet;

public class RotatingBot {
	int minX = 0;
	int maxX = 0;
	int minY = 0;
	int maxY = 0;

	public int minArea(int[] moves) {
		if (!isValidPath(moves) || !isValidPath(moves)) {
			return -1;
		}
		return (maxX - minX + 1) * (maxY - minY + 1);
	}

	boolean isValidPath(int[] moves) {
		final int[] OFFSET_X = { 1, 0, -1, 0 };
		final int[] OFFSET_Y = { 0, 1, 0, -1 };
		HashSet<Point> history = new HashSet<Point>();
		int x = 0;
		int y = 0;
		int direction = 0;
		history.add(new Point(0, 0));
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i]; j++) {
				x += OFFSET_X[direction];
				y += OFFSET_Y[direction];
				Point point = new Point(x, y);

				if (history.contains(point)) {
					return false;
				}

				history.add(point);
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
			}
			int nextX = x + OFFSET_X[direction];
			int nextY = y + OFFSET_Y[direction];
			if (i != moves.length - 1
					&& !history.contains(new Point(nextX, nextY))
					&& nextX >= minX && nextX <= maxX && nextY >= minY
					&& nextY <= maxY) {
				return false;
			}

			direction = (direction + 1) % 4;
		}
		return true;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
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