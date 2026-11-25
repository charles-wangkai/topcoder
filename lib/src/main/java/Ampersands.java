import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ampersands {
  public String resolve(String initial, String[] substitutions) {
    Set<Integer> seen = new HashSet<>();
    List<Character> proceseed = process(substitutions, initial, seen, -1);

    if (proceseed == null) {
      return "***";
    }

    while (!proceseed.isEmpty() && proceseed.getLast() == '&') {
      proceseed.removeLast();
    }

    return proceseed.stream().map(String::valueOf).collect(Collectors.joining());
  }

  List<Character> process(String[] substitutions, String s, Set<Integer> seen, int index) {
    if (seen.contains(index)) {
      return null;
    }
    seen.add(index);

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = s.length() - 1; i >= 0; --i) {
      stack.push(s.charAt(i));
    }

    List<Character> result = new ArrayList<>();
    while (!stack.isEmpty()) {
      char top = stack.pop();
      if (!result.isEmpty() && result.getLast() == '&') {
        if (Character.isLetter(top)) {
          result.removeLast();
        } else if (Character.isDigit(top)) {
          int idx = top - '0';
          if (idx < substitutions.length) {
            result.removeLast();

            List<Character> proceseed = process(substitutions, substitutions[idx], seen, idx);
            if (proceseed == null) {
              return null;
            }

            for (int i = proceseed.size() - 1; i >= 0; --i) {
              stack.push(proceseed.get(i));
            }
          } else {
            result.removeLast();
          }
        } else {
          result.add(top);
        }
      } else {
        result.add(top);
      }
    }

    seen.remove(index);

    return result;
  }
}
