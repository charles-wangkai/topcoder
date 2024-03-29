public class BadClock {
  static final int TOTAL_SECOND_PER_LOOP = 12 * 60 * 60;

  public double nextAgreement(String trueTime, String skewTime, int hourlyGain) {
    int trueTotalSecond = computeTotalSecond(trueTime);
    int skewTotalSecond = computeTotalSecond(skewTime);

    return (hourlyGain < 0)
        ? ((double) Math.floorMod(skewTotalSecond - trueTotalSecond, TOTAL_SECOND_PER_LOOP)
            / -hourlyGain)
        : ((double) Math.floorMod(trueTotalSecond - skewTotalSecond, TOTAL_SECOND_PER_LOOP)
            / hourlyGain);
  }

  int computeTotalSecond(String time) {
    String[] parts = time.split(":");
    int hour = Integer.parseInt(parts[0]);
    int minute = Integer.parseInt(parts[1]);
    int second = Integer.parseInt(parts[2]);

    return Math.floorMod(hour * 60 * 60 + minute * 60 + second, TOTAL_SECOND_PER_LOOP);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, String p1, int p2, boolean hasAnswer, double p3) {
    System.out.print(
        "Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"" + "," + p2);
    System.out.println("]");
    BadClock obj;
    double answer;
    obj = new BadClock();
    long startTime = System.currentTimeMillis();
    answer = obj.nextAgreement(p0, p1, p2);
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
      res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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

    String p0;
    String p1;
    int p2;
    double p3;

    // ----- test 0 -----
    p0 = "07:07:07";
    p1 = "07:07:07";
    p2 = 1776;
    p3 = 0.0D;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "11:59:58";
    p1 = "12:03:28";
    p2 = -3;
    p3 = 70.0D;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "12:03:28";
    p1 = "11:59:58";
    p2 = 3;
    p3 = 70.0D;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "03:03:02";
    p1 = "03:01:47";
    p2 = 5;
    p3 = 15.0D;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "03:03:02";
    p1 = "03:01:47";
    p2 = -5;
    p3 = 8625.0D;
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "07:08:09";
    p1 = "09:08:07";
    p2 = -321;
    p3 = 22.42367601246106D;
    all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
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
