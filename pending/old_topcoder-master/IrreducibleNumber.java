import java.util.HashSet;

public class IrreducibleNumber {
	public int getIrreducible(int[] A) {
		HashSet<Integer> sums = new HashSet<Integer>();
		for (int i = 1; i < (2 << A.length); i++) {
			int sum = 0;
			for (int j = 0; j < A.length; j++) {
				if ((i & (2 << j)) != 0) {
					sum += A[j];
				}
			}
			sums.add(sum);
		}
		for (int i = 1;; i++) {
			if (!sums.contains(i)) {
				return i;
			}
		}
	}
}
