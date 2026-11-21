public class ChickenOracle {
	public String theTruth(int n, int eggCount, int lieCount, int liarCount) {
		int chickenCount = n - eggCount;
		boolean eggPossible = isPossible(eggCount, chickenCount, lieCount,
				liarCount);
		boolean chickenPossible = isPossible(chickenCount, eggCount, lieCount,
				liarCount);
		if (eggPossible && chickenPossible) {
			return "Ambiguous";
		} else if (eggPossible) {
			return "The egg";
		} else if (chickenPossible) {
			return "The chicken";
		} else {
			return "The oracle is a lie";
		}
	}

	boolean isPossible(int positiveCount, int negativeCount, int lieCount,
			int liarCount) {
		int diff = Math.abs(negativeCount - liarCount);
		if (lieCount < diff || (lieCount - diff) % 2 != 0) {
			return false;
		}
		int half = (lieCount - diff) / 2;
		if (negativeCount < liarCount) {
			if (half > positiveCount - diff || half > negativeCount) {
				return false;
			}
		} else {
			if (half > positiveCount || half > negativeCount - diff) {
				return false;
			}
		}
		return true;
	}
}
