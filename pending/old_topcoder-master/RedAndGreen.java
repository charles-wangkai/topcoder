public class RedAndGreen {
	public int minPaints(String row) {
		int paint = 0;
		for (int i = 0; i < row.length(); i++) {
			if (row.charAt(i) == 'R') {
				paint++;
			}
		}
		int minPaint = paint;
		for (int i = 0; i < row.length(); i++) {
			if (row.charAt(i) == 'R') {
				paint--;
			} else {
				paint++;
			}
			minPaint = Math.min(minPaint, paint);
		}
		return minPaint;
	}
}
