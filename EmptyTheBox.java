import java.util.HashMap;
import java.util.Map;

public class EmptyTheBox {
  Map<Integer, Double> cache;

  public double minExpectedPenalty(int D, int T) {
    Map<Integer, Double> rollToProb = new HashMap<>();
    for (int i = 1; i <= D; ++i) {
      for (int j = 1; j <= D; ++j) {
        int roll = i + j;

        rollToProb.put(roll, rollToProb.getOrDefault(roll, 0.0) + 1.0 / (D * D));
      }
    }

    double result = 0;
    while (T > D + D) {
      result += T;
      --T;
    }

    cache = new HashMap<>();
    result += search(rollToProb, (1 << T) - 1);

    return result;
  }

  double search(Map<Integer, Double> rollToProb, int mask) {
    if (!cache.containsKey(mask)) {
      int tokenSum = computeTokenSum(mask);
      Map<Integer, Double> rollToMinPenalty = new HashMap<>();
      for (int roll : rollToProb.keySet()) {
        rollToMinPenalty.put(roll, (double) tokenSum);
      }

      for (int nextMask = 0; nextMask < mask; ++nextMask) {
        if ((nextMask & mask) == nextMask) {
          int nextTokenSum = computeTokenSum(nextMask);
          int roll = tokenSum - nextTokenSum;

          if (rollToProb.containsKey(roll)) {
            rollToMinPenalty.put(
                roll, Math.min(rollToMinPenalty.get(roll), search(rollToProb, nextMask)));
          }
        }
      }

      cache.put(
          mask,
          rollToProb.keySet().stream()
              .mapToDouble(roll -> rollToProb.get(roll) * rollToMinPenalty.get(roll))
              .sum());
    }

    return cache.get(mask);
  }

  int computeTokenSum(int mask) {
    int result = 0;
    for (int token = 1; mask != 0; ++token) {
      if ((mask & 1) != 0) {
        result += token;
      }

      mask >>= 1;
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, boolean hasAnswer, double p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
    System.out.println("]");
    EmptyTheBox obj;
    double answer;
    obj = new EmptyTheBox();
    long startTime = System.currentTimeMillis();
    answer = obj.minExpectedPenalty(p0, p1);
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
    p0 = 2;
    p1 = 3;
    p2 = 1.25D;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 6;
    p1 = 2;
    p2 = 2.777777777777778D;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 6;
    p1 = 10;
    p2 = 16.64572136166177D;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 4;
    p1 = 10;
    p2 = 33.489906787872314D;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 6;
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
