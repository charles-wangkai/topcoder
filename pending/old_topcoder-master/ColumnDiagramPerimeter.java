public class ColumnDiagramPerimeter {
	public int getPerimiter(int[] a) {
		int perimeter = a.length * 2 + a[0] + a[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			perimeter += Math.abs(a[i] - a[i - 1]);
		}
		return perimeter;
	}
}
