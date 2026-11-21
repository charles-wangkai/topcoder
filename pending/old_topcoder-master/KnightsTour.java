import java.util.ArrayList;

public class KnightsTour {
	public int visitedPositions(String[] board) {
		Point current = findStart(board);
		int visitedCount = 1;
		while (true) {
			int minAccessNum = Integer.MAX_VALUE;
			Point next = null;
			for (Point point : findAccessibleCells(board, current)) {
				int accessNum = findAccessibleCells(board, point).size();
				if (accessNum < minAccessNum
						|| (accessNum == minAccessNum && (point.x < next.x || (point.x == next.x && point.y < next.y)))) {
					minAccessNum = accessNum;
					next = point;
				}
			}
			if (next == null) {
				break;
			}
			setCharAt(board, next.x, next.y, 'V');
			current = next;
			visitedCount++;
		}
		return visitedCount;
	}

	void setCharAt(String[] board, int x, int y, char ch) {
		board[x] = board[x].substring(0, y) + ch + board[x].substring(y + 1);
	}

	Point findStart(String[] board) {
		for (int x = 0;; x++) {
			for (int y = 0; y < board[x].length(); y++) {
				if (board[x].charAt(y) == 'K') {
					return new Point(x, y);
				}
			}
		}
	}

	ArrayList<Point> findAccessibleCells(String[] board, Point point) {
		ArrayList<Point> accessibleCells = new ArrayList<Point>();
		int row = board.length;
		int column = board[0].length();
		int offsetX[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int offsetY[] = { -1, 1, -2, 2, -2, 2, -1, 1 };
		for (int i = 0; i < offsetX.length; i++) {
			int nextX = point.x + offsetX[i];
			int nextY = point.y + offsetY[i];
			if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column
					&& board[nextX].charAt(nextY) == '.') {
				accessibleCells.add(new Point(nextX, nextY));
			}
		}
		return accessibleCells;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
