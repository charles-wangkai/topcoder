import java.util.Arrays;

public class PipeCuts {
  public double probability(int[] weldLocations, int L) {
    Arrays.sort(weldLocations);

    int count = 0;
    int validCount = 0;
    for (int i = 0; i < weldLocations.length; ++i) {
      for (int j = i + 1; j < weldLocations.length; ++j) {
        ++count;

        if (weldLocations[i] > L
            || weldLocations[j] - weldLocations[i] > L
            || 100 - weldLocations[j] > L) {
          ++validCount;
        }
      }
    }

    return (double) validCount / count;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int[] p0, int p1, boolean hasAnswer, double p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + p1);
    System.out.println("]");
    PipeCuts obj;
    double answer;
    obj = new PipeCuts();
    long startTime = System.currentTimeMillis();
    answer = obj.probability(p0, p1);
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

    int[] p0;
    int p1;
    double p2;

    // ----- test 0 -----
    p0 = new int[] {25, 50, 75};
    p1 = 25;
    p2 = 1.0D;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {25, 50, 75};
    p1 = 50;
    p2 = 0.0D;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {25, 50, 75};
    p1 = 24;
    p2 = 1.0D;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {99, 88, 77, 66, 55, 44, 33, 22, 11};
    p1 = 50;
    p2 = 0.7222222222222222D;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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