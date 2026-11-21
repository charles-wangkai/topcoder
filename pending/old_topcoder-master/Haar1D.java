public class Haar1D {
	public int[] transform(int[] data, int L) {
		int length = data.length;
		for (int level = 1; level <= L; level++) {
			int nextData[] = data.clone();
			for (int i = 0; i < length; i += 2) {
				nextData[i / 2] = data[i] + data[i + 1];
				nextData[length / 2 + i / 2] = data[i] - data[i + 1];
			}
			data = nextData;
			length /= 2;
		}
		return data;
	}
}
