public class EasyHomework {
	public String determineSign(int[] A) {
		boolean hasZero = false;
		int negativeCount = 0;
		for (int number : A) {
			if (number < 0) {
				negativeCount++;
			} else if (number == 0) {
				hasZero = true;
			}
		}
		if (hasZero) {
			return "ZERO";
		} else if (negativeCount % 2 != 0) {
			return "NEGATIVE";
		} else {
			return "POSITIVE";
		}
	}
}
