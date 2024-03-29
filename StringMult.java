public class StringMult {
  public String times(String sFactor, int iFactor) {
    if (iFactor < 0) {
      return times(new StringBuilder(sFactor).reverse().toString(), -iFactor);
    }

    return sFactor.repeat(iFactor);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, int p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1);
    System.out.println("]");
    StringMult obj;
    String answer;
    obj = new StringMult();
    long startTime = System.currentTimeMillis();
    answer = obj.times(p0, p1);
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
    int p1;
    String p2;

    // ----- test 0 -----
    p0 = "wOw";
    p1 = 0;
    p2 = "";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "AbC";
    p1 = -3;
    p2 = "CbACbACbA";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "Boo";
    p1 = 4;
    p2 = "BooBooBooBoo";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "";
    p1 = 50;
    p2 = "";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "Racecar";
    p1 = -5;
    p2 = "racecaRracecaRracecaRracecaRracecaR";
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
