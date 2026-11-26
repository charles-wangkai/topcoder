import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Map;

public class EMS {
  static final Map<Integer, Integer> INTERSECTION_TO_TIME =
      Map.ofEntries(entry(0, 0), entry(1, 3), entry(2, 5));

  public int minResponseTime(int[] rig1, int[] rig2) {
    return Math.min(computeResponseTime(rig1), computeResponseTime(rig2));
  }

  int computeResponseTime(int[] rig) {
    return rig.length * 10 + Arrays.stream(rig).map(INTERSECTION_TO_TIME::get).sum();
  }
}
