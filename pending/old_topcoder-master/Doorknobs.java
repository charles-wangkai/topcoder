import java.util.ArrayList;
import java.util.LinkedList;

public class Doorknobs {
	int min;
	boolean used[];
	int distances[][];

	public int shortest(String[] house, int doorknobs) {
		int row = house.length;
		int column = house[0].length();
		ArrayList<Point> knobs = new ArrayList<Point>();
		knobs.add(new Point(0, 0));
		char grid[][] = new char[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				grid[i][j] = house[i].charAt(j);
				if (grid[i][j] == 'o') {
					knobs.add(new Point(i, j));
				}
			}
		}
		int knobNum = knobs.size();
		distances = new int[knobNum][knobNum];
		for (int i = 0; i < knobNum; i++) {
			for (int j = 0; j < knobNum; j++) {
				if (i != j) {
					distances[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < knobNum; i++) {
			boolean visited[][] = new boolean[row][column];
			LinkedList<Element> queue = new LinkedList<Element>();
			Point p = knobs.get(i);
			queue.add(new Element(p, 0));
			visited[p.x][p.y] = true;
			while (!queue.isEmpty()) {
				Element head = queue.poll();
				int offsetX[] = { -1, 0, 1, 0 };
				int offsetY[] = { 0, 1, 0, -1 };
				for (int j = 0; j < 4; j++) {
					int newX = head.point.x + offsetX[j];
					int newY = head.point.y + offsetY[j];
					if (newX >= 0 && newX < row && newY >= 0 && newY < column
							&& grid[newX][newY] != '#' && !visited[newX][newY]) {
						queue.offer(new Element(new Point(newX, newY),
								head.step + 1));
						visited[newX][newY] = true;
						if (grid[newX][newY] == 'o') {
							for (int k = 0; k < knobNum; k++) {
								if (knobs.get(k).x == newX
										&& knobs.get(k).y == newY) {
									distances[i][k] = head.step + 1;
									break;
								}
							}
						}
					}
				}
			}
		}
		min = Integer.MAX_VALUE;
		used = new boolean[knobNum];
		search(doorknobs, 0, 0);
		if (min == Integer.MAX_VALUE) {
			return -1;
		} else {
			return min;
		}
	}

	void search(int rest, int previous, int step) {
		if (rest == 0) {
			min = Math.min(min, step);
			return;
		}
		for (int i = 1; i < used.length; i++) {
			if (!used[i] && distances[previous][i] != -1) {
				used[i] = true;
				search(rest - 1, i, step + distances[previous][i]);
				used[i] = false;
			}
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

	class Element {
		Point point;
		int step;

		Element(Point thePoint, int theStep) {
			this.point = thePoint;
			this.step = theStep;
		}
	}
}
