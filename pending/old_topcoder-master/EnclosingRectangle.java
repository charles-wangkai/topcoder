import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EnclosingRectangle {
	public int smallestArea(String[] X, String[] Y) {
		String strX = "";
		for (int i = 0; i < X.length; i++) {
			strX += X[i];
		}
		String strY = "";
		for (int i = 0; i < Y.length; i++) {
			strY += Y[i];
		}
		ArrayList<Point> points = new ArrayList<Point>();
		Scanner inX = new Scanner(strX);
		Scanner inY = new Scanner(strY);
		while (inX.hasNextInt()) {
			int x = inX.nextInt();
			int y = inY.nextInt();
			points.add(new Point(x, y));
		}
		int area = Integer.MAX_VALUE;
		ComparatorX compX = new ComparatorX();
		ComparatorY compY = new ComparatorY();
		int size = points.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + size / 2 - 1; j < size; j++) {
				Collections.sort(points, compX);
				int width = points.get(j).x - points.get(i).x + 2;
				Collections.sort(points.subList(i, j + 1), compY);
				int height = Integer.MAX_VALUE;
				for (int k = i; k + size / 2 - 1 <= j; k++) {
					height = Math.min(height, points.get(k + size / 2 - 1).y
							- points.get(k).y + 2);
				}
				area = Math.min(area, width * height);
			}
		}
		return area;
	}

	class ComparatorX implements Comparator<Point> {
		public int compare(Point a, Point b) {
			return a.x - b.x;
		}
	}

	class ComparatorY implements Comparator<Point> {
		public int compare(Point a, Point b) {
			return a.y - b.y;
		}
	}
}

class Point {
	int x;
	int y;

	Point(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
}
