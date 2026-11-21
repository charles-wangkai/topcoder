public class ScoreRecomposition {
	int result = -1;

	public int minError(String questions, int score) {
		int points[] = new int[questions.length()];
		for (int i = 0; i < points.length; i++) {
			points[i] = i + 1;
		}
		search(questions, score, points, 0);
		return result;
	}

	void search(String questions, int score, int points[], int index) {
		if (index == points.length) {
			int sum = 0;
			for (int i = 0; i < points.length; i++) {
				if (questions.charAt(i) == 'C') {
					sum += points[i];
				}
			}
			if (sum == score) {
				int error = 0;
				for (int i = 0; i < points.length; i++) {
					error = Math.max(error, Math.abs(i + 1 - points[i]));
				}
				if (result < 0 || error < result) {
					result = error;
				}
			}
			return;
		}
		for (int i = index; i < points.length; i++) {
			swap(points, index, i);
			search(questions, score, points, index + 1);
			swap(points, index, i);
		}
	}

	void swap(int a[], int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
