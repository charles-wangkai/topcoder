public class PowerSupply {
	public int maxProfit(int[] x, int[] y, int D) {
		int consumerNum = x.length;
		multiply4(x);
		multiply4(y);
		D *= 4;
		int result = 0;
		for (int i = 0; i < consumerNum; i++) {
			result = Math.max(result, getMaxCover(x, y, D, x[i], y[i]));
		}
		for (int i = 0; i < consumerNum; i++) {
			for (int j = i + 1; j < consumerNum; j++) {
				result = Math.max(
						result,
						getMaxCover(x, y, D, (x[i] + x[j]) / 2,
								(y[i] + y[j]) / 2));
			}
		}
		return result;
	}

	int getMaxCover(int x[], int y[], int D, int px, int py) {
		Line lines[] = { new Horizontal(py), new Vertical(px),
				new DiagonalUp(py - px), new DiagonalDown(px + py) };
		int maxCover = -1;
		for (Line line : lines) {
			int cover = 0;
			for (int i = 0; i < x.length; i++) {
				if (line.getDistSquare(x[i], y[i]) <= (long) D * D) {
					cover++;
				}
			}
			maxCover = Math.max(maxCover, cover);
		}
		return maxCover;
	}

	void multiply4(int a[]) {
		for (int i = 0; i < a.length; i++) {
			a[i] *= 4;
		}
	}
}

abstract class Line {
	int m;

	public Line(int m) {
		this.m = m;
	}

	abstract long getDistSquare(int x, int y);
}

class Horizontal extends Line { // y = m
	public Horizontal(int m) {
		super(m);
	}

	@Override
	public long getDistSquare(int x, int y) {
		return (long) (y - m) * (y - m);
	}
}

class Vertical extends Line { // x = m
	public Vertical(int m) {
		super(m);
	}

	@Override
	public long getDistSquare(int x, int y) {
		return (long) (x - m) * (x - m);
	}
}

class DiagonalUp extends Line { // y = x + m
	public DiagonalUp(int m) {
		super(m);
	}

	@Override
	public long getDistSquare(int x, int y) {
		return (long) (y - x - m) * (y - x - m) / 2;
	}
}

class DiagonalDown extends Line { // x + y = m
	public DiagonalDown(int m) {
		super(m);
	}

	@Override
	public long getDistSquare(int x, int y) {
		return (long) (x + y - m) * (x + y - m) / 2;
	}
}