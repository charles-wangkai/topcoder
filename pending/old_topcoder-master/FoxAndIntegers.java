public class FoxAndIntegers {
	public int[] get(int AminusB, int BminusC, int AplusB, int BplusC) {
		int A_B[] = solve(AminusB, AplusB);
		int B_C[] = solve(BminusC, BplusC);
		if (A_B.length == 0 || B_C.length == 0 || A_B[1] != B_C[0]) {
			return new int[0];
		} else {
			return new int[] { A_B[0], A_B[1], B_C[1] };
		}
	}

	int[] solve(int MminusN, int MplusN) {
		int M2 = MminusN + MplusN;
		if (M2 % 2 != 0) {
			return new int[0];
		} else {
			int M = M2 / 2;
			int N = MplusN - M;
			return new int[] { M, N };
		}
	}
}
