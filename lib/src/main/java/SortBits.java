import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class SortBits {
  public int countWays(String bitStates, int intervalSize) {
    Map<String, Integer> stateToDistance = new HashMap<>();
    stateToDistance.put(bitStates, 0);

    Map<String, Integer> stateToWayNum = new HashMap<>();
    stateToWayNum.put(bitStates, 1);

    Queue<String> queue = new ArrayDeque<>();
    queue.offer(bitStates);

    while (!queue.isEmpty()) {
      String head = queue.poll();
      for (int i = 0; i + intervalSize <= head.length(); ++i) {
        String nextState = buildNextState(head, i, i + intervalSize - 1);
        if (!stateToDistance.containsKey(nextState)) {
          stateToDistance.put(nextState, stateToDistance.get(head) + 1);
          stateToWayNum.put(nextState, stateToWayNum.get(head));
          queue.offer(nextState);
        } else if (stateToDistance.get(nextState) == stateToDistance.get(head) + 1) {
          stateToWayNum.put(nextState, stateToWayNum.get(nextState) + stateToWayNum.get(head));
        }
      }
    }

    return stateToWayNum.getOrDefault(
        bitStates
            .chars()
            .sorted()
            .mapToObj(c -> (char) c)
            .map(String::valueOf)
            .collect(Collectors.joining()),
        -1);
  }

  String buildNextState(String state, int beginIndex, int endIndex) {
    char[] cs = state.toCharArray();
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      char temp = cs[i];
      cs[i] = cs[j];
      cs[j] = temp;
    }

    return String.valueOf(cs);
  }
}
