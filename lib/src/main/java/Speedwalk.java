import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Speedwalk {
  static final char[] DIRECTIONS = {'n', 'e', 's', 'w', 'u', 'd'};

  public String shortest(int start, int target, String[] rooms) {
    Map<Integer, Map<Character, Integer>> nodeToExitMap = new HashMap<>();
    for (String room : rooms) {
      int[] fields =
          Arrays.stream(room.split("[: ]"))
              .filter(s -> !s.isEmpty())
              .mapToInt(Integer::parseInt)
              .toArray();
      int node = fields[0];

      Map<Character, Integer> exitMap = new HashMap<>();
      for (int i = 0; i < DIRECTIONS.length; ++i) {
        if (fields[i + 1] != 0) {
          exitMap.put(DIRECTIONS[i], fields[i + 1]);
        }
      }

      nodeToExitMap.put(node, exitMap);
    }

    Map<Integer, String> nodeToSimplified = new HashMap<>();

    PriorityQueue<Element> pq =
        new PriorityQueue<>(
            Comparator.<Element, Integer>comparing(element -> element.path.simplified.length())
                .thenComparing(element -> element.path.stepNum)
                .thenComparing(element -> element.path.simplified));
    pq.offer(new Element(new Path("", 0), start));

    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (!nodeToSimplified.containsKey(head.node)) {
        nodeToSimplified.put(head.node, head.path.simplified);

        for (char direction : DIRECTIONS) {
          int node = head.node;
          for (int i = 0; i < nodeToExitMap.size(); ++i) {
            if (!nodeToExitMap.get(node).containsKey(direction)) {
              break;
            }

            node = nodeToExitMap.get(node).get(direction);
            pq.offer(
                new Element(
                    new Path(
                        "%s%s%c"
                            .formatted(
                                head.path.simplified,
                                (i == 0) ? "" : String.valueOf(i + 1),
                                direction),
                        head.path.stepNum + (i + 1)),
                    node));
          }
        }
      }
    }

    return nodeToSimplified.getOrDefault(target, "***");
  }

  record Path(String simplified, int stepNum) {}

  record Element(Path path, int node) {}
}
