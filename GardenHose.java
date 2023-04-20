public class GardenHose {
  public int countDead(int n, int rowDist, int colDist, int hoseDist) {
    return Math.max(0, n - hoseDist / rowDist * 2) * Math.max(0, n - hoseDist / colDist * 2);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, int p4) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
    System.out.println("]");
    GardenHose obj;
    int answer;
    obj = new GardenHose();
    long startTime = System.currentTimeMillis();
    answer = obj.countDead(p0, p1, p2, p3);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p4);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p4;
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
    int p2;
    int p3;
    int p4;

    // ----- test 0 -----
    p0 = 3;
    p1 = 2;
    p2 = 1;
    p3 = 2;
    p4 = 0;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 3;
    p1 = 2;
    p2 = 1;
    p3 = 1;
    p4 = 3;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 6;
    p1 = 2;
    p2 = 5;
    p3 = 5;
    p4 = 8;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 6;
    p1 = 2;
    p2 = 5;
    p3 = 3;
    p4 = 24;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 50;
    p1 = 50;
    p2 = 50;
    p3 = 49;
    p4 = 2500;
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
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
