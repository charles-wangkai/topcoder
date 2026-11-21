import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlienAndPassword {
	public int getNumber(String S) {
		return IntStream.range(0, S.length()).mapToObj(i -> S.substring(0, i) + S.substring(i + 1))
				.collect(Collectors.toSet()).size();
	}
}
