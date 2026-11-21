public class Stick {
	public int pieces(int x) {
		int stickNum = 0;
		for (int base = 64; base >= 1; base >>= 1) {
			stickNum += x / base;
			x %= base;
		}
		return stickNum;
	}
}
