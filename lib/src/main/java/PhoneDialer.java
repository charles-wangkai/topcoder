import static java.util.Map.entry;

import java.util.Map;
import java.util.stream.IntStream;

public class PhoneDialer {
  static final Map<Integer, Point> DIGIT_TO_POINT =
      Map.ofEntries(
          entry(1, new Point(0, 0)),
          entry(2, new Point(0, 1)),
          entry(3, new Point(0, 2)),
          entry(4, new Point(1, 0)),
          entry(5, new Point(1, 1)),
          entry(6, new Point(1, 2)),
          entry(7, new Point(2, 0)),
          entry(8, new Point(2, 1)),
          entry(9, new Point(2, 2)),
          entry(0, new Point(3, 1)));

  public String findFriend(String[] directory) {
    String result = null;
    int minDistance = Integer.MAX_VALUE;
    for (String entry : directory) {
      int[] digits = entry.chars().filter(Character::isDigit).map(c -> c - '0').toArray();
      int distance =
          IntStream.range(0, digits.length - 1)
              .map(i ->
                  computeDistance(DIGIT_TO_POINT.get(digits[i]), DIGIT_TO_POINT.get(digits[i + 1])))
              .sum();
      if (distance < minDistance) {
        minDistance = distance;
        result = entry.substring(entry.indexOf(',') + 2);
      }
    }

    return result;
  }

  int computeDistance(Point p1, Point p2) {
    return Math.abs(p1.r() - p2.r()) + Math.abs(p1.c() - p2.c());
  }

  record Point(int r, int c) {}
}
