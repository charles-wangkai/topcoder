import java.util.ArrayList;

public class Symmetry {
	public int countLines(String[] points) {
		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < points.length; i++) {
			str.append(" " + points[i]);
		}
		String[] s = str.toString().split(" ");
		int pointNum = (s.length - 1) / 2;
		Point[] p = new Point[pointNum];
		for (int i = 0; i < pointNum; i++) {
			int x = Integer.parseInt(s[i * 2 + 1]);
			int y = Integer.parseInt(s[i * 2 + 2]);
			p[i] = new Point(x, y);
		}

		ArrayList<Double> angles = new ArrayList<Double>();
		for (int i = 0; i < pointNum; i++) {
			for (int j = i + 1; j < pointNum; j++) {
				int deltaX = p[j].x - p[i].x;
				int deltaY = p[j].y - p[i].y;
				double angle = Math.atan2(deltaY, deltaX);
				if (angle < 0) {
					angle += Math.PI;
				} else if (angle == Math.PI) {
					angle = 0;
				}
				double midX = (p[j].x + p[i].x) / 2.0;
				double midY = (p[j].y + p[i].y) / 2.0;
				boolean existed = false;
				for (int k = 0; k < angles.size(); k++) {
					if (Math.abs(angles.get(k) - angle) < 1E-12) {
						existed = true;
						break;
					}
				}
				if (!existed) {
					ArrayList<Integer> unchecked = new ArrayList<Integer>();
					for (int k = 0; k < pointNum; k++) {
						if (k != i && k != j)
							unchecked.add(k);
					}
					boolean possible = true;
					for (int u = 0; u < unchecked.size(); u++) {
						int p1 = unchecked.get(u);
						boolean found = false;
						for (int v = u; v < unchecked.size(); v++) {
							int p2 = unchecked.get(v);
							if (p2 != p1) {
								int currentDeltaX = p[p2].x - p[p1].x;
								int currentDeltaY = p[p2].y - p[p1].y;
								double currentAngle = Math.atan2(currentDeltaY,
										currentDeltaX);
								if (currentAngle < 0) {
									currentAngle += Math.PI;
								} else if (currentAngle == Math.PI) {
									currentAngle = 0;
								}
								if (Math.abs(currentAngle - angle) > 1E-12) {
									continue;
								}
							}

							double currentMidX = (p[p2].x + p[p1].x) / 2.0;
							double currentMidY = (p[p2].y + p[p1].y) / 2.0;
							if (deltaY * (currentMidY - midY) == -deltaX
									* (currentMidX - midX)) {
								found = true;
								unchecked.remove(new Integer(p1));
								unchecked.remove(new Integer(p2));
								u--;
								break;
							}
						}
						if (!found) {
							possible = false;
							break;
						}
					}
					if (possible) {
						angles.add(angle);
					}
				}
			}
		}

		boolean inLine = true;
		for (int i = 2; i < pointNum; i++) {
			if ((p[1].y - p[0].y) * (p[i].x - p[0].x) != (p[1].x - p[0].x)
					* (p[i].y - p[0].y)) {
				inLine = false;
				break;
			}
		}
		if (inLine) {
			return angles.size() + 1;
		} else {
			return angles.size();
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
}
