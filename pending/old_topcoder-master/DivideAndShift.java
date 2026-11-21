public class DivideAndShift {
	public int getLeast(int N, int M) {
		int minMoveNum = Integer.MAX_VALUE;
		for (int afterDivide = 1; afterDivide <= N; afterDivide++) {
			if (N % afterDivide == 0) {
				int divideMoveNum = countDivide(N / afterDivide);
				int leftMove = (M - 1) % afterDivide;
				int shiftMoveNum = Math.min(leftMove, afterDivide - leftMove);
				minMoveNum = Math.min(minMoveNum, divideMoveNum + shiftMoveNum);
			}
		}
		return minMoveNum;
	}

	int countDivide(int number) {
		int divideMoveNum = 0;
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i)) {
				while (number % i == 0) {
					number /= i;
					divideMoveNum++;
				}
			}
		}
		if (number > 1) {
			divideMoveNum++;
		}
		return divideMoveNum;
	}

	boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
