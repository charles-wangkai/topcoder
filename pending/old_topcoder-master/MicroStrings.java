public class MicroStrings {
	public String makeMicroString(int A, int D) {
		StringBuilder sb = new StringBuilder();
		for (int i = A; i >= 0; i -= D) {
			sb.append(i);
		}
		return sb.toString();
	}
}
