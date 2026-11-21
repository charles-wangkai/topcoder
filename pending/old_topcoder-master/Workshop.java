public class Workshop {
	public int pictureFrames(int[] pieces) {
		int frameNum = 0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = i + 1; j < pieces.length; j++) {
				for (int k = j + 1; k < pieces.length; k++) {
					if (isTriangle(pieces[i], pieces[j], pieces[k])) {
						frameNum++;
					}
				}
			}
		}
		return frameNum;
	}

	boolean isTriangle(int a, int b, int c) {
		return a + b > c && b + c > a && c + a > b;
	}
}
