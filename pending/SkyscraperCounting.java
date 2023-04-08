public class SkyscraperCounting {
  static final int MODULUS = 1_000_000_007;

  public int count(String visibility) {
    if (visibility.charAt(0) == 'X') {
      return 0;
    }

    int[][] P = new int[visibility.length() + 1][visibility.length() + 1];
    P[0][0] = 1;
    for (int i = 1; i < P.length; ++i) {
      P[i][0] = 1;
      for (int j = 1; j <= i; ++j) {
        P[i][j] = multiplyMod(P[i][j - 1], i - j + 1);
      }
    }

    int result = 1;
    int lastIndex = visibility.length();
    for (int i = visibility.length() - 1; i >= 0; --i) {
      if (visibility.charAt(i) == 'O') {
        result = multiplyMod(result, P[lastIndex - 1][lastIndex - 1 - i]);

        lastIndex = i;
      }
    }

    return result;
  }

  static int multiplyMod(int x, int y) {
    return (int) Math.floorMod((long) x * y, MODULUS);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    SkyscraperCounting obj;
    int answer;
    obj = new SkyscraperCounting();
    long startTime = System.currentTimeMillis();
    answer = obj.count(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p1);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p1;
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

    // ----- test 0 -----
    p0 = "OXXXX";
    p1 = 24;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "OXOXXOX";
    p1 = 72;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "XOXOXO";
    p1 = 0;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "OXXXXXXXXXXXXXO";
    p1 = 227020758;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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