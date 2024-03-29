import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Orchard {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public int[] nextTree(String[] orchard) {
    int n = orchard.length;

    int[][] distances = new int[n + 2][n + 2];
    for (int r = 0; r < distances.length; ++r) {
      Arrays.fill(distances[r], -1);
    }

    Queue<Point> queue = new ArrayDeque<>();
    for (int r = 0; r < distances.length; ++r) {
      for (int c = 0; c < distances[r].length; ++c) {
        if (r == 0 || r == n + 1 || c == 0 || c == n + 1 || orchard[r - 1].charAt(c - 1) == 'T') {
          distances[r][c] = 0;
          queue.offer(new Point(r, c));
        }
      }
    }
    while (!queue.isEmpty()) {
      Point head = queue.poll();
      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r + R_OFFSETS[i];
        int adjC = head.c + C_OFFSETS[i];
        if (adjR >= 1 && adjR <= n && adjC >= 1 && adjC <= n && distances[adjR][adjC] == -1) {
          distances[adjR][adjC] = distances[head.r][head.c] + 1;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    int maxDistance = -1;
    int resultR = -1;
    int resultC = -1;
    for (int r = 1; r <= n; ++r) {
      for (int c = 1; c <= n; ++c) {
        if (distances[r][c] > maxDistance) {
          maxDistance = distances[r][c];
          resultR = r;
          resultC = c;
        }
      }
    }

    return new int[] {resultR, resultC};
  }

  class Point {
    int r;
    int c;

    Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int[] p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    Orchard obj;
    int[] answer;
    obj = new Orchard();
    long startTime = System.currentTimeMillis();
    answer = obj.nextTree(p0);
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
        System.out.print(p1[i]);
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
      if (answer.length != p1.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p1[i]) {
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
    int[] p1;

    // ----- test 0 -----
    p0 = new String[] {"----", "T---", "----", "----"};
    p1 = new int[] {2, 3};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[] {"---T--", "------", "------", "----T-", "------", "------"};
    p1 = new int[] {3, 3};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 =
        new String[] {
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------",
          "------------"
        };
    p1 = new int[] {6, 6};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new String[] {"-T----T", "T---T--", "-----TT", "---TT--", "T-----T", "-------", "T-T--T-"};
    p1 = new int[] {2, 3};
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
