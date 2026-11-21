public class StepperMotor {
	int MODULO;

	public int rotateToNearest(int n, int current, int[] target) {
		MODULO = n;
		current = normalize(current);
		int result = calcDistance(current, normalize(target[0]));
		for (int i = 1; i < target.length; i++) {
			result = min(result, calcDistance(current, normalize(target[i])));
		}
		return result;
	}

	int normalize(int pos) {
		return (int) (((long) pos % MODULO + MODULO) % MODULO);
	}

	int calcDistance(int pos1, int pos2) {
		int clockwise = normalize(pos2 - pos1);
		int counterclockwise = -normalize(pos1 - pos2);
		return min(clockwise, counterclockwise);
	}

	int min(int dist1, int dist2) {
		int absDist1 = Math.abs(dist1);
		int absDist2 = Math.abs(dist2);
		if (absDist1 < absDist2) {
			return dist1;
		} else if (absDist1 > absDist2) {
			return dist2;
		}
		if (dist1 >= 0) {
			return dist1;
		} else {
			return dist2;
		}
	}
}
