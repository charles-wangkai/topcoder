public class MagicCandy {
	public int whichOne(int n) {
		int root = (int) Math.floor(Math.sqrt(n));
		int prevSquare = root * root;
		if (prevSquare == n) {
			root--;
			prevSquare = root * root;
		}
		if (n - prevSquare <= root) {
			return prevSquare + 1;
		} else {
			return prevSquare + root + 1;
		}
	}
}
