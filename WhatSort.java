import java.util.Arrays;
import java.util.stream.IntStream;

public class WhatSort {
  static final String[] ORDERS = {"NAW", "NWA", "ANW", "AWN", "WAN", "WNA"};

  public String sortType(String[] name, int[] age, int[] wt) {
    String[] candidates =
        Arrays.stream(ORDERS)
            .filter(
                order -> {
                  int[] sortedIndices =
                      IntStream.range(0, name.length)
                          .boxed()
                          .sorted(
                              (i1, i2) -> {
                                for (char c : order.toCharArray()) {
                                  if (c == 'N') {
                                    if (!name[i1].equals(name[i2])) {
                                      return name[i1].compareTo(name[i2]);
                                    }
                                  } else if (c == 'A') {
                                    if (age[i1] != age[i2]) {
                                      return Integer.compare(age[i1], age[i2]);
                                    }
                                  } else {
                                    if (wt[i1] != wt[i2]) {
                                      return -Integer.compare(wt[i1], wt[i2]);
                                    }
                                  }
                                }

                                return 0;
                              })
                          .mapToInt(Integer::intValue)
                          .toArray();

                  return IntStream.range(0, sortedIndices.length)
                      .allMatch(
                          i ->
                              name[sortedIndices[i]].equals(name[i])
                                  && age[sortedIndices[i]] == age[i]
                                  && wt[sortedIndices[i]] == wt[i]);
                })
            .toArray(String[]::new);

    if (candidates.length == 0) {
      return "NOT";
    }
    if (candidates.length >= 2) {
      return "IND";
    }

    return candidates[0];
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, int[] p1, int[] p2, boolean hasAnswer, String p3) {
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
      System.out.print(p1[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p2.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p2[i]);
    }
    System.out.print("}");
    System.out.println("]");
    WhatSort obj;
    String answer;
    obj = new WhatSort();
    long startTime = System.currentTimeMillis();
    answer = obj.sortType(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + "\"" + p3 + "\"");
    }
    System.out.println("Your answer:");
    System.out.println("\t" + "\"" + answer + "\"");
    if (hasAnswer) {
      res = answer.equals(p3);
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
    int[] p1;
    int[] p2;
    String p3;

    // ----- test 0 -----
    p0 = new String[] {"BOB", "BOB", "DAVE", "JOE"};
    p1 = new int[] {22, 35, 35, 30};
    p2 = new int[] {122, 122, 195, 200};
    p3 = "IND";
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"BOB", "BOB", "DAVE", "DAVE"};
    p1 = new int[] {22, 35, 35, 30};
    p2 = new int[] {122, 122, 195, 200};
    p3 = "NOT";
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[] {"BOB", "BOB", "DAVE", "DAVE"};
    p1 = new int[] {22, 35, 35, 30};
    p2 = new int[] {122, 122, 195, 190};
    p3 = "NWA";
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
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
