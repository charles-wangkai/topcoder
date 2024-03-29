import java.util.stream.Collectors;

public class CCipher {
  public String decode(String cipherText, int shift) {
    return cipherText
        .chars()
        .mapToObj(c -> (char) (Math.floorMod(c - 'A' - shift, 26) + 'A'))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, int p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1);
    System.out.println("]");
    CCipher obj;
    String answer;
    obj = new CCipher();
    long startTime = System.currentTimeMillis();
    answer = obj.decode(p0, p1);
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
    p0 = "VQREQFGT";
    p1 = 2;
    p2 = "TOPCODER";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    p1 = 10;
    p2 = "QRSTUVWXYZABCDEFGHIJKLMNOP";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "TOPCODER";
    p1 = 0;
    p2 = "TOPCODER";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "ZWBGLZ";
    p1 = 25;
    p2 = "AXCHMA";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "DBNPCBQ";
    p1 = 1;
    p2 = "CAMOBAP";
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "LIPPSASVPH";
    p1 = 4;
    p2 = "HELLOWORLD";
    all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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
