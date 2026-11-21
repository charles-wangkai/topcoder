public class Palindromize {
	public String minAdds(String s) {
		for (int i = 0;; i++) {
			String middle = s.substring(i);
			if (isPalindrome(middle)) {
				return s
						+ new StringBuffer(s.substring(0, i)).reverse()
								.toString();
			}
		}
	}

	boolean isPalindrome(String str) {
		return str.equals(new StringBuffer(str).reverse().toString());
	}
}
