public class LevelUp {
  public int toNextLevel(int[] expNeeded, int received) {
    for (int i = 0; ; ++i) {
      if (received < expNeeded[i]) {
        return expNeeded[i] - received;
      }
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + p1);
    System.out.println("]");
    LevelUp obj;
    int answer;
    obj = new LevelUp();
    long startTime = System.currentTimeMillis();
    answer = obj.toNextLevel(p0, p1);
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

    int[] p0;
    int p1;
    int p2;

    // ----- test 0 -----
    p0 = new int[] {150, 450, 900, 1800};
    p1 = 133;
    p2 = 17;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {150, 450, 900, 1800};
    p1 = 312;
    p2 = 138;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {150, 450, 900, 1800};
    p1 = 612;
    p2 = 288;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {150, 450, 900, 1800};
    p1 = 450;
    p2 = 450;
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