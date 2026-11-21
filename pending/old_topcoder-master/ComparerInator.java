public class ComparerInator {
	public int makeProgram(int[] A, int[] B, int[] wanted) {
		int[] lengths = { 1, 1, 7, 7 };
		Program[] programs = { (a, b) -> a, (a, b) -> b,
				(a, b) -> a < b ? a : b, (a, b) -> a < b ? b : a };
		for (int i = 0; i < programs.length; i++) {
			if (allMatched(A, B, wanted, programs[i])) {
				return lengths[i];
			}
		}
		return -1;
	}

	boolean allMatched(int[] A, int[] B, int[] wanted, Program program) {
		for (int i = 0; i < A.length; i++) {
			if (program.process(A[i], B[i]) != wanted[i]) {
				return false;
			}
		}
		return true;
	}
}

interface Program {
	int process(int a, int b);
}
