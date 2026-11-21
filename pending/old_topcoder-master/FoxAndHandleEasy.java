import java.util.stream.IntStream;

public class FoxAndHandleEasy {
	public String isPossible(String S, String T) {
		return IntStream.rangeClosed(0, S.length())
				.mapToObj((i) -> S.substring(0, i) + S + S.substring(i))
				.anyMatch((expanded) -> T.equals(expanded)) ? "Yes" : "No";
	}
}
