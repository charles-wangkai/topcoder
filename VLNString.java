import java.util.Arrays;
import java.util.stream.Collectors;

public class VLNString {
  static String[] IGNORED = {"and", "the", "of"};

  public String makeAcronym(String longName) {
    return Arrays.stream(longName.split(" "))
        .filter(part -> !part.isEmpty() && !Arrays.stream(IGNORED).anyMatch(part::equals))
        .map(part -> Character.toUpperCase(part.charAt(0)))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    VLNString obj;
    String answer;
    obj = new VLNString();
    long startTime = System.currentTimeMillis();
    answer = obj.makeAcronym(p0);
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
    p0 = "dance dance revolution";
    p1 = "DDR";
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "  return  of  the king   ";
    p1 = "RK";
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "the united states of america";
    p1 = "USA";
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = " of  the   and    ";
    p1 = "";
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = " ";
    p1 = "";
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
