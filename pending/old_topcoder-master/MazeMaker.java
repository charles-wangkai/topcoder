import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
	public int longestPath(String[] maze, int startRow, int startCol,
			int[] moveRow, int[] moveCol) {
		int maxPath = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length(); j++) {
				if (maze[i].charAt(j) == '.') {
					int path = bfs(maze, startRow, startCol, moveRow, moveCol,
							i, j);
					if (path < 0) {
						return -1;
					}
					maxPath = Math.max(maxPath, path);
				}
			}
		}
		return maxPath;
	}

	int bfs(String[] maze, int startRow, int startCol, int[] moveRow,
			int[] moveCol, int endRow, int endCol) {
		int row = maze.length;
		int column = maze[0].length();
		boolean[][] visited = new boolean[row][column];
		visited[startRow][startCol] = true;
		Queue<Element> queue = new LinkedList<Element>();
		queue.offer(new Element(startRow, startCol, 0));
		while (!queue.isEmpty()) {
			Element head = queue.poll();
			if (head.x == endRow && head.y == endCol) {
				return head.path;
			}
			for (int i = 0; i < moveRow.length; i++) {
				int nextX = head.x + moveRow[i];
				int nextY = head.y + moveCol[i];
				if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column
						&& maze[nextX].charAt(nextY) == '.'
						&& !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					queue.offer(new Element(nextX, nextY, head.path + 1));
				}
			}
		}
		return -1;
	}
}

class Element {
	int x;
	int y;
	int path;

	public Element(int x, int y, int path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}
}