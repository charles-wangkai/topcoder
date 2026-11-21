public class IncubatorEasy {
	public int maxMagicalGirls(String[] love) {
		int result = -1;
		for (int code = (1 << love.length) - 1; code >= 0; code--) {
			boolean magicals[] = decode(code, love.length);
			boolean protects[] = new boolean[love.length];
			int magicalNoProtectNum = 0;
			for (int i = 0; i < magicals.length; i++) {
				if (magicals[i]) {
					spread(love, protects, i);
				}
			}
			for (int i = 0; i < magicals.length; i++) {
				if (magicals[i] && !protects[i]) {
					magicalNoProtectNum++;
				}
			}
			result = Math.max(result, magicalNoProtectNum);
		}
		return result;
	}

	boolean[] decode(int code, int size) {
		boolean magicals[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			magicals[i] = (code % 2 != 0);
			code /= 2;
		}
		return magicals;
	}

	void spread(String love[], boolean protects[], int index) {
		for (int i = 0; i < love.length; i++) {
			if (love[index].charAt(i) == 'Y' && !protects[i]) {
				protects[i] = true;
				spread(love, protects, i);
			}
		}
	}
}
