public class MountainWalk {
	public int cellsVisited(String[] areaMap, int heightDifference) {
		int row = areaMap.length;
		int column = areaMap[0].length();
		boolean visited[][] = new boolean[row][column];
		visited[0][0] = true;
		int visitNum = 1;
		int x = 0;
		int y = 0;
		int offsetX[] = { 1, 0, -1, 0 };
		int offsetY[] = { 0, -1, 0, 1 };
		boolean move;
		do {
			move = false;
			for (int i = 0; i < offsetX.length; i++) {
				int nextX = x + offsetX[i];
				int nextY = y + offsetY[i];
				if (nextX >= 0
						&& nextX < row
						&& nextY >= 0
						&& nextY < column
						&& !visited[nextX][nextY]
						&& Math.abs(areaMap[x].charAt(y)
								- areaMap[nextX].charAt(nextY)) <= heightDifference) {
					visited[nextX][nextY] = true;
					visitNum++;
					x = nextX;
					y = nextY;
					move = true;
					break;
				}
			}
		} while (move);
		return visitNum;
	}
}
