import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MCI {
  public int[] dispatchUnits(String[] units, int minor, int delayed, int immediate) {
    Map<Integer, List<Integer>> distanceToBlsUnits = new HashMap<>();
    Map<Integer, List<Integer>> distanceToAlsUnits = new HashMap<>();
    for (String u : units) {
      String[] fields =
          Arrays.stream(u.split("[ #:]")).filter(s -> !s.isEmpty()).toArray(String[]::new);
      String type = fields[0];
      int unit = Integer.parseInt(fields[1]);
      int distance = Integer.parseInt(fields[2]);

      distanceToBlsUnits.putIfAbsent(distance, new ArrayList<>());
      distanceToAlsUnits.putIfAbsent(distance, new ArrayList<>());

      (type.equals("BLS") ? distanceToBlsUnits : distanceToAlsUnits).get(distance).add(unit);
    }

    for (List<Integer> blsUnits : distanceToBlsUnits.values()) {
      Collections.sort(blsUnits);
    }
    for (List<Integer> alsUnits : distanceToAlsUnits.values()) {
      Collections.sort(alsUnits);
    }

    int[] sortedDistances =
        distanceToBlsUnits.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();

    List<Integer> chosenUnits = new ArrayList<>();
    int blsCount = 0;
    int alsCount = 0;
    for (int distance : sortedDistances) {
      List<Integer> blsUnits = distanceToBlsUnits.get(distance);
      List<Integer> alsUnits = distanceToAlsUnits.get(distance);

      int a = 0;
      while (a <= alsUnits.size()
          && !check(minor, delayed, immediate, blsCount + blsUnits.size(), alsCount + a)) {
        ++a;
      }

      if (a <= alsUnits.size()) {
        int b = blsUnits.size();
        while (b != 0 && check(minor, delayed, immediate, blsCount + (b - 1), alsCount + a)) {
          --b;
        }

        for (int i = 0; i < b; ++i) {
          chosenUnits.add(blsUnits.get(i));
        }
        for (int i = 0; i < a; ++i) {
          chosenUnits.add(alsUnits.get(i));
        }

        break;
      }

      chosenUnits.addAll(blsUnits);
      blsCount += blsUnits.size();

      chosenUnits.addAll(alsUnits);
      alsCount += alsUnits.size();
    }

    return chosenUnits.stream().mapToInt(Integer::intValue).sorted().toArray();
  }

  boolean check(int minor, int delayed, int immediate, int blsNum, int alsNum) {
    Set<Capacity> dp = Set.of(new Capacity(0, 0, 0));
    for (int i = 0; i < blsNum; ++i) {
      dp =
          dp.stream()
              .flatMap(capacity ->
                  Stream.of(
                      new Capacity(
                          capacity.maxMinor, capacity.maxDelayed + 2, capacity.maxImmediate),
                      new Capacity(
                          capacity.maxMinor + 3, capacity.maxDelayed + 1, capacity.maxImmediate),
                      new Capacity(
                          capacity.maxMinor + 6, capacity.maxDelayed, capacity.maxImmediate)))
              .collect(Collectors.toSet());
    }
    for (int i = 0; i < alsNum; ++i) {
      dp =
          dp.stream()
              .flatMap(capacity ->
                  Stream.of(
                      new Capacity(
                          capacity.maxMinor, capacity.maxDelayed + 1, capacity.maxImmediate + 1),
                      new Capacity(
                          capacity.maxMinor + 2, capacity.maxDelayed, capacity.maxImmediate + 1)))
              .collect(Collectors.toSet());
    }

    return dp.stream()
        .anyMatch(capacity ->
            capacity.maxMinor >= minor
                && capacity.maxDelayed >= delayed
                && capacity.maxImmediate >= immediate);
  }

  record Capacity(int maxMinor, int maxDelayed, int maxImmediate) {}
}
