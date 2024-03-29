import java.util.stream.Collectors;

public class SuperRot {
  public String decoder(String message) {
    return message
        .chars()
        .map(
            c -> {
              if (Character.isLowerCase(c)) {
                return (c - 'a' + 13) % 26 + 'a';
              } else if (Character.isUpperCase(c)) {
                return (c - 'A' + 13) % 26 + 'A';
              } else if (Character.isDigit(c)) {
                return (c - '0' + 5) % 10 + '0';
              } else {
                return c;
              }
            })
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    SuperRot obj;
    String answer;
    obj = new SuperRot();
    long startTime = System.currentTimeMillis();
    answer = obj.decoder(p0);
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
    p0 = "Uryyb 28";
    p1 = "Hello 73";
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "GbcPbqre";
    p1 = "TopCoder";
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "";
    p1 = "";
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "5678901234";
    p1 = "0123456789";
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "NnOoPpQqRr AaBbCcDdEe";
    p1 = "AaBbCcDdEe NnOoPpQqRr";
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "Gvzr vf 54 71 CZ ba Whyl 4gu bs gur lrne 7558 NQ";
    p1 = "Time is 09 26 PM on July 9th of the year 2003 AD";
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = "Gur dhvpx oebja sbk whzcf bire n ynml qbt";
    p1 = "The quick brown fox jumps over a lazy dog";
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
