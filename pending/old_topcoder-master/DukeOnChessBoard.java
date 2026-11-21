import java.util.ArrayList;

public class DukeOnChessBoard {
	public String dukePath(int n, String initPosition) {
		boolean visited[][] = new boolean[n][n];
		int x = initPosition.charAt(0) - 'a';
		int y = initPosition.charAt(1) - '1';
		ArrayList<String> cells = new ArrayList<String>();
		while (true) {
			visited[x][y] = true;
			cells.add((char) (x + 'a') + "" + (y + 1));
			int nextX = -1;
			int nextY = -1;
			boolean found = false;
			int offsetX[] = { 1, 0, 0, -1 };
			int offsetY[] = { 0, 1, -1, 0 };
			for (int i = 0; i < offsetX.length; i++) {
				nextX = x + offsetX[i];
				nextY = y + offsetY[i];
				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
						&& !visited[nextX][nextY]) {
					found = true;
					break;
				}
			}
			if (!found) {
				break;
			}
			x = nextX;
			y = nextY;
		}
		String path = "";
		for (String cell : cells) {
			path = appendCell(path, cell);
		}
		if (path.length() > 40) {
			path = path.substring(0, 20) + "..."
					+ path.substring(path.length() - 20);
		}
		return path;
	}

	String appendCell(String path, String cell) {
		return path + (path.equals("") ? "" : "-") + cell;
	}
}
