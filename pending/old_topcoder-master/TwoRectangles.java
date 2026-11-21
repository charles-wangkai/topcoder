public class TwoRectangles {
	public String describeIntersection(int[] A, int[] B) {
		if (A[2] < B[0] || B[2] < A[0] || A[3] < B[1] || B[3] < A[1]) {
			return "none";
		}
		if ((A[0] == B[2] && A[3] == B[1]) || (A[2] == B[0] && A[3] == B[1])
				|| (A[2] == B[0] && A[1] == B[3])
				|| (A[0] == B[2] && A[1] == B[3])) {
			return "point";
		}
		if (A[0] == B[2] || A[2] == B[0] || A[1] == B[3] || A[3] == B[1]) {
			return "segment";
		}
		return "rectangle";
	}
}
