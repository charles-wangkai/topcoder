public class P8XMatrixTransformation {
	public String solve(String[] original, String[] target) {
		return (countNumberOne(original) == countNumberOne(target)) ? "YES"
				: "NO";
	}

	int countNumberOne(String matrix[]) {
		int count = 0;
		for (String row : matrix) {
			for (int i = 0; i < row.length(); i++) {
				if (row.charAt(i) == '1') {
					count++;
				}
			}
		}
		return count;
	}
}
