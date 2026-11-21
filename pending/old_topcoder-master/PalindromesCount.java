public class PalindromesCount {
	public int count(String A, String B) {
		int variantNum = 0;
		for (int i = 0; i <= A.length(); i++) {
			String str = A.substring(0, i) + B + A.substring(i);
			if (isPalindrome(str)) {
				variantNum++;
			}
		}
		return variantNum;
	}

	boolean isPalindrome(String str) {
		return new StringBuffer(str).reverse().toString().equals(str);
	}
}
