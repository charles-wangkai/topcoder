public class AgeEncoding {
	public double getRadix(int age, String candlesLine) {
		final double ERROR = 1E-9;
		if (allZero(candlesLine)) {
			return -1;
		}
		int length = candlesLine.length();
		boolean lastIsOne = candlesLine.charAt(length - 1) == '1';
		if (lastIsOne && allZero(candlesLine.substring(0, length - 1))) {
			if (age == 1) {
				return -2;
			} else {
				return -1;
			}
		}
		if (age == 1 && lastIsOne) {
			return -1;
		}
		double lower = 0;
		double upper = Math.pow(age,
				1.0 / (length - candlesLine.indexOf('1') - 1));
		while (upper - lower > ERROR) {
			double middle = (lower + upper) / 2;
			double value = 0;
			for (int i = 0; i < length; i++) {
				value += Integer.parseInt(candlesLine.charAt(i) + "")
						* Math.pow(middle, length - i - 1);
			}
			if (value < age) {
				lower = middle;
			} else {
				upper = middle;
			}
		}
		return (lower + upper) / 2;
	}

	boolean allZero(String str) {
		return str.replaceAll("0", "").equals("");
	}
}
