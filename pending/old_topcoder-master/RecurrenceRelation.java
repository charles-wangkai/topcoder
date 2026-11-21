public class RecurrenceRelation {
	public int moduloTen(int[] coefficients, int[] initial, int N) {
		if (N < initial.length) {
			return mod10(initial[N]);
		}
		for (int i = 0; i < N + 1 - initial.length; i++) {
			int next = 0;
			for (int j = 0; j < initial.length; j++) {
				next += initial[j] * coefficients[j];
			}
			next = mod10(next);
			for (int j = 1; j < initial.length; j++) {
				initial[j - 1] = initial[j];
			}
			initial[initial.length - 1] = next;
		}
		return initial[initial.length - 1];
	}

	int mod10(int number) {
		return (number % 10 + 10) % 10;
	}
}
