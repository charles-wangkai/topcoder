import static java.util.Map.entry;

import java.util.Map;

public class EllysCodeConstants {
  static final String[] SUFFIXES = {"ULL", "LLU", "LL", "UL", "LU", "L", "U"};
  static final Map<Character, Character> SYMBOL_TO_DIGIT =
      Map.ofEntries(
          entry('A', 'A'),
          entry('B', 'B'),
          entry('C', 'C'),
          entry('D', 'D'),
          entry('E', 'E'),
          entry('F', 'F'),
          entry('O', '0'),
          entry('I', '1'),
          entry('Z', '2'),
          entry('S', '5'),
          entry('T', '7'));

  public String getLiteral(String candidate) {
    String suffix = "";
    for (String s : SUFFIXES) {
      if (candidate.endsWith(s)) {
        suffix = s;
        candidate = candidate.substring(0, candidate.length() - s.length());
        if (candidate.isEmpty()) {
          return "";
        }

        break;
      }
    }

    StringBuilder number = new StringBuilder();
    for (char c : candidate.toCharArray()) {
      if (!SYMBOL_TO_DIGIT.containsKey(c)) {
        return "";
      }

      number.append(SYMBOL_TO_DIGIT.get(c));
    }

    return String.format("0x%s%s", number.toString(), suffix);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    EllysCodeConstants obj;
    String answer;
    obj = new EllysCodeConstants();
    long startTime = System.currentTimeMillis();
    answer = obj.getLiteral(p0);
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
    p0 = "DEADBEEF";
    p1 = "0xDEADBEEF";
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "BABACECA";
    p1 = "0xBABACECA";
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "TOPCODER";
    p1 = "";
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "FLU";
    p1 = "0xFLU";
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "FULL";
    p1 = "0xFULL";
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "FALL";
    p1 = "0xFALL";
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = "TASTEFUL";
    p1 = "0x7A57EFUL";
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
    // ------------------

    // ----- test 7 -----
    p0 = "OFFICIAL";
    p1 = "0x0FF1C1AL";
    all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
    // ------------------

    // ----- test 8 -----
    p0 = "OOZE";
    p1 = "0x002E";
    all_right = KawigiEdit_RunTest(8, p0, true, p1) && all_right;
    // ------------------

    // ----- test 9 -----
    p0 = "ESPRIT";
    p1 = "";
    all_right = KawigiEdit_RunTest(9, p0, true, p1) && all_right;
    // ------------------

    // ----- test 10 -----
    p0 = "COOL";
    p1 = "0xC00L";
    all_right = KawigiEdit_RunTest(10, p0, true, p1) && all_right;
    // ------------------

    // ----- test 11 -----
    p0 = "DISEASE";
    p1 = "0xD15EA5E";
    all_right = KawigiEdit_RunTest(11, p0, true, p1) && all_right;
    // ------------------

    // ----- test 12 -----
    p0 = "SOLVED";
    p1 = "";
    all_right = KawigiEdit_RunTest(12, p0, true, p1) && all_right;
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
