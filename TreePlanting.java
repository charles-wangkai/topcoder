public class TreePlanting {
  public long countArrangements(int total, int fancy) {
    long[][] dp = new long[fancy + 1][2];
    dp[0][0] = 1;
    for (int i = 0; i < total; ++i) {
      long[][] nextDp = new long[fancy + 1][2];
      for (int j = 0; j <= fancy; ++j) {
        nextDp[j][0] = dp[j][0] + dp[j][1];

        if (j != 0) {
          nextDp[j][1] = dp[j - 1][0];
        }
      }

      dp = nextDp;
    }

    return dp[fancy][0] + dp[fancy][1];
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, boolean hasAnswer, long p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
    System.out.println("]");
    TreePlanting obj;
    long answer;
    obj = new TreePlanting();
    long startTime = System.currentTimeMillis();
    answer = obj.countArrangements(p0, p1);
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
      res = answer == p2;
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
    long p2;

    // ----- test 0 -----
    p0 = 4;
    p1 = 2;
    p2 = 3L;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 3;
    p1 = 1;
    p2 = 3L;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 4;
    p1 = 3;
    p2 = 0L;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 10;
    p1 = 4;
    p2 = 35L;
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
