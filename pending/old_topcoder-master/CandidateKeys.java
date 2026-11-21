import java.util.HashSet;

public class CandidateKeys {
	public int[] getKeys(String[] table) {
		int columnNum = table[0].length();
		int minKeyNum = Integer.MAX_VALUE;
		int maxKeyNum = -1;
		for (int code = 0; code < (1 << columnNum); code++) {
			boolean used[] = decode(code, columnNum);
			if (isCandidateSuperKey(table, used)) {
				int keyNum = 0;
				for (boolean oneUsed : used) {
					if (oneUsed) {
						keyNum++;
					}
				}
				minKeyNum = Math.min(minKeyNum, keyNum);
				maxKeyNum = Math.max(maxKeyNum, keyNum);
			}
		}
		if (maxKeyNum < 0) {
			return new int[0];
		} else {
			return new int[] { minKeyNum, maxKeyNum };
		}
	}

	boolean[] decode(int code, int size) {
		boolean used[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			used[i] = code % 2 != 0;
			code /= 2;
		}
		return used;
	}

	boolean isCandidateSuperKey(String table[], boolean used[]) {
		if (!isSuperKey(table, used)) {
			return false;
		}
		for (int i = 0; i < used.length; i++) {
			if (used[i]) {
				used[i] = false;
				boolean superKey = isSuperKey(table, used);
				used[i] = true;
				if (superKey) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isSuperKey(String table[], boolean used[]) {
		HashSet<String> history = new HashSet<String>();
		for (String entry : table) {
			String key = "";
			for (int i = 0; i < used.length; i++) {
				if (used[i]) {
					key += entry.charAt(i);
				}
			}
			if (history.contains(key)) {
				return false;
			}
			history.add(key);
		}
		return true;
	}
}
