import java.util.LinkedList;

public class MathContest {
	public int countBlack(String ballSequence, int repetitions) {
		LinkedList<Character> balls = new LinkedList<Character>();
		for (int i = 0; i < repetitions; i++) {
			for (int j = 0; j < ballSequence.length(); j++) {
				balls.add(new Character(ballSequence.charAt(j)));
			}
		}
		boolean reverseOrder = false;
		boolean invertColor = false;
		int blackNum = 0;
		while (!balls.isEmpty()) {
			char ball;
			if (!reverseOrder) {
				ball = balls.removeFirst();
			} else {
				ball = balls.removeLast();
			}
			if (invertColor != (ball == 'W')) {
				reverseOrder = !reverseOrder;
			} else {
				blackNum++;
				invertColor = !invertColor;
			}
		}
		return blackNum;
	}
}
