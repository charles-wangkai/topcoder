public class CuttingBitString {
	public int getmin(String S) {
		int[] pieces = new int[S.length()];
		for (int i = 0; i < pieces.length; i++) {
			pieces[i] = -1;
			if (isPowerOf5(S.substring(0, i + 1))) {
				pieces[i] = 1;
			} else {
				for (int j = 0; j < i; j++) {
					if (isPowerOf5(S.substring(j + 1, i + 1))) {
						if (pieces[j] != -1
								&& (pieces[i] == -1 || pieces[j] + 1 <= pieces[i])) {
							pieces[i] = pieces[j] + 1;
						}
					}
				}
			}
		}
		return pieces[pieces.length - 1];
	}

	boolean isPowerOf5(String str) {
		if (str.startsWith("0")) {
			return false;
		}
		long number = Long.parseLong(str, 2);
		while (number % 5 == 0) {
			number /= 5;
		}
		return number == 1;
	}
}
