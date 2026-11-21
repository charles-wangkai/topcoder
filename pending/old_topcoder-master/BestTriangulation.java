public class BestTriangulation {
	public double maxArea(String[] vertices) {
		Point points[] = new Point[vertices.length];
		for (int i = 0; i < points.length; i++) {
			String fields[] = vertices[i].split(" ");
			points[i] = new Point(Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]));
		}
		double result = -1;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					double area = Math.abs(points[i].x * points[j].y
							- points[i].y * points[j].x + points[j].x
							* points[k].y - points[j].y * points[k].x
							+ points[k].x * points[i].y - points[k].y
							* points[i].x) / 2.0;
					result = Math.max(result, area);
				}
			}
		}
		return result;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}