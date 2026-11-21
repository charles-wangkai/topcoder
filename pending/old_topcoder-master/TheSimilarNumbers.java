public class TheSimilarNumbers {
	public int find(int lower, int upper) {
		int count = 0;
		int number = lower;
		while (number <= upper) {
			count++;
			number = number * 10 + 1;
		}
		return count;
	}
}
