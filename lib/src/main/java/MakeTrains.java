import java.util.HashMap;
import java.util.Map;

public class MakeTrains {
  public int longest(int[] tiles) {
    Map<State, Integer> dp = Map.of();
    for (int tile : tiles) {
      int d1 = tile / 10;
      int d2 = tile % 10;

      Map<State, Integer> nextDp = new HashMap<>(dp);

      update(nextDp, new State(d1, d2), 1);

      for (State state : dp.keySet()) {
        if (d1 == state.digit1()) {
          update(nextDp, new State(d2, state.digit2()), dp.get(state) + 1);
        } else if (d2 == state.digit1()) {
          update(nextDp, new State(d1, state.digit2()), dp.get(state) + 1);
        }

        if (d1 == state.digit2()) {
          update(nextDp, new State(state.digit1(), d2), dp.get(state) + 1);
        } else if (d2 == state.digit2()) {
          update(nextDp, new State(state.digit1(), d1), dp.get(state) + 1);
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  void update(Map<State, Integer> stateToLength, State state, int length) {
    stateToLength.put(state, Math.max(stateToLength.getOrDefault(state, 0), length));
  }

  record State(int digit1, int digit2) {}
}
