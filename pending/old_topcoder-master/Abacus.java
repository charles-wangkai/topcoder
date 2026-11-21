public class Abacus {
	public String[] add(String[] original, int val) {
		int number = 0;
		for (String thread : original) {
			number = number * 10 + thread2digit(thread);
		}
		number += val;
		String result[] = new String[6];
		for (int i = result.length - 1; i >= 0; i--) {
			int digit = number % 10;
			result[i] = digit2thread(digit);
			number /= 10;
		}
		return result;
	}

	int thread2digit(String thread) {
		return 9 - thread.indexOf('-');
	}

	String digit2thread(int digit) {
		String thread = "";
		for (int i = 0; i < 9 - digit; i++) {
			thread += "o";
		}
		thread += "---";
		for (int i = 0; i < digit; i++) {
			thread += "o";
		}
		return thread;
	}
}
