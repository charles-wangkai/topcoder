import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeadLang {
  public String dictEntry(int index, String alpha, String[] story) {
    Map<Character, Character> LETTER_TO_TRANSLATED =
        IntStream.range(0, alpha.length())
            .boxed()
            .collect(Collectors.toMap(alpha::charAt, i -> (char) (i + 'a')));

    return Arrays.stream(story)
        .flatMap(s -> Arrays.stream(s.toUpperCase().split("[^A-Z]")))
        .filter(x -> !x.isEmpty())
        .distinct()
        .sorted(
            Comparator.<String, String>comparing(x ->
                x.chars()
                    .mapToObj(c -> (char) c)
                    .map(LETTER_TO_TRANSLATED::get)
                    .map(String::valueOf)
                    .collect(Collectors.joining())))
        .skip(index - 1)
        .findFirst()
        .get();
  }
}
