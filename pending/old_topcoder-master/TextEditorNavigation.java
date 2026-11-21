import java.util.LinkedList;

public class TextEditorNavigation {
	int row;
	int column;
	int strokes[][];
	LinkedList<Position> queue;

	public int keystrokes(String[] source, int[] start, int[] finish) {
		if (start[0] == finish[0] && start[1] == finish[1]) {
			return 0;
		}
		row = source.length;
		column = 50;
		int lineLengths[] = new int[row];
		char code[][] = new char[row][column];
		for (int i = 0; i < row; i++) {
			lineLengths[i] = source[i].length();
			for (int j = 0; j < source[i].length(); j++) {
				code[i][j] = source[i].charAt(j);
			}
			for (int j = source[i].length(); j < column; j++) {
				code[i][j] = ' ';
			}
		}
		strokes = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				strokes[i][j] = -1;
			}
		}
		queue = new LinkedList<Position>();
		strokes[start[0]][start[1]] = 0;
		queue.offer(new Position(start[0], start[1]));
		while (true) {
			Position head = queue.poll();
			int x = head.x;
			int y = head.y;
			int leftWord = y;
			for (int i = y - 1; i >= 0; i--) {
				if ((i == 0 && code[x][i] != ' ')
						|| (i > 0 && code[x][i] != ' ' && code[x][i - 1] == ' ')) {
					leftWord = i;
					break;
				}
			}
			int rightWord = y;
			for (int i = y + 1; i < lineLengths[x]; i++) {
				if (code[x][i] != ' ' && code[x][i - 1] == ' ') {
					rightWord = i;
					break;
				}
			}
			int newStroke = strokes[x][y] + 1;
			int newX[] = { x - 1, x + 1, x, x, 0, row - 1, x, x, x, x };
			int newY[] = { y, y, y - 1, y + 1, y, y, 0, lineLengths[x] - 1,
					leftWord, rightWord };
			for (int i = 0; i < newX.length; i++) {
				if (newX[i] == finish[0] && newY[i] == finish[1]) {
					return newStroke;
				}
				insert(newX[i], newY[i], newStroke);
			}
		}
	}

	void insert(int x, int y, int stroke) {
		if (x >= 0 && x < row && y >= 0 && y < column && strokes[x][y] == -1) {
			strokes[x][y] = stroke;
			queue.offer(new Position(x, y));
		}
	}
}

class Position {
	int x;
	int y;

	Position(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
}