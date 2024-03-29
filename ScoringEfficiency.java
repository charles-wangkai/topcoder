public class ScoringEfficiency {
  public double getPointsPerShot(String[] gameLog) {
    int point = 0;
    int fieldCount = 0;
    int freeCount = 0;
    for (String element : gameLog) {
      if (element.startsWith("Made")) {
        if (element.contains("2")) {
          point += 2;
        } else if (element.contains("3")) {
          point += 3;
        } else {
          ++point;
        }
      }

      if (element.contains("field")) {
        ++fieldCount;
      } else {
        ++freeCount;
      }
    }

    return point / (fieldCount + 0.5 * freeCount);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, boolean hasAnswer, double p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    ScoringEfficiency obj;
    double answer;
    obj = new ScoringEfficiency();
    long startTime = System.currentTimeMillis();
    answer = obj.getPointsPerShot(p0);
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
      res = Math.abs(p1 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p1));
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
    double p1;

    // ----- test 0 -----
    p0 = new String[] {"Made 3 point field goal", "Missed 2 point field goal"};
    p1 = 1.5D;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 =
        new String[] {
          "Made free throw",
          "Missed free throw",
          "Missed free throw",
          "Missed free throw",
          "Made free throw"
        };
    p1 = 0.8D;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 =
        new String[] {
          "Made 2 point field goal",
          "Made 2 point field goal",
          "Made 2 point field goal",
          "Made 2 point field goal",
          "Missed 2 point field goal",
          "Made 3 point field goal",
          "Made 3 point field goal",
          "Made 3 point field goal",
          "Missed 3 point field goal",
          "Missed 3 point field goal",
          "Missed 3 point field goal",
          "Missed 3 point field goal",
          "Made free throw",
          "Made free throw",
          "Made free throw",
          "Made free throw",
          "Made free throw",
          "Made free throw",
          "Made free throw",
          "Missed free throw",
          "Missed free throw"
        };
    p1 = 1.4545454545454546D;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 =
        new String[] {
          "Made 2 point field goal",
          "Missed free throw",
          "Made free throw",
          "Missed free throw",
          "Made free throw",
          "Made 2 point field goal",
          "Made 2 point field goal",
          "Missed 2 point field goal",
          "Missed 2 point field goal",
          "Made 3 point field goal",
          "Missed 2 point field goal",
          "Made 2 point field goal",
          "Missed 2 point field goal",
          "Made 3 point field goal",
          "Missed 2 point field goal",
          "Missed 2 point field goal",
          "Missed 3 point field goal",
          "Made free throw",
          "Made free throw",
          "Missed 3 point field goal",
          "Missed 2 point field goal",
          "Missed 2 point field goal",
          "Made 2 point field goal",
          "Missed 2 point field goal",
          "Made 2 point field goal",
          "Missed 3 point field goal"
        };
    p1 = 0.9565217391304348D;
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
