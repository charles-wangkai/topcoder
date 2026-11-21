public class SpiralWalking {
	public int totalPoints(String[] levelMap) {
		int row = levelMap.length;
		int column = levelMap[0].length();
		boolean visited[][] = new boolean[row][column];
		int x = 0;
		int y = 0;
		int offsetX[] = { 0, 1, 0, -1 };
		int offsetY[] = { 1, 0, -1, 0 };
		int direction = 0;
		int rest = row * column;
		int point = 0;
		while (true) {
			rest--;
			visited[x][y] = true;
			point += levelMap[x].charAt(y) - '0';
			if (rest == 0) {
				break;
			}
			while (true) {
				int nextX = x + offsetX[direction];
				int nextY = y + offsetY[direction];
				if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column
						&& !visited[nextX][nextY]) {
					x = nextX;
					y = nextY;
					break;
				}
				direction = (direction + 1) % 4;
				point -= levelMap[x].charAt(y) - '0';
			}
		}
		return point;
	}
}
