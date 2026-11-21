public class BoxUnion {
	public int area(String[] rectangles) {
		int result = 0;
		int rectangleNum = rectangles.length;
		Rectangle rects[] = new Rectangle[rectangleNum];
		for (int i = 0; i < rectangleNum; i++) {
			String fields[] = rectangles[i].split(" ");
			rects[i] = new Rectangle(Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
					Integer.parseInt(fields[3]));
		}
		for (int code = 1; code < (1 << rectangleNum); code++) {
			boolean used[] = decode(code, rectangleNum);
			int sign = -1;
			Rectangle intersected = new Rectangle(Integer.MIN_VALUE,
					Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
			for (int i = 0; i < rectangleNum; i++) {
				if (used[i]) {
					intersected = Rectangle.intersect(intersected, rects[i]);
					if (intersected == null) {
						break;
					}
					sign = -sign;
				}
			}
			if (intersected != null) {
				result += sign * intersected.getArea();
			}
		}
		return result;
	}

	boolean[] decode(int code, int size) {
		boolean used[] = new boolean[size];
		for (int i = 0; i < used.length; i++) {
			used[i] = (code % 2 == 1);
			code /= 2;
		}
		return used;
	}
}

class Rectangle {
	int minX;
	int minY;
	int maxX;
	int maxY;

	public Rectangle(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	int getArea() {
		return (maxX - minX) * (maxY - minY);
	}

	static Rectangle intersect(Rectangle r1, Rectangle r2) {
		int interMinX = Math.max(r1.minX, r2.minX);
		int interMinY = Math.max(r1.minY, r2.minY);
		int interMaxX = Math.min(r1.maxX, r2.maxX);
		int interMaxY = Math.min(r1.maxY, r2.maxY);
		if (interMinX >= interMaxX || interMinY >= interMaxY) {
			return null;
		} else {
			return new Rectangle(interMinX, interMinY, interMaxX, interMaxY);
		}
	}
}