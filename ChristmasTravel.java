import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChristmasTravel {
  public String[] plan(int N, int A) {
    if (N * (N - 1) / 2 < A || N > (1 << A)) {
      return new String[0];
    }

    int[][] airlines = new int[N][N];
    search(A, airlines, 0, N - 1, 0);

    int[] counts = new int[A];
    int maxAirline = -1;
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        ++counts[airlines[i][j]];
        maxAirline = Math.max(maxAirline, airlines[i][j]);
      }
    }
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        if (maxAirline != A - 1 && counts[airlines[i][j]] != 1) {
          --counts[airlines[i][j]];

          ++maxAirline;
          airlines[i][j] = maxAirline;
          airlines[j][i] = maxAirline;
        }
      }
    }

    return IntStream.range(0, N)
        .mapToObj(
            i ->
                IntStream.range(0, N)
                    .mapToObj(j -> (j == i) ? '-' : (char) ('A' + airlines[i][j]))
                    .map(String::valueOf)
                    .collect(Collectors.joining()))
        .toArray(String[]::new);
  }

  void search(int A, int[][] airlines, int beginIndex, int endIndex, int airline) {
    if (beginIndex == endIndex) {
      return;
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    for (int i = beginIndex; i <= middleIndex; ++i) {
      for (int j = middleIndex + 1; j <= endIndex; ++j) {
        airlines[i][j] = airline;
        airlines[j][i] = airline;
      }
    }

    search(A, airlines, beginIndex, middleIndex, airline + 1);
    search(A, airlines, middleIndex + 1, endIndex, airline + 1);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, int p1, boolean hasAnswer, String[] p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
    System.out.println("]");
    ChristmasTravel obj;
    String[] answer;
    obj = new ChristmasTravel();
    long startTime = System.currentTimeMillis();
    answer = obj.plan(p0, p1);
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
    int p1;
    String[] p2;

    // ----- test 0 -----
    p0 = 3;
    p1 = 1;
    p2 = new String[] {};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 3;
    p1 = 3;
    p2 = new String[] {"-AC", "A-B", "CB-"};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 5;
    p1 = 3;
    p2 = new String[] {"-ABAB", "A-ACC", "BA-AC", "ACA-B", "BCCB-"};
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 1;
    p1 = 1;
    p2 = new String[] {};
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 6;
    p1 = 5;
    p2 = new String[] {"-ACEDB", "A-BDCE", "CB-AED", "EDA-BC", "DCEB-A", "BEDCA-"};
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
