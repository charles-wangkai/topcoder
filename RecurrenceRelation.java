import java.util.stream.IntStream;

public class RecurrenceRelation {
  public int moduloTen(int[] coefficients, int[] initial, int N) {
    int length = coefficients.length;

    if (N < length) {
      return Math.floorMod(initial[N], 10);
    }

    for (int i = 0; i < N - length + 1; ++i) {
      int next =
          Math.floorMod(
              IntStream.range(0, length).map(j -> coefficients[j] * initial[j]).sum(), 10);

      for (int j = 0; j < length - 1; ++j) {
        initial[j] = initial[j + 1];
      }
      initial[length - 1] = next;
    }

    return initial[length - 1];
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int p3) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p1[i]);
    }
    System.out.print("}" + "," + p2);
    System.out.println("]");
    RecurrenceRelation obj;
    int answer;
    obj = new RecurrenceRelation();
    long startTime = System.currentTimeMillis();
    answer = obj.moduloTen(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p3);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p3;
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
    int[] p1;
    int p2;
    int p3;

    // ----- test 0 -----
    p0 = new int[] {2, 1};
    p1 = new int[] {9, 7};
    p2 = 6;
    p3 = 5;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {1, 1};
    p1 = new int[] {0, 1};
    p2 = 9;
    p3 = 4;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {2};
    p1 = new int[] {1};
    p2 = 20;
    p3 = 6;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {2};
    p1 = new int[] {1};
    p2 = 64;
    p3 = 6;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new int[] {25, 143};
    p1 = new int[] {0, 0};
    p2 = 100000;
    p3 = 0;
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    p1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    p2 = 654;
    p3 = 5;
    all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = new int[] {901, 492, 100};
    p1 = new int[] {-6, -15, -39};
    p2 = 0;
    p3 = 4;
    all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;
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