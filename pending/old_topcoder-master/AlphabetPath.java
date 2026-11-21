public class AlphabetPath {
	public String doesItExist(String[] letterMaze) {
		int x = -1;
		int y = -1;
		boolean foundA = false;
		for (int i = 0; i < letterMaze.length; i++) {
			for (int j = 0; j < letterMaze[0].length(); j++) {
				if (letterMaze[i].charAt(j) == 'A') {
					x = i;
					y = j;
					foundA = true;
					break;
				}
			}
			if (foundA) {
				break;
			}
		}
		int offsetX[] = { -1, 0, 1, 0 };
		int offsetY[] = { 0, 1, 0, -1 };
		for (int i = 1; i <= 25; i++) {
			boolean found = false;
			for (int j = 0; j < offsetX.length; j++) {
				int nextX = x + offsetX[j];
				int nextY = y + offsetY[j];
				if (nextX >= 0 && nextX < letterMaze.length && nextY >= 0
						&& nextY < letterMaze[0].length()
						&& letterMaze[nextX].charAt(nextY) == 'A' + i) {
					x = nextX;
					y = nextY;
					found = true;
					break;
				}
			}
			if (!found) {
				return "NO";
			}
		}
		return "YES";
	}
}
