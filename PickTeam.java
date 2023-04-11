import java.util.stream.IntStream;

public class PickTeam {
  public String[] pickPeople(int teamSize, String[] people) {
    int peopleNum = people.length;

    String[] names = new String[peopleNum];
    int[][] scores = new int[peopleNum][peopleNum];
    for (int i = 0; i < peopleNum; ++i) {
      String[] parts = people[i].split(" ");
      names[i] = parts[0];
      for (int j = 0; j < peopleNum; ++j) {
        scores[i][j] = Integer.parseInt(parts[j + 1]);
      }
    }

    int maxSum = Integer.MIN_VALUE;
    String[] result = null;
    for (int mask = 0; mask < (1 << peopleNum); ++mask) {
      if (Integer.bitCount(mask) == teamSize) {
        int sum = 0;
        for (int i = 0; i < peopleNum; ++i) {
          if (((mask >> i) & 1) == 1) {
            for (int j = i + 1; j < peopleNum; ++j) {
              if (((mask >> j) & 1) == 1) {
                sum += scores[i][j];
              }
            }
          }
        }

        if (sum > maxSum) {
          maxSum = sum;

          int mask_ = mask;
          result =
              IntStream.range(0, peopleNum)
                  .filter(i -> ((mask_ >> i) & 1) == 1)
                  .mapToObj(i -> names[i])
                  .sorted()
                  .toArray(String[]::new);
        }
      }
    }

    return result;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, String[] p1, boolean hasAnswer, String[] p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p1[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    PickTeam obj;
    String[] answer;
    obj = new PickTeam();
    long startTime = System.currentTimeMillis();
    answer = obj.pickPeople(p0, p1);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p2.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print("\"" + p2[i] + "\"");
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
      if (answer.length != p2.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (!answer[i].equals(p2[i])) {
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

    int p0;
    String[] p1;
    String[] p2;

    // ----- test 0 -----
    p0 = 3;
    p1 = new String[] {"ALICE 0 1 -1 3", "BOB 1 0 2 -4", "CAROL -1 2 0 2", "DAVID 3 -4 2 0"};
    p2 = new String[] {"ALICE", "CAROL", "DAVID"};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 2;
    p1 = new String[] {"ALICE 0 1 -1 3", "BOB 1 0 2 -4", "CAROL -1 2 0 2", "DAVID 3 -4 2 0"};
    p2 = new String[] {"ALICE", "DAVID"};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 2;
    p1 = new String[] {"A 0 -2 -2", "B -2 0 -1", "C -2 -1 0"};
    p2 = new String[] {"B", "C"};
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 13;
    p1 =
        new String[] {
          "A 0 2 8 7 1 -4 -3 1 8 2 8 2 1 -3 7 1 3 9 -6 -5",
          "A 2 0 0 7 -7 -5 8 -8 -9 -9 6 -9 -4 -8 8 1 7 0 3 3",
          "A 8 0 0 -5 -5 -7 1 -3 1 9 -6 6 1 5 6 -9 8 6 -8 -8",
          "A 7 7 -5 0 7 -5 3 9 8 3 -6 -5 -5 2 -6 2 -2 -1 -2 8",
          "B 1 -7 -5 7 0 7 -2 -9 3 7 0 -2 1 1 -9 -3 -2 2 1 -2",
          "B -4 -5 -7 -5 7 0 4 8 6 0 -1 4 1 -2 -9 4 0 -7 6 -2",
          "B -3 8 1 3 -2 4 0 8 -1 1 -2 -7 5 0 -6 9 0 -3 1 3",
          "B 1 -8 -3 9 -9 8 8 0 0 -2 5 0 5 8 3 5 2 4 5 4",
          "C 8 -9 1 8 3 6 -1 0 0 8 -3 8 -6 -4 7 -4 1 -5 5 4",
          "C 2 -9 9 3 7 0 1 -2 8 0 -9 -6 6 5 -8 -3 -8 2 2 4",
          "C 8 6 -6 -6 0 -1 -2 5 -3 -9 0 2 7 8 2 -6 -4 -6 4 4",
          "C 2 -9 6 -5 -2 4 -7 0 8 -6 2 0 0 -3 6 7 -1 2 -4 -2",
          "D 1 -4 1 -5 1 1 5 5 -6 6 7 0 0 -7 -4 8 -6 -3 4 -6",
          "D -3 -8 5 2 1 -2 0 8 -4 5 8 -3 -7 0 7 -3 5 -8 5 1",
          "D 7 8 6 -6 -9 -9 -6 3 7 -8 2 6 -4 7 0 9 -5 -5 -8 3",
          "D 1 1 -9 2 -3 4 9 5 -4 -3 -6 7 8 -3 9 0 -2 -7 8 -7",
          "E 3 7 8 -2 -2 0 0 2 1 -8 -4 -1 -6 5 -5 -2 0 6 0 5",
          "E 9 0 6 -1 2 -7 -3 4 -5 2 -6 2 -3 -8 -5 -7 6 0 4 8",
          "E -6 3 -8 -2 1 6 1 5 5 2 4 -4 4 5 -8 8 0 4 0 1",
          "E -5 3 -8 8 -2 -2" + " 3 4 4 4 4 -2 -6 1 3 -7 5 8 1 0"
        };
    p2 = new String[] {"A", "A", "B", "B", "B", "B", "C", "C", "C", "D", "D", "D", "E"};
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
