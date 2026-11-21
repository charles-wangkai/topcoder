public class CarrotJumping {
	final int MODULO = 1000000007;

	public int theJump(int init) {
		final int JUMP_LIMIT = 100000;
		int minJump = min(
				min(alwaysJump2(init, JUMP_LIMIT),
						1 + alwaysJump2(jump1(init), JUMP_LIMIT - 1)),
				2 + alwaysJump2(jump1(jump1(init)), JUMP_LIMIT - 2));
		return (minJump < 0) ? -1 : minJump;
	}

	int min(int a, int b) {
		if (a < 0 || (b >= 0 && b < a)) {
			return b;
		} else {
			return a;
		}
	}

	int alwaysJump2(int x, int limit) {
		for (int i = 0; i <= limit; i++) {
			if (x == 0) {
				return i;
			}
			x = jump2(x);
		}
		return Integer.MIN_VALUE;
	}

	int jump1(int x) {
		return (int) ((4L * x + 3) % MODULO);
	}

	int jump2(int x) {
		return (int) ((8L * x + 7) % MODULO);
	}
}
