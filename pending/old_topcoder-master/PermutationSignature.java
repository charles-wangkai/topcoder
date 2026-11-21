public class PermutationSignature {
	public int[] reconstruct(String signature) {
		int[] result = new int[signature.length() + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = i + 1;
		}
		int beginD = -1;
		for (int i = 0; i <= signature.length(); i++) {
			if (i == signature.length() || signature.charAt(i) != 'D') {
				if (beginD >= 0) {
					reverse(result, beginD, i);
					beginD = -1;
				}
			} else if (beginD < 0) {
				beginD = i;
			}
		}
		return result;
	}

	void reverse(int[] a, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}
