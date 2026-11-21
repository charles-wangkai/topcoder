public class TheLuckyNumbers {
	int answer = 0;

	public int count(int a, int b) {
		search(0, a, b);
		return answer;
	}

	void search(long number, int a, int b) {
		if (number > b) {
			return;
		}
		if (number >= a) {
			answer++;
		}
		search(number * 10 + 4, a, b);
		search(number * 10 + 7, a, b);
	}
}
