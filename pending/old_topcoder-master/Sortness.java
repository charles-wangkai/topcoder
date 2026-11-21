public class Sortness {
	public double getSortness(int[] a) {
		int sortness[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					sortness[i]++;
					sortness[j]++;
				}
			}
		}
		int total = 0;
		for (int s : sortness) {
			total += s;
		}
		return (double) total / a.length;
	}
}
