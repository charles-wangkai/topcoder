public class DivisibilityCriteria {
  public int[] multipliers(int N, int P) {
    int[] result = new int[N];
    result[result.length - 1] = 1;
    for (int i = result.length - 2; i >= 0; --i) {
      result[i] = result[i + 1] * 10 % P;
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, boolean hasAnswer, int[] p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
    System.out.println("]");
    DivisibilityCriteria obj;
    int[] answer;
    obj = new DivisibilityCriteria();
    long startTime = System.currentTimeMillis();
    answer = obj.multipliers(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p2.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p2[i]);
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(answer[i]);
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p2.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p2[i]) {
            res = false;
          }
        }
      }
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
    int[] p2;

    // ----- test 0 -----
    p0 = 6;
    p1 = 7;
    p2 = new int[] {5, 4, 6, 2, 3, 1};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 7;
    p1 = 11;
    p2 = new int[] {1, 10, 1, 10, 1, 10, 1};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 5;
    p1 = 13;
    p2 = new int[] {3, 12, 9, 10, 1};
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 2;
    p1 = 2;
    p2 = new int[] {0, 1};
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 16;
    p1 = 97;
    p2 = new int[] {45, 53, 15, 50, 5, 49, 34, 81, 76, 27, 90, 9, 30, 3, 10, 1};
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
