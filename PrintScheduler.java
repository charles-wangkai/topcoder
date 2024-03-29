public class PrintScheduler {
  public String getOutput(String[] threads, String[] slices) {
    StringBuilder result = new StringBuilder();
    int[] indices = new int[threads.length];
    for (String slice : slices) {
      String[] parts = slice.split(" ");
      int threadIndex = Integer.parseInt(parts[0]);
      int time = Integer.parseInt(parts[1]);

      for (int i = 0; i < time; ++i) {
        result.append(threads[threadIndex].charAt(indices[threadIndex]));
        indices[threadIndex] = (indices[threadIndex] + 1) % threads[threadIndex].length();
      }
    }

    return result.toString();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, String[] p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p1[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    PrintScheduler obj;
    String answer;
    obj = new PrintScheduler();
    long startTime = System.currentTimeMillis();
    answer = obj.getOutput(p0, p1);
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

    String[] p0;
    String[] p1;
    String p2;

    // ----- test 0 -----
    p0 = new String[] {"AB", "CD"};
    p1 = new String[] {"0 1", "1 1", "0 1", "1 2"};
    p2 = "ACBDC";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"ABCDE"};
    p1 = new String[] {"0 20", "0 21"};
    p2 = "ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEA";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"A", "B"};
    p1 = new String[] {"1 10", "0 1", "1 10", "0 2"};
    p2 = "BBBBBBBBBBABBBBBBBBBBAA";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"A"};
    p1 = new String[] {"0 1"};
    p2 = "A";
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
