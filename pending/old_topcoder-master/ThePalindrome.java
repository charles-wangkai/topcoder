public class ThePalindrome {
	public int find(String s) {
		for (int i = 0;; i++) {
			if (isPalindrome(s.substring(i))) {
				return s.length() + i;
			}
		}
	}

	boolean isPalindrome(String str) {
		return str.equals(new StringBuffer(str).reverse().toString());
	}
}
