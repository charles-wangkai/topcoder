public class TwoTurtledoves {
	public int presentType(int n) {
		int present = 1;
		int firstType = 1;
		while (n > present) {
			n -= present;
			firstType++;
			present += firstType;
		}
		for (int i = firstType;; i--) {
			if (n <= i) {
				return i;
			}
			n -= i;
		}
	}
}
