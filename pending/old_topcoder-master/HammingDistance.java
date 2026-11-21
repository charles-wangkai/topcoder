public class HammingDistance {
	public int minDistance(String[] numbers) {
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				minDist = Math.min(minDist, calcDist(numbers[i], numbers[j]));
			}
		}
		return minDist;
	}

	int calcDist(String number1, String number2) {
		int dist = 0;
		for (int i = 0; i < number1.length(); i++) {
			if (number1.charAt(i) != number2.charAt(i)) {
				dist++;
			}
		}
		return dist;
	}
}
