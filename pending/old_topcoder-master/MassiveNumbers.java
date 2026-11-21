public class MassiveNumbers {
	public String getLargest(String numberA, String numberB) {
		double a = convert(numberA);
		double b = convert(numberB);
		return (a > b) ? numberA : numberB;
	}

	double convert(String numberStr) {
		String fields[] = numberStr.split("\\^");
		int base = Integer.parseInt(fields[0]);
		int exponent = Integer.parseInt(fields[1]);
		return exponent * Math.log(base);
	}
}
