public class bloggoShortcuts {
  public String expand(String text) {
    boolean italicOpen = true;
    boolean boldOpen = true;
    StringBuilder result = new StringBuilder();
    for (char c : text.toCharArray()) {
      if (c == '_') {
        result.append(italicOpen ? "<i>" : "</i>");
        italicOpen ^= true;
      } else if (c == '*') {
        result.append(boldOpen ? "<b>" : "</b>");
        boldOpen ^= true;
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    bloggoShortcuts obj;
    String answer;
    obj = new bloggoShortcuts();
    long startTime = System.currentTimeMillis();
    answer = obj.expand(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + "\"" + p1 + "\"");
    }
    System.out.println("Your answer:");
    System.out.println("\t" + "\"" + answer + "\"");
    if (hasAnswer) {
      res = answer.equals(p1);
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

    // ----- test 0 -----
    p0 = "You _should_ see the new walrus at the zoo!";
    p1 = "You <i>should</i> see the new walrus at the zoo!";
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "Move it from *Accounts Payable* to *Receiving*.";
    p1 = "Move it from <b>Accounts Payable</b> to <b>Receiving</b>.";
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "I saw _Chelydra serpentina_ in *Centennial Park*.";
    p1 = "I saw <i>Chelydra serpentina</i> in <b>Centennial Park</b>.";
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = " _ _ __  _ yabba dabba _   *  dooooo  * ****";
    p1 = " <i> </i> <i></i>  <i> yabba dabba </i>   <b>  dooooo  </b> <b></b><b></b>";
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "_now_I_know_*my*_ABC_next_time_*sing*it_with_me";
    p1 = "<i>now</i>I<i>know</i><b>my</b><i>ABC</i>next<i>time</i><b>sing</b>it<i>with</i>me";
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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