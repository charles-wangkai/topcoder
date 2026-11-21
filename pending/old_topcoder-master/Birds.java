import java.util.Arrays;

public class Birds {
	int size;
	Move moves[];

	public int isMigratory(String[] birdMoves) {
		size = birdMoves.length;
		moves = new Move[size];
		for (int i = 0; i < size; i++) {
			String str[] = birdMoves[i].split(",");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int month = Integer.parseInt(str[2]);
			int day = Integer.parseInt(str[3]);
			moves[i] = new Move(x, y, getDayOfYear(month, day));
		}
		Arrays.sort(moves);
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (!isDayAccept(i, j)) {
					continue;
				}
				for (int p = j + 1; p < size; p++) {
					for (int q = p; q < size; q++) {
						if (isDayAccept(p, q) && isRegionAccept(i, j, p, q)) {
							return 1;
						}
					}
				}
			}
		}
		return 0;
	}

	boolean isDayAccept(int begin, int end) {
		int from = moves[begin].dayOfYear;
		int to;
		if (end == size - 1) {
			to = getDayOfYear(12, 31) + 1;
		} else {
			to = moves[end + 1].dayOfYear;
		}
		if (to - from >= 90) {
			return true;
		} else {
			return false;
		}
	}

	boolean isRegionAccept(int begin1, int end1, int begin2, int end2) {
		for (int i = begin1; i <= end1; i++) {
			for (int j = begin2; j <= end2; j++) {
				int offsetX = moves[i].x - moves[j].x;
				int offsetY = moves[i].y - moves[j].y;
				if (offsetX * offsetX + offsetY * offsetY < 1E6) {
					return false;
				}
			}
		}
		return true;
	}

	int getDayOfYear(int month, int day) {
		int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int result = 0;
		for (int i = 1; i < month; i++) {
			result += days[i];
		}
		result += day;
		return result;
	}
}

class Move implements Comparable<Move> {
	int x;
	int y;
	int dayOfYear;

	Move(int X, int Y, int theDayOfYear) {
		this.x = X;
		this.y = Y;
		this.dayOfYear = theDayOfYear;
	}

	public int compareTo(Move another) {
		return this.dayOfYear - another.dayOfYear;
	}
}
