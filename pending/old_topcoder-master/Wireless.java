public class Wireless {
	int R;
	int minX;
	int maxX;
	int minY;
	int maxY;
	Point roaming[];
	String directions[];

	public int bestRoute(int range, String[] roamNodes, String[] statNodes) {
		R = range;
		minX = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;
		maxY = Integer.MIN_VALUE;
		Point stationary[] = new Point[statNodes.length];
		for (int i = 0; i < stationary.length; i++) {
			String str[] = statNodes[i].split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
			stationary[i] = new Point(x, y);
		}
		double distances[][] = new double[stationary.length][stationary.length];
		for (int i = 0; i < stationary.length; i++) {
			for (int j = 0; j < stationary.length; j++) {
				distances[i][j] = distance(stationary[i], stationary[j]);
			}
		}
		for (int k = 0; k < stationary.length; k++) {
			for (int i = 0; i < stationary.length; i++) {
				for (int j = 0; j < stationary.length; j++) {
					double disIK = distances[i][k];
					double disKJ = distances[k][j];
					if (disIK >= 0
							&& disKJ >= 0
							&& (distances[i][j] < 0 || disIK + disKJ < distances[i][j])) {
						distances[i][j] = disIK + disKJ;
					}
				}
			}
		}
		roaming = new Point[2];
		directions = new String[2];
		for (int i = 0; i < 2; i++) {
			String str[] = roamNodes[i].split(" ");
			directions[i] = str[0];
			roaming[i] = new Point(Integer.parseInt(str[1]), Integer
					.parseInt(str[2]));
		}
		double min = Double.MAX_VALUE;
		while (true) {
			for (int i = 0; i < stationary.length; i++) {
				double dis0 = distance(roaming[0], stationary[i]);
				if (dis0 < 0) {
					continue;
				}
				for (int j = 0; j < stationary.length; j++) {
					double dis1 = distance(roaming[1], stationary[j]);
					if (dis1 < 0) {
						continue;
					}
					if (distances[i][j] >= 0) {
						min = Math.min(min, dis0 + distances[i][j] + dis1);
					}
				}
			}
			if (!check()) {
				break;
			}
			for (int i = 0; i < 2; i++) {
				if (directions[i].equals("UP")) {
					roaming[i].y++;
				} else if (directions[i].equals("DOWN")) {
					roaming[i].y--;
				} else if (directions[i].equals("RIGHT")) {
					roaming[i].x++;
				} else if (directions[i].equals("LEFT")) {
					roaming[i].x--;
				}
			}
		}
		if (min == Double.MAX_VALUE) {
			return -1;
		} else {
			return (int) Math.round(min);
		}
	}

	boolean check() {
		for (int i = 0; i < 2; i++) {
			if ((directions[i].equals("UP") && roaming[i].y > maxY + R)
					|| (directions[i].equals("DOWN") && roaming[i].y < minY - R)
					|| (directions[i].equals("RIGHT") && roaming[i].x > maxX
							+ R)
					|| (directions[i].equals("LEFT") && roaming[i].x < minX - R)) {
				return false;
			}
		}
		return true;
	}

	double distance(Point a, Point b) {
		long temp = ((long) a.x - b.x) * (a.x - b.x) + ((long) a.y - b.y)
				* (a.y - b.y);
		if (temp > R * R) {
			return -1;
		} else {
			return Math.sqrt(temp);
		}
	}

	static class Point {
		int x;
		int y;

		Point(int X, int Y) {
			this.x = X;
			this.y = Y;
		}
	}
}
