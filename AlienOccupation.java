import java.util.HashSet;
import java.util.Set;

public class AlienOccupation {
  public int[] getInfo(int N, int A, int[] X, int[] Y) {
    boolean[] visited = new boolean[N];
    visited[A] = true;
    Set<Integer> bases = Set.of(A);
    int T = 1;
    int U = 0;
    int V = 0;

    while (true) {
      Set<Integer> nextBases = new HashSet<>();
      for (int base : bases) {
        for (int i = 0; i < X.length; ++i) {
          int nextBase = (int) (((long) X[i] * base + Y[i]) % N);
          if (!visited[nextBase]) {
            visited[nextBase] = true;
            nextBases.add(nextBase);
          }
        }
      }

      if (nextBases.isEmpty()) {
        break;
      }

      T += nextBases.size();
      ++U;
      V = Math.max(V, nextBases.size());

      bases = nextBases;
    }

    return new int[] {T, U, V};
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, int[] p2, int[] p3, boolean hasAnswer, int[] p4) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
    for (int i = 0; p2.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p2[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p3.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p3[i]);
    }
    System.out.print("}");
    System.out.println("]");
    AlienOccupation obj;
    int[] answer;
    obj = new AlienOccupation();
    long startTime = System.currentTimeMillis();
    answer = obj.getInfo(p0, p1, p2, p3);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p4.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p4[i]);
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(answer[i]);
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p4.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p4[i]) {
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
    int p1;
    int[] p2;
    int[] p3;
    int[] p4;

    // ----- test 0 -----
    p0 = 7;
    p1 = 4;
    p2 = new int[] {1};
    p3 = new int[] {1};
    p4 = new int[] {7, 6, 1};
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 100;
    p1 = 47;
    p2 = new int[] {2, 14, 14};
    p3 = new int[] {10, 2, 4};
    p4 = new int[] {51, 5, 20};
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 100;
    p1 = 47;
    p2 = new int[] {1, 11};
    p3 = new int[] {0, 30};
    p4 = new int[] {1, 0, 0};
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 123456;
    p1 = 0;
    p2 = new int[] {3, 4, 55555};
    p3 = new int[] {6, 7, 88888};
    p4 = new int[] {123456, 20, 18004};
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 230;
    p1 = 23;
    p2 = new int[] {2, 2};
    p3 = new int[] {0, 0};
    p4 = new int[] {5, 4, 1};
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
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
