public class StringTrain {
  public String buildTrain(String[] cars) {
    String train = cars[0];
    for (int i = 1; i < cars.length; ++i) {
      for (int j = Math.min(train.length() - 1, cars[i].length() - 1); j >= 1; --j) {
        if (train.endsWith(cars[i].substring(0, j))) {
          train += cars[i].substring(j);

          break;
        }
      }
    }

    return String.format("%d %s", train.length(), remove(train));
  }

  String remove(String s) {
    String removal = "";
    for (int i = s.length() - 1; i >= 0; --i) {
      char c = s.charAt(i);
      if (removal.indexOf(c) == -1) {
        removal += c;
      }
    }

    return new StringBuilder(removal).reverse().toString();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, boolean hasAnswer, String p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    StringTrain obj;
    String answer;
    obj = new StringTrain();
    long startTime = System.currentTimeMillis();
    answer = obj.buildTrain(p0);
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

    String[] p0;
    String p1;

    // ----- test 0 -----
    p0 = new String[] {"ABCDE", "CDFFF", "CDE", "CDEGG", "GABC"};
    p1 = "10 DEGABC";
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"AAAAA", "AAAAA", "AAAAA"};
    p1 = "7 A";
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"CABABDABAB", "CABAB", "ABABDABAB", "DABAB"};
    p1 = "15 CDAB";
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"ABABAB", "ABABAB", "ABABABAB", "BZZZZZ"};
    p1 = "15 ABZ";
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new String[] {"A", "A", "A", "AA"};
    p1 = "1 A";
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
