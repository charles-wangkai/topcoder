import java.util.ArrayList;
import java.util.Arrays;

public class DucksAlignment {
	public int minimumTime(String[] grid) {
		int row = grid.length;
		int col = grid[0].length();
		ArrayList<Point> ducks = new ArrayList<Point>();
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				if (grid[x].charAt(y) == 'o') {
					ducks.add(new Point(x, y));
				}
			}
		}
		int[] xList = new int[ducks.size()];
		int[] yList = new int[ducks.size()];
		for (int i = 0; i < yList.length; i++) {
			Point duck = ducks.get(i);
			xList[i] = duck.x;
			yList[i] = duck.y;
		}
		int timeToCompressOneRow = compressOneLine(yList);
		int timeToCompressOneCol = compressOneLine(xList);
		int minTime = Integer.MAX_VALUE;
		for (int x = 0; x < row; x++) {
			int time = 0;
			for (Point duck : ducks) {
				time += Math.abs(duck.x - x);
			}
			minTime = Math.min(minTime, time + timeToCompressOneRow);
		}
		for (int y = 0; y < col; y++) {
			int time = 0;
			for (Point duck : ducks) {
				time += Math.abs(duck.y - y);
			}
			minTime = Math.min(minTime, time + timeToCompressOneCol);
		}
		return minTime;
	}

	int compressOneLine(int[] a) {
		Arrays.sort(a);
		int minTime = Integer.MAX_VALUE;
		for (int begin = a[0]; begin <= a[a.length - 1] - (a.length - 1); begin++) {
			int time = 0;
			for (int i = begin; i < begin + a.length; i++) {
				time += Math.abs(a[i - begin] - i);
			}
			minTime = Math.min(minTime, time);
		}
		return minTime;
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