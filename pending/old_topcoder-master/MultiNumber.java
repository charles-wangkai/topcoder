public class MultiNumber {
	public String check(int number) {
		String num = number + "";
		for (int i = 1; i < num.length(); i++) {
			if (digitProduct(num.substring(0, i)) == digitProduct(num
					.substring(i))) {
				return "YES";
			}
		}
		return "NO";
	}

	int digitProduct(String str) {
		int product = 1;
		for (int i = 0; i < str.length(); i++) {
			product *= str.charAt(i) - '0';
		}
		return product;
	}
}
