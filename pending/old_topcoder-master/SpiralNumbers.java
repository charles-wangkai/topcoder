public class SpiralNumbers {
	public String getPosition(int N) {
		if (N == 1) {
			return toText(0, 0);
		}
		int size = 1;
		while (square(size) < N) {
			size += 2;
		}
		int remain = N - (int) square(size - 2);
		Point point = new Point(-size / 2, size / 2);
		int offsetXs[] = { 1, 0, -1, 0 };
		int offsetYs[] = { 0, -1, 0, 1 };
		for (int i = 0;; i++) {
			if (remain <= size - 1) {
				point.move(offsetXs[i], offsetYs[i], remain);
				return toText(point.x, point.y);
			}
			point.move(offsetXs[i], offsetYs[i], size - 1);
			remain -= size - 1;
		}
	}

	long square(int number) {
		return (long) number * number;
	}

	String toText(int row, int column) {
		return "(" + row + "," + column + ")";
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	void move(int offsetX, int offsetY, int step) {
		x += offsetX * step;
		y += offsetY * step;
	}
}