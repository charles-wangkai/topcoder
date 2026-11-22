import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lardless {
  static final String TARGET = "lard";

  public String stripLard(String s) {
    List<Character> result = new ArrayList<>();
    for (char c : s.toCharArray()) {
      result.add(c);

      if (result.size() >= TARGET.length()
          && IntStream.range(0, TARGET.length())
              .allMatch(i ->
                  Character.toLowerCase(result.get(result.size() - TARGET.length() + i))
                      == TARGET.charAt(i))) {
        for (int i = 0; i < TARGET.length(); ++i) {
          result.removeLast();
        }
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining());
  }
}
