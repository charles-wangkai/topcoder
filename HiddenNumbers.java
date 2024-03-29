import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiddenNumbers {
  public String[] findAll(String[] text) {
    List<String> numbers = new ArrayList<>();
    Matcher m = Pattern.compile("\\d+").matcher(String.join("", text));
    while (m.find()) {
      numbers.add(m.group());
    }

    Collections.sort(
        numbers,
        Comparator.comparing((String n) -> Long.parseLong(n)).thenComparing(String::length));

    return numbers.subList(numbers.size() / 2, numbers.size()).toArray(String[]::new);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, boolean hasAnswer, String[] p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    HiddenNumbers obj;
    String[] answer;
    obj = new HiddenNumbers();
    long startTime = System.currentTimeMillis();
    answer = obj.findAll(p0);
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

    String[] p0;
    String[] p1;

    // ----- test 0 -----
    p0 =
        new String[] {
          "098m03r9f80239802389f0m9KDKLKLJDKLJm0983m890DMOm03",
          "dlkfj3hljf4h3klhl  4j4 444 44  rjhkrrkr34534539893",
          " 390804980498409480 dkldjkl djkl djkl d00000002998"
        };
    p1 =
        new String[] {
          "9",
          "44",
          "098",
          "444",
          "890",
          "0983",
          "00000002998",
          "34534539893",
          "80239802389",
          "390804980498409480"
        };
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 =
        new String[] {
          "39 000220 30 skldjdije939939slkk 3090 2912kjdk3949",
          "dlkjd dkljsl098 dkd3 23kdkdkl 0000002222kdjdie9000"
        };
    p1 = new String[] {"0000002222", "2912", "3090", "3949", "9000", "939939"};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {};
    p1 = new String[] {};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"0022 22k00022a022"};
    p1 = new String[] {"0022", "00022"};
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
