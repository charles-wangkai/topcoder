import java.util.HashSet;

public class EasySequence {
	public int find(int[] A, int[] B) {
		for (int i = A.length; i < B.length; i++) {
			if (B[i] != produce(B, i - A.length, i - 1)) {
				return -1;
			}
		}
		HashSet<Integer> history = new HashSet<Integer>();
		for (int i = 0;; i++) {
			int code = encode(A);
			if (history.contains(code)) {
				return -1;
			}
			if (prefixEqual(A, B)) {
				return i;
			}
			history.add(code);
			int nextValue = produce(A, 0, A.length - 1);
			for (int j = 0; j < A.length - 1; j++) {
				A[j] = A[j + 1];
			}
			A[A.length - 1] = nextValue;
		}
	}

	boolean prefixEqual(int a[], int b[]) {
		for (int i = 0; i < a.length && i < b.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	int encode(int a[]) {
		int code = 0;
		for (int item : a) {
			code = code * 10 + item;
		}
		return code;
	}

	int produce(int a[], int begin, int end) {
		int sum = 0;
		for (int i = begin; i <= end; i++) {
			sum = (sum + a[i]) % 10;
		}
		return sum;
	}
}
