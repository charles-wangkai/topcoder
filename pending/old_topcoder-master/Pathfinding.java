public class Pathfinding {
	public int getDirections(int x, int y) {
		int distance = Math.abs(x) + Math.abs(y);
		if (x >= 0 && y >= 0) {
			if (!isEven(x) && !isEven(y)) {
				distance += 2;
			}
		} else if (x <= 0 && y <= 0) {
			if (isEven(x) && isEven(y)) {
				distance += 4;
			} else {
				distance += 2;
			}
		} else if (x < 0 && y > 0) {
			if (!isEven(x) && isEven(y)) {
				distance += 2;
			}
		} else if (x > 0 && y < 0) {
			if (isEven(x) && !isEven(y)) {
				distance += 2;
			}
		}
		return distance;
	}

	boolean isEven(int number) {
		return number % 2 == 0;
	}
}
