import java.util.ArrayList;
import java.util.HashSet;

public class MazeWanderingEasy {
	boolean found = false;
	ArrayList<Point> path = new ArrayList<Point>();
	HashSet<Point> history = new HashSet<Point>();

	public int decisions(String[] maze) {
		Point start = findPoint('M', maze);
		Point end = findPoint('*', maze);
		path.add(start);
		history.add(start);
		dfs(start, end, maze);
		int decisionNum = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			if (findNeighbors(path.get(i), maze).size() > (i == 0 ? 1 : 2)) {
				decisionNum++;
			}
		}
		return decisionNum;
	}

	Point findPoint(char target, String[] maze) {
		for (int x = 0;; x++) {
			for (int y = 0; y < maze[x].length(); y++) {
				if (maze[x].charAt(y) == target) {
					return new Point(x, y);
				}
			}
		}
	}

	void dfs(Point current, Point end, String[] maze) {
		if (current.equals(end)) {
			found = true;
			return;
		}
		for (Point neighbor : findNeighbors(current, maze)) {
			if (!history.contains(neighbor)) {
				path.add(neighbor);
				history.add(neighbor);
				dfs(neighbor, end, maze);
				if (found) {
					break;
				}
				path.remove(path.size() - 1);
			}
		}
	}

	ArrayList<Point> findNeighbors(Point point, String[] maze) {
		int row = maze.length;
		int column = maze[0].length();
		int offsetX[] = { -1, 0, 1, 0 };
		int offsetY[] = { 0, 1, 0, -1 };
		ArrayList<Point> neighbors = new ArrayList<Point>();
		for (int i = 0; i < offsetX.length; i++) {
			int nextX = point.x + offsetX[i];
			int nextY = point.y + offsetY[i];
			if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column
					&& maze[nextX].charAt(nextY) != 'X') {
				neighbors.add(new Point(nextX, nextY));
			}
		}
		return neighbors;
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