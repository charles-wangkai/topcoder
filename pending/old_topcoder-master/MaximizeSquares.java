public class MaximizeSquares {
	public int squareCount(int N) {
		int root = (int) Math.floor(Math.sqrt(N));
		int count = 0;
		for (int i = 1; i < root; i++) {
			count += i * i;
		}
		int remaining = N - root * root;
		remaining--;
		for (int i = 1; i < root && remaining > 0; i++) {
			count += i;
			remaining--;
		}
		remaining--;
		for (int i = 1; remaining > 0; i++) {
			count += i;
			remaining--;
		}
		return count;
	}
}
