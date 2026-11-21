import java.util.stream.IntStream;

public class MagicalStringDiv2 {
	public int minimalMoves(String S) {
		int k = S.length() / 2;
		return diffCount(S, 0, k, '>') + diffCount(S, k, S.length(), '<');
	}

	int diffCount(String S, int beginIndex, int endIndex, char target) {
		return (int) IntStream.range(beginIndex, endIndex).mapToObj(S::charAt).filter(ch -> ch != target).count();
	}
}
