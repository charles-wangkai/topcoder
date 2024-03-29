public class TimeDifference {
  public String calculate(String startTime, String endTime) {
    int diff = computeTotalMinute(endTime) - computeTotalMinute(startTime);

    return String.format(
        "%s%d:%02d", (diff >= 0) ? "" : "-", Math.abs(diff) / 60, Math.abs(diff) % 60);
  }

  int computeTotalMinute(String time) {
    String[] parts = time.split(":");
    int hour = Integer.parseInt(parts[0]);
    int minute = Integer.parseInt(parts[1]);

    return hour * 60 + minute;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, String p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
    System.out.println("]");
    TimeDifference obj;
    String answer;
    obj = new TimeDifference();
    long startTime = System.currentTimeMillis();
    answer = obj.calculate(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + "\"" + p2 + "\"");
    }
    System.out.println("Your answer:");
    System.out.println("\t" + "\"" + answer + "\"");
    if (hasAnswer) {
      res = answer.equals(p2);
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
    String p2;

    // ----- test 0 -----
    p0 = "00:00";
    p1 = "13:23";
    p2 = "13:23";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "100:15";
    p1 = "13:23";
    p2 = "-86:52";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "001:00";
    p1 = "8:15";
    p2 = "7:15";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "123:45";
    p1 = "543:21";
    p2 = "419:36";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "111:11";
    p1 = "222:12";
    p2 = "111:01";
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "10:42";
    p1 = "10:47";
    p2 = "0:05";
    all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = "10:47";
    p1 = "010:47";
    p2 = "0:00";
    all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
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
