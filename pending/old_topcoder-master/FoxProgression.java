public class FoxProgression {
	public int theCount(int[] seq) {
		if (seq.length == 1) {
			return -1;
		} else if (seq[0] == seq[1]) {
			return (isArithmetic(seq) || isGeometric(seq)) ? 1 : 0;
		} else {
			return (isArithmetic(seq) ? 1 : 0) + (isGeometric(seq) ? 1 : 0);
		}
	}

	boolean isArithmetic(int seq[]) {
		for (int i = 2; i < seq.length; i++) {
			if (seq[i] - seq[i - 1] != seq[1] - seq[0]) {
				return false;
			}
		}
		return true;
	}

	boolean isGeometric(int seq[]) {
		if (seq[0] == 0 || seq[1] % seq[0] != 0) {
			return false;
		}
		for (int i = 2; i < seq.length; i++) {
			if (seq[i] % seq[i - 1] != 0
					|| seq[i] / seq[i - 1] != seq[1] / seq[0]) {
				return false;
			}
		}
		return true;
	}
}
