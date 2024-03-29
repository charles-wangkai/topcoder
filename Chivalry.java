public class Chivalry {
  public String getOrder(String first, String second) {
    StringBuilder result = new StringBuilder();
    int firstIndex = 0;
    int secondIndex = 0;
    while (firstIndex != first.length() || secondIndex != second.length()) {
      if (secondIndex == second.length()
          || (firstIndex != first.length()
              && (first.charAt(firstIndex) == 'W' || second.charAt(secondIndex) == 'M'))) {
        result.append(first.charAt(firstIndex));
        ++firstIndex;
      } else {
        result.append(second.charAt(secondIndex));
        ++secondIndex;
      }
    }

    return result.toString();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, String p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
    System.out.println("]");
    Chivalry obj;
    String answer;
    obj = new Chivalry();
    long startTime = System.currentTimeMillis();
    answer = obj.getOrder(p0, p1);
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
    p0 = "M";
    p1 = "W";
    p2 = "WM";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "MM";
    p1 = "MW";
    p2 = "MMMW";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "MMMM";
    p1 = "W";
    p2 = "WMMMM";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "M";
    p1 = "WWW";
    p2 = "WWWM";
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
