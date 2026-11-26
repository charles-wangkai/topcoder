import static java.util.Map.entry;

import java.util.Map;
import java.util.stream.Collectors;

public class BetaEasy {
  static final Map<Character, Character> LETTER_TO_COMPLEMENT =
      Map.ofEntries(entry('A', 'T'), entry('T', 'A'), entry('G', 'C'), entry('C', 'G'));

  public String solve(String strStrand) {
    return strStrand
        .chars()
        .mapToObj(c -> LETTER_TO_COMPLEMENT.get((char) c))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
