public class CarolsSinging {
	public int choose(String[] lyrics) {
		int carolNum = lyrics[0].length();
		int minUsedNum = Integer.MAX_VALUE;
		for (int code = 0; code < (1 << carolNum); code++) {
			boolean used[] = decode(code, carolNum);
			int usedNum = getUsedNum(used);
			if (usedNum >= minUsedNum) {
				continue;
			}
			boolean valid = true;
			for (String lyric : lyrics) {
				boolean singable = false;
				for (int i = 0; i < carolNum; i++) {
					if (lyric.charAt(i) == 'Y' && used[i]) {
						singable = true;
						break;
					}
				}
				if (!singable) {
					valid = false;
					break;
				}
			}
			if (valid) {
				minUsedNum = usedNum;
			}
		}
		return minUsedNum;
	}

	boolean[] decode(int code, int size) {
		boolean used[] = new boolean[size];
		for (int i = 0; i < used.length; i++) {
			used[i] = (code % 2 != 0);
			code /= 2;
		}
		return used;
	}

	int getUsedNum(boolean used[]) {
		int usedNum = 0;
		for (boolean oneUsed : used) {
			if (oneUsed) {
				usedNum++;
			}
		}
		return usedNum;
	}
}
