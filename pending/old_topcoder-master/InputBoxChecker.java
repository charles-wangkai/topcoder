public class InputBoxChecker {
	public String[] checkPrefix(int smallest, int largest, int[] numbers) {
		String result[] = new String[numbers.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = isValid(smallest, largest, numbers[i]) ? "VALID"
					: "INVALID";
		}
		return result;
	}

	boolean isValid(int smallest, int largest, int number) {
		while (smallest != 0 || largest != 0) {
			if (number >= smallest && number <= largest) {
				return true;
			}
			smallest /= 10;
			largest /= 10;
		}
		return false;
	}
}
