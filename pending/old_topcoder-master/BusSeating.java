public class BusSeating {
	double minDistanceSum = Double.MAX_VALUE;

	public double getArrangement(String leftRow, String rightRow) {
		search(new StringBuffer[] { new StringBuffer(leftRow),
				new StringBuffer(rightRow) }, new Point[3], 0);
		return minDistanceSum;
	}

	void search(StringBuffer rows[], Point points[], int index) {
		if (index == points.length) {
			double distanceSum = 0;
			for (int i = 0; i < points.length; i++) {
				for (int j = i + 1; j < points.length; j++) {
					distanceSum += Point.getDistance(points[i], points[j]);
				}
			}
			minDistanceSum = Math.min(minDistanceSum, distanceSum);
			return;
		}
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length(); j++) {
				if (rows[i].charAt(j) == '-') {
					points[index] = new Point(i * 2, j);
					rows[i].setCharAt(j, 'X');
					search(rows, points, index + 1);
					rows[i].setCharAt(j, '-');
				}
			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static double getDistance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
				* (p1.y - p2.y));
	}
}