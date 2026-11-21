import java.util.ArrayList;
import java.util.LinkedList;

public class Socialize {
	public int average(String[] layout) {
		int row = layout.length;
		int column = layout[0].length();
		char[][] grids = new char[row][column];
		ArrayList<Point> people = new ArrayList<Point>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				grids[i][j] = layout[i].charAt(j);
				if (grids[i][j] == 'P') {
					people.add(new Point(i, j));
				}
			}
		}
		int sum = 0;
		int count = 0;
		for (int i = 0; i < people.size(); i++) {
			int[][] distances = new int[row][column];
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < column; k++) {
					distances[j][k] = -1;
				}
			}
			int srcX = people.get(i).x;
			int srcY = people.get(i).y;
			distances[srcX][srcY] = 0;
			LinkedList<Point> queue = new LinkedList<Point>();
			queue.add(new Point(srcX, srcY));
			while (!queue.isEmpty()) {
				Point point = queue.poll();
				int[] offsetX = { -1, 0, 1, 0 };
				int[] offsetY = { 0, -1, 0, 1 };
				for (int j = 0; j < 4; j++) {
					int nextX = point.x + offsetX[j];
					int nextY = point.y + offsetY[j];
					if (nextX >= 0 && nextX < row && nextY >= 0
							&& nextY < column && grids[nextX][nextY] != '#') {
						if (distances[nextX][nextY] == -1) {
							distances[nextX][nextY] = distances[point.x][point.y] + 1;
							queue.add(new Point(nextX, nextY));
							if (grids[nextX][nextY] == 'P') {
								sum += distances[nextX][nextY];
								count++;
							}
						}
					}
				}
			}
		}
		if (count == 0) {
			return 0;
		}
		return (int) Math.round((double) sum / count);
	}
}

class Point {
	int x;
	int y;

	Point(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
}