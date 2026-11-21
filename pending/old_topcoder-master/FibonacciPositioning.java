public class FibonacciPositioning {
	public double getFPosition(int n) {
		if (n == 1) {
			return 2;
		}
		int fprevprev = 1;
		int fprev = 1;
		int pos = 2;
		while (true) {
			int f = fprevprev + fprev;
			if (n == f) {
				return pos + 1;
			} else if (n < f) {
				return pos + (double) (n - fprev) / (f - fprev);
			}
			fprevprev = fprev;
			fprev = f;
			pos++;
		}
	}
}
