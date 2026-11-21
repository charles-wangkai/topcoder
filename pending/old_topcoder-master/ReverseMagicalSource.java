public class ReverseMagicalSource {
	public int find(int source, int A) {
		int x = 0;
		int base = 1;
		while (x <= A) {
			x += source * base;
			base *= 10;
		}
		return x;
	}
}
