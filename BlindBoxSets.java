import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BlindBoxSets {
  static Map<List<Integer>, Double> cache;

  public double expectedPurchases(int numSets, int numItems) {
    cache = new HashMap<>();

    List<Integer> counts =
        IntStream.rangeClosed(0, numSets)
            .map(i -> (i == numSets) ? numItems : 0)
            .boxed()
            .collect(Collectors.toList());

    return search(numItems, counts);
  }

  double search(int numItems, List<Integer> counts) {
    if (counts.get(0) == numItems) {
      return 0;
    }

    if (!cache.containsKey(counts)) {
      double nextSum = 0;
      for (int i = 1; i < counts.size(); ++i) {
        if (counts.get(i) != 0) {
          double p = (double) counts.get(i) / numItems;

          counts.set(i, counts.get(i) - 1);
          counts.set(i - 1, counts.get(i - 1) + 1);

          nextSum += p * (1 + search(numItems, counts));

          counts.set(i, counts.get(i) + 1);
          counts.set(i - 1, counts.get(i - 1) - 1);
        }
      }

      cache.put(
          List.copyOf(counts), (numItems * nextSum + counts.get(0)) / (numItems - counts.get(0)));
    }

    return cache.get(counts);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, boolean hasAnswer, double p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
    System.out.println("]");
    BlindBoxSets obj;
    double answer;
    obj = new BlindBoxSets();
    long startTime = System.currentTimeMillis();
    answer = obj.expectedPurchases(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p2);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = Math.abs(p2 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p2));
    }
    if (!res) {
      System.out.println("DOESN'T MATCH!!!!");
    } else if ((endTime - startTime) / 1000.0 >= 2) {
      System.out.println("FAIL the timeout");
      res = false;
    } else if (hasAnswer) {
      System.out.println("Match :-)");
    } else {
      System.out.println("OK, but is it right?");
    }
    System.out.println("");
    return res;
  }

  public static void main(String[] args) {
    boolean all_right;
    all_right = true;

    int p0;
    int p1;
    double p2;

    // ----- test 0 -----
    p0 = 1;
    p1 = 1;
    p2 = 1.0D;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 1;
    p1 = 2;
    p2 = 3.0D;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 2;
    p1 = 1;
    p2 = 2.0D;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 2;
    p1 = 2;
    p2 = 5.5D;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 4;
    p1 = 50;
    all_right = KawigiEdit_RunTest(4, p0, p1, false, p2) && all_right;
    // ------------------

    if (all_right) {
      System.out.println("You're a stud (at least on the example cases)!");
    } else {
      System.out.println("Some of the test cases had errors.");
    }
  }
  // END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
