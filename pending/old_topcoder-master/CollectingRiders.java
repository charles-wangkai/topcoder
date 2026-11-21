import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CollectingRiders {
	public int minimalMoves(String[] board) {
		int row = board.length;
		int column = board[0].length();
		ArrayList<Rider> riders = new ArrayList<Rider>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				char cell = board[i].charAt(j);
				if (cell != '.') {
					riders.add(new Rider(row, column, i, j, cell - '0'));
				}
			}
		}
		int minMove = -1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int move = 0;
				boolean possible = true;
				for (Rider rider : riders) {
					if (rider.moves[i][j] < 0) {
						possible = false;
						break;
					}
					move += rider.moves[i][j];
				}
				if (possible && (minMove < 0 || move < minMove)) {
					minMove = move;
				}
			}
		}
		return minMove;
	}
}

class Rider {
	int moves[][];

	Rider(int row, int column, int x, int y, int maxJumpPerMove) {
		moves = new int[row][column];
		for (int i = 0; i < row; i++) {
			Arrays.fill(moves[i], -1);
		}
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		moves[x][y] = 0;
		while (!queue.isEmpty()) {
			Point head = queue.poll();
			int offsetX[] = { 1, 1, 2, 2, -1, -1, -2, -2 };
			int offsetY[] = { 2, -2, 1, -1, 2, -2, 1, -1 };
			for (int i = 0; i < offsetX.length; i++) {
				int nextX = head.x + offsetX[i];
				int nextY = head.y + offsetY[i];
				if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column
						&& moves[nextX][nextY] < 0) {
					moves[nextX][nextY] = moves[head.x][head.y] + 1;
					queue.offer(new Point(nextX, nextY));
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (moves[i][j] >= 0) {
					moves[i][j] = divideToCeil(moves[i][j], maxJumpPerMove);
				}
			}
		}
	}

	int divideToCeil(int a, int b) {
		return a / b + ((a % b == 0) ? 0 : 1);
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}