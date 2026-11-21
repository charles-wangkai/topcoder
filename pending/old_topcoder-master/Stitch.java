public class Stitch {
	public String[] stitch(String[] A, String[] B, int overlap) {
		int lengthA = A[0].length();
		int lengthB = B[0].length();
		String result[] = new String[A.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
			for (int j = 0; j < lengthA - overlap; j++) {
				result[i] += A[i].charAt(j);
			}
			for (int j = 1; j <= overlap; j++) {
				result[i] += (char) Math.round(((overlap + 1 - j)
						* A[i].charAt(lengthA - overlap + j - 1) + (j * B[i]
						.charAt(j - 1))) / (overlap + 1.0));
			}
			for (int j = overlap; j < lengthB; j++) {
				result[i] += B[i].charAt(j);
			}
		}
		return result;
	}
}
