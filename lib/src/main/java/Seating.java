import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Seating {
  public int best(int m, int n, int k, int r) {
    if (m < n) {
      return best(n, m, k, r);
    }

    if (m + n > k * r) {
      return -1;
    }

    int[] rests = new int[k];
    Arrays.fill(rests, r);

    PriorityQueue<Integer> pq =
        new PriorityQueue<>(Comparator.<Integer, Integer>comparing(i -> rests[i]).reversed());
    for (int i = 0; i < k; ++i) {
      pq.offer(i);
    }

    while (n != 0 && rests[pq.peek()] >= 2) {
      --m;
      --n;

      int index = pq.poll();
      rests[index] -= 2;
      pq.offer(index);
    }

    int[] imbalances = new int[k];
    for (int i = 0; i < m + n; ++i) {
      int index = pq.poll();
      --rests[index];
      pq.offer(index);

      ++imbalances[index];
    }

    return Arrays.stream(imbalances).max().orElse(0);
  }
}
