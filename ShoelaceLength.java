public class ShoelaceLength {
  public double calculate(int startWidth, int endWidth, int spread, int numPairs) {
    double result = startWidth;
    for (int i = 0; i < numPairs - 1; ++i) {
      double width1 = (startWidth + (endWidth - startWidth) / (numPairs - 1.0) * i) / 2;
      double width2 = (startWidth + (endWidth - startWidth) / (numPairs - 1.0) * (i + 1)) / 2;

      result += 2 * Math.sqrt((width1 + width2) * (width1 + width2) + spread * spread);
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, double p4) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
    System.out.println("]");
    ShoelaceLength obj;
    double answer;
    obj = new ShoelaceLength();
    long startTime = System.currentTimeMillis();
    answer = obj.calculate(p0, p1, p2, p3);
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
      res = Math.abs(p4 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p4));
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
    double p4;

    // ----- test 0 -----
    p0 = 2;
    p1 = 2;
    p2 = 1;
    p3 = 2;
    p4 = 6.47213595499958D;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 10;
    p1 = 1;
    p2 = 1;
    p3 = 10;
    p4 = 111.1786186482248D;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 1;
    p1 = 10;
    p2 = 1;
    p3 = 10;
    p4 = 102.17861864822481D;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 1;
    p1 = 1;
    p2 = 1;
    p3 = 2;
    p4 = 3.8284271247461903D;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 1;
    p1 = 99;
    p2 = 19;
    p3 = 2;
    p4 = 107.97663296253066D;
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
