import java.util.HashMap;
import java.util.Map;

public class AkariDaisukiDiv1 {
	final int MODULUS = 1000000007;
	final char SEPARATOR = '|';

	Map<String, Integer> cache = new HashMap<String, Integer>();

	public int countF(String Waai, String Akari, String Daisuki, String S, String F, int k) {
		int targetLength = F.length();

		boolean transform = true;

		String X = S;
		String fX = null;
		String nextX = null;
		int result = 0;
		for (int i = 0; i < k; i++) {
			result = multiplyMod(result, 2);

			if (transform) {
				fX = Waai + X + Akari + X + Daisuki;
			}

			if (fX.length() > targetLength) {
				result = addMod(result, countSubStr(fX, F));

				if (transform) {
					nextX = fX.substring(0, targetLength - 1) + SEPARATOR
							+ fX.substring(fX.length() - (targetLength - 1));
				}
			} else {
				nextX = fX;
			}

			if (nextX.equals(X)) {
				transform = false;
			}
			X = nextX;
		}
		result = addMod(result, countSubStr(X, F));

		return result;
	}

	int countSubStr(String str, String target) {
		if (cache.containsKey(str)) {
			return cache.get(str);
		}

		int result = 0;
		int fromIndex = 0;
		while (true) {
			int index = str.indexOf(target, fromIndex);

			if (index < 0) {
				break;
			}

			result++;
			fromIndex = index + 1;
		}

		cache.put(str, result);
		return result;
	}

	int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}

	int multiplyMod(int x, int y) {
		return x * y % MODULUS;
	}
}
