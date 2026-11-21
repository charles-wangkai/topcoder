public class VendingMachine {
	int row;
	int column;
	int values[][];
	int columnValues[];

	public int motorUse(String[] prices, String[] purchases) {
		row = prices.length;
		column = prices[0].split(" ").length;
		values = new int[row][column];
		columnValues = new int[column];
		for (int i = 0; i < row; i++) {
			String temp[] = prices[i].split(" ");
			for (int j = 0; j < column; j++) {
				values[i][j] = Integer.parseInt(temp[j]);
				columnValues[j] += values[i][j];
			}
		}
		int motor = 0;
		int previous = -1;
		int pos = mostExpensive();
		motor += rotate(0, pos);
		for (int i = 0; i < purchases.length; i++) {
			String temp[] = purchases[i].split(",|:");
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			int time = Integer.parseInt(temp[2]);
			if (previous != -1 && time - previous >= 5) {
				int p = mostExpensive();
				motor += rotate(pos, p);
				motor += rotate(p, c);
			} else {
				motor += rotate(pos, c);
			}
			if (values[r][c] == 0) {
				return -1;
			}
			columnValues[c] -= values[r][c];
			values[r][c] = 0;
			pos = c;
			previous = time;
		}
		motor += rotate(pos, mostExpensive());
		return motor;
	}

	int mostExpensive() {
		int max = 0;
		for (int i = 1; i < column; i++) {
			if (columnValues[i] > columnValues[max]) {
				max = i;
			}
		}
		return max;
	}

	int rotate(int from, int to) {
		int diff = (from - to + column) % column;
		return Math.min(diff, column - diff);
	}
}