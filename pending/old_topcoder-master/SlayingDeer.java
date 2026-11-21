public class SlayingDeer {
	public int getTime(int A, int B, int C) {
		int overIn45 = A * 45 - B * 30;
		if (overIn45 <= 0) {
			return -1;
		}
		int time = C / overIn45 * 45;
		int left = C - overIn45 * time / 45;
		if (left > 0) {
			int overIn30 = A * 30 - B * 30;
			if (left <= overIn30) {
				time += divideRoundUp(left, A - B);
			} else {
				time += 30 + divideRoundUp(left - overIn30, A);
			}
		}
		return time;
	}

	int divideRoundUp(int a, int b) {
		return (a + b - 1) / b;
	}
}
