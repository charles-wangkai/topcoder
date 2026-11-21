import java.util.Arrays;

public class FoxAndGame {
	public int countStars(String[] result) {
		return (int) Arrays
				.asList(result)
				.stream()
				.mapToLong(
						(stage) -> stage.chars().filter(c -> c == 'o').count())
				.sum();
	}
}
