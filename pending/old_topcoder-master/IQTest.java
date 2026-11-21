public class IQTest {
	public String nextNumber(int[] previous) {
		if (previous.length == 1
				|| (previous.length == 2 && previous[0] != previous[1])) {
			return "AMBIGUITY";
		}
		int differs[] = new int[previous.length - 1];
		for (int i = 0; i < differs.length; i++) {
			differs[i] = previous[i + 1] - previous[i];
		}
		int factor;
		if (differs.length == 1 || differs[0] == 0) {
			factor = 1;
		} else {
			factor = differs[1] / differs[0];
		}
		for (int i = 0; i < differs.length - 1; i++) {
			if (differs[i] * factor != differs[i + 1]) {
				return "BUG";
			}
		}
		return (previous[previous.length - 1] + differs[differs.length - 1]
				* factor)
				+ "";
	}
}
