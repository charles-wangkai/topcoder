public class BinaryPolynomialDivTwo {
	public int countRoots(int[] a) {
		int rootNum = 0;
		if (a[0] == 0) {
			rootNum++;
		}
		int sum = 0;
		for (int coef : a) {
			sum += coef;
		}
		if (sum % 2 == 0) {
			rootNum++;
		}
		return rootNum;
	}
}
