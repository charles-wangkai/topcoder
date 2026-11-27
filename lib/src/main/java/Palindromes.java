import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Palindromes {
  public int count(String word) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : word.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    if (letterToCount.values().stream().filter(count -> count % 2 == 1).count() > 1) {
      return 0;
    }

    int[] halfCounts = letterToCount.values().stream().mapToInt(count -> count / 2).toArray();

    int result = 1;
    int rest = Arrays.stream(halfCounts).sum();
    for (int halfCount : halfCounts) {
      result *= C(rest, halfCount);
      rest -= halfCount;
    }

    return result;
  }

  int C(int n, int r) {
    int result = 1;
    for (int i = 0; i < r; ++i) {
      result = result * (n - i) / (i + 1);
    }

    return result;
  }
}
