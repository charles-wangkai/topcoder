import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Network {
  public int reachable(String[] nodes, int start, int ttl) {
    Map<Integer, List<Integer>> nodeToAdjs = new HashMap<>();
    for (String s : nodes) {
      int[] fields = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
      int node1 = fields[0];
      int node2 = fields[1];

      nodeToAdjs.putIfAbsent(node1, new ArrayList<>());
      nodeToAdjs.get(node1).add(node2);

      nodeToAdjs.putIfAbsent(node2, new ArrayList<>());
      nodeToAdjs.get(node2).add(node1);
    }

    Map<Integer, Integer> nodeToDistance = new HashMap<>();
    for (int node : nodeToAdjs.keySet()) {
      nodeToDistance.put(node, Integer.MAX_VALUE);
    }
    nodeToDistance.put(start, 0);

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : nodeToAdjs.get(head)) {
        if (nodeToDistance.get(adj) == Integer.MAX_VALUE) {
          nodeToDistance.put(adj, nodeToDistance.get(head) + 1);
          queue.offer(adj);
        }
      }
    }

    return (int) nodeToDistance.values().stream().filter(distance -> distance > ttl).count();
  }
}
