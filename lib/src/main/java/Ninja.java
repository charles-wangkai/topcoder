import java.util.Arrays;
import java.util.stream.IntStream;

public class Ninja {
  public int inverse(String[] statistics, int ninjas) {
    int result = -1;
    for (int p = 1; p <= 4; ++p) {
      Range range = computeRange(statistics, p);
      if (range != null) {
        int minKillNum = range.min / pow(ninjas, p);
        int maxKillNum = range.max / pow(ninjas, p);
        if (minKillNum != maxKillNum || (result != -1 && minKillNum != result)) {
          return -1;
        }

        result = minKillNum;
      }
    }

    return result;
  }

  int pow(int base, int exponent) {
    return IntStream.range(0, exponent).reduce(1, (acc, x) -> acc * base);
  }

  Range computeRange(String[] statistics, int p) {
    long min = 1;
    long max = 1_000_000_000;
    for (String s : statistics) {
      int[] fields = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
      int N = fields[0];
      int K = fields[1];

      min = Math.max(min, (long) K * pow(N, p));
      max = Math.min(max, (K + 1L) * pow(N, p) - 1);
    }

    return (min <= max) ? new Range((int) min, (int) max) : null;
  }

  record Range(int min, int max) {}
}
