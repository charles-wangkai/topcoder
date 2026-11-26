import java.util.HashMap;
import java.util.Map;

public class BetaHard1 {
  public int solve(String input1, String input2) {
    Map<Character, Integer> charToCount1 = buildCharToCount(input1);
    Map<Character, Integer> charToCount2 = buildCharToCount(input2);

    return charToCount2.keySet().stream()
        .mapToInt(c -> Math.min(charToCount1.getOrDefault(c, 0), charToCount2.get(c)))
        .sum();
  }

  Map<Character, Integer> buildCharToCount(String s) {
    Map<Character, Integer> charToCount = new HashMap<>();
    for (char c : s.toCharArray()) {
      charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
    }

    return charToCount;
  }
}
