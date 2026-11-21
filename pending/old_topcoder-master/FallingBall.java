import java.math.BigInteger;
import java.util.Arrays;

public class FallingBall {
	public int howMany(String[] cells, int n) {
		Cell cellArr[] = new Cell[cells.length];
		for (int i = 0; i < cellArr.length; i++) {
			String fields[] = cells[i].split(" ");
			cellArr[i] = new Cell(Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]));
		}
		Arrays.sort(cellArr);
		int x = 0;
		int y = 0;
		int way = 1;
		for (Cell cell : cellArr) {
			way *= C(cell.x - x, cell.y - y);
			x = cell.x;
			y = cell.y;
		}
		for (int i = x + 1; i < n; i++) {
			way *= 2;
		}
		return way;
	}

	int C(int n, int m) {
		if (m < 0 || m > n) {
			return 0;
		}
		BigInteger result = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			result = result.multiply(new BigInteger(i + ""));
		}
		for (int i = 1; i <= m; i++) {
			result = result.divide(new BigInteger(i + ""));
		}
		return result.intValue();
	}
}

class Cell implements Comparable<Cell> {
	int x;
	int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Cell other) {
		if (x != other.x) {
			return x - other.x;
		} else {
			return y - other.y;
		}
	}
}