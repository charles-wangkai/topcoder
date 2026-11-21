import java.util.HashSet;

public class MarblesRegroupingEasy {
	public int minMoves(String[] boxes) {
		int minMove = Integer.MAX_VALUE;
		int boxNum = boxes.length;
		for (int joker = 0; joker < boxNum; joker++) {
			int move = 0;
			HashSet<Integer> colors = new HashSet<Integer>();
			for (int i = 0; i < boxNum; i++) {
				if (i == joker) {
					continue;
				}
				int colorLength = boxes[i].replace("0", "").length();
				if (colorLength > 1) {
					move++;
				} else if (colorLength == 1) {
					int color = -1;
					for (int j = 0;; j++) {
						if (boxes[i].charAt(j) != '0') {
							color = j;
							break;
						}
					}
					if (colors.contains(color)) {
						move++;
					}
					colors.add(color);
				}
			}
			minMove = Math.min(minMove, move);
		}
		return minMove;
	}
}
