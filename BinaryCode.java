import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryCode {
  public String[] decode(String message) {
    return new String[] {decodeWith(message, 0), decodeWith(message, 1)};
  }

  String decodeWith(String message, int first) {
    int[] digits = new int[message.length()];
    digits[0] = first;
    for (int i = 1; i < digits.length; ++i) {
      digits[i] = message.charAt(i - 1) - '0' - digits[i - 1] - ((i == 1) ? 0 : digits[i - 2]);
    }

    return (Arrays.stream(digits).anyMatch(digit -> digit != 0 && digit != 1)
            || (digits.length == 1 && message.charAt(0) - '0' != digits[0])
            || (digits.length >= 2
                && message.charAt(message.length() - 1) - '0'
                    != digits[digits.length - 2] + digits[digits.length - 1]))
        ? "NONE"
        : Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining());
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, boolean hasAnswer, String[] p1) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
    System.out.println("]");
    BinaryCode obj;
    String[] answer;
    obj = new BinaryCode();
    long startTime = System.currentTimeMillis();
    answer = obj.decode(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p1.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print("\"" + p1[i] + "\"");
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + answer[i] + "\"");
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p1.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (!answer[i].equals(p1[i])) {
            res = false;
          }
        }
      }
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
    String[] p1;

    // ----- test 0 -----
    p0 = "123210122";
    p1 = new String[] {"011100011", "NONE"};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "11";
    p1 = new String[] {"01", "10"};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "22111";
    p1 = new String[] {"NONE", "11001"};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "123210120";
    p1 = new String[] {"NONE", "NONE"};
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "3";
    p1 = new String[] {"NONE", "NONE"};
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = "12221112222221112221111111112221111";
    p1 =
        new String[] {"01101001101101001101001001001101001", "10110010110110010110010010010110010"};
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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
