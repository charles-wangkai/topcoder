import java.util.Arrays;

public class BifidSortMachine {
	public int countMoves(int[] a) {
		int sorted[] = a.clone();
		Arrays.sort(sorted);
		int indices[] = new int[a.length];
		for (int i = 0; i < indices.length; i++) {
			indices[i] = indexOf(a, sorted[i]);
		}
		int maxLength = -1;
		int length = 1;
		for (int i = 1; i <= indices.length; i++) {
			if (i < indices.length && indices[i] > indices[i - 1]) {
				length++;
			} else {
				maxLength = Math.max(maxLength, length);
				length = 1;
			}
		}
		return a.length - maxLength;
	}

	int indexOf(int a[], int value) {
		for (int i = 0;; i++) {
			if (a[i] == value) {
				return i;
			}
		}
	}
}
