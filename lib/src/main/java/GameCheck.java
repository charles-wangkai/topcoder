import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameCheck {
  public int lastValid(int[] moves) {
    Set<String> seen = new HashSet<>();
    seen.add(buildKey(moves[0]));

    int result = 0;
    Set<State> states = Set.of(new State(moves[0] / 10, moves[0] % 10));
    for (int i = 1; i < moves.length; ++i) {
      String key = buildKey(moves[i]);
      if (seen.contains(key)) {
        break;
      }
      seen.add(key);

      int d1 = moves[i] / 10;
      int d2 = moves[i] % 10;

      states =
          states.stream()
              .map(state -> {
                List<State> nextStates = new ArrayList<>();

                if (d1 == state.digit1()) {
                  nextStates.add(new State(d2, state.digit2()));
                } else if (d2 == state.digit1()) {
                  nextStates.add(new State(d1, state.digit2()));
                }

                if (d1 == state.digit2()) {
                  nextStates.add(new State(state.digit1(), d2));
                } else if (d2 == state.digit2()) {
                  nextStates.add(new State(state.digit1(), d1));
                }

                return nextStates;
              })
              .flatMap(List::stream)
              .collect(Collectors.toSet());

      if (states.isEmpty()) {
        break;
      }

      ++result;
    }

    return result;
  }

  String buildKey(int tile) {
    return "%02d"
        .formatted(tile)
        .chars()
        .sorted()
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}

record State(int digit1, int digit2) {}
