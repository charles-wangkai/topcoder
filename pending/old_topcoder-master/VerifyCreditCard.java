public class VerifyCreditCard {
	public String checkDigits(String cardNumber) {
		String doubled = "";
		boolean needDouble = (cardNumber.length() % 2 == 0);
		for (int i = 0; i < cardNumber.length(); i++) {
			int digit = cardNumber.charAt(i) - '0';
			if (needDouble) {
				doubled += digit * 2;
			} else {
				doubled += digit;
			}
			needDouble = !needDouble;
		}
		int digitSum = 0;
		for (int i = 0; i < doubled.length(); i++) {
			digitSum += doubled.charAt(i) - '0';
		}
		return (digitSum % 10 == 0) ? "VALID" : "INVALID";
	}
}
