public class PaperFold {
	public int numFolds(int[] paper, int[] box) {
		int minFold = Math.min(
				needFold(paper[0], box[0]) + needFold(paper[1], box[1]),
				needFold(paper[0], box[1]) + needFold(paper[1], box[0]));
		return (minFold <= 8) ? minFold : -1;
	}

	int needFold(int paperSize, int boxSize) {
		for (int i = 0;; i++) {
			if (boxSize >= paperSize) {
				return i;
			}
			boxSize <<= 1;
		}
	}
}
