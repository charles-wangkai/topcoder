public class LongCalc {
	public String process(String a, String b, int op) {
		if (op == 1) {
			return add(a, b);
		} else if (op == 2) {
			return subtract(a, b);
		} else if (op == 3) {
			return multiply(a, b);
		} else {
			return divide(a, b);
		}
	}

	private String trim(String a) {
		int pos = 0;
		while (pos < a.length() && a.charAt(pos) == '0') {
			pos++;
		}
		if (pos == a.length()) {
			return "0";
		} else {
			return a.substring(pos);
		}
	}

	private String add(String a, String b) {
		String c = "";
		int carry = 0;
		for (int i = 0; i < a.length() || i < b.length(); i++) {
			int digitA = 0;
			int digitB = 0;
			if (i < a.length()) {
				digitA = a.charAt(a.length() - i - 1) - '0';
			}
			if (i < b.length()) {
				digitB = b.charAt(b.length() - i - 1) - '0';
			}
			int temp = digitA + digitB + carry;
			c = temp % 10 + c;
			carry = temp / 10;
		}
		if (carry == 1) {
			c = "1" + c;
		}
		return c;
	}

	private String subtract(String a, String b) {
		if (less(a, b) == true) {
			return "-" + subtract(b, a);
		}
		String c = "";
		int borrow = 0;
		for (int i = 0; i < a.length(); i++) {
			int digitA = a.charAt(a.length() - i - 1) - '0';
			int digitB = 0;
			if (i < b.length()) {
				digitB = b.charAt(b.length() - i - 1) - '0';
			}
			int temp = digitA - borrow - digitB;
			if (temp < 0) {
				borrow = 1;
				temp += 10;
			} else {
				borrow = 0;
			}
			c = temp + c;
		}
		return trim(c);
	}

	private boolean less(String a, String b) {
		if (a.length() < b.length()) {
			return true;
		}
		if (a.length() == b.length()) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) < b.charAt(i)) {
					return true;
				}
				if (a.charAt(i) > b.charAt(i)) {
					return false;
				}
			}
		}
		return false;
	}

	private String multiply(String a, String b) {
		String c = "0";
		for (int i = 0; i < b.length(); i++) {
			String temp = multiply(a, b.charAt(i) - '0');
			temp = shift(temp, b.length() - i - 1);
			c = add(c, temp);
		}
		return c;
	}

	private String multiply(String a, int digit) {
		String c = "";
		int carry = 0;
		for (int i = 0; i < a.length(); i++) {
			int temp = (a.charAt(a.length() - i - 1) - '0') * digit + carry;
			c = temp % 10 + c;
			carry = temp / 10;
		}
		if (carry > 0) {
			c = carry + c;
		}
		return c;
	}

	private String shift(String a, int offset) {
		String c = a;
		for (int i = 0; i < offset; i++) {
			c = c + "0";
		}
		return c;
	}

	private String divide(String a, String b) {
		String c = "";
		String remainder = "";
		for (int i = 0; i < a.length(); i++) {
			remainder = trim(remainder + a.charAt(i));
			int digit = 0;
			while (less(b, remainder) == true || b.equals(remainder) == true) {
				remainder = subtract(remainder, b);
				digit++;
			}
			c += digit;
		}
		return trim(c);
	}
}
