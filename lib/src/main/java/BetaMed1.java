import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BetaMed1 {
  public String solve(String message, String codeWord, int action) {
    if (IntStream.concat(message.chars(), codeWord.chars()).anyMatch(c -> !(c >= 'A' && c <= 'Z'))
        || (codeWord.isEmpty() && !message.isEmpty())
        || (action != 1 && action != 2)) {
      return "ERROR";
    }

    return IntStream.range(0, message.length())
        .mapToObj(i ->
            (char)
                (Math.floorMod(
                        message.charAt(i)
                            - 'A'
                            + ((action == 1) ? 1 : -1)
                                * (codeWord.charAt(i % codeWord.length()) - 'A'),
                        26)
                    + 'A'))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
