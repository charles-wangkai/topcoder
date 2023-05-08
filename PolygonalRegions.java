import java.math.BigInteger;
import java.util.stream.IntStream;

public class PolygonalRegions {
  static final int MODULUS = 1_000_000_007;

  public int expectedRegions(int N) {
    int allBadProb = 1;
    int[][][] badFirstProbs = new int[N + 1][N + 1][N + 1];
    int[][][] goodFirstProbs = new int[N + 1][N + 1][N + 1];

    int modInvN = BigInteger.valueOf(N).modInverse(BigInteger.valueOf(MODULUS)).intValue();

    for (int v = 1; v <= N; ++v) {
      int badProb = multiplyMod(N - v, modInvN);
      int goodProb = multiplyMod(v, modInvN);

      int[][][] nextBadFirstProbs = new int[N + 1][N + 1][N + 1];
      int[][][] nextGoodFirstProbs = new int[N + 1][N + 1][N + 1];

      for (int k = 1; k < v; ++k) {
        nextBadFirstProbs[1][0][k] = multiplyMod(badFirstProbs[1][0][k], badProb);
        nextGoodFirstProbs[1][0][k] = multiplyMod(goodFirstProbs[1][0][k], badProb);
      }

      if (v == 1) {
        nextGoodFirstProbs[1][0][v] = multiplyMod(allBadProb, goodProb);
      } else {
        nextBadFirstProbs[1][0][v] = multiplyMod(allBadProb, goodProb);
      }

      for (int i = 2; i <= v; ++i) {
        for (int j = 0; j <= v; ++j) {
          for (int k = i; k < v; ++k) {
            nextBadFirstProbs[i][j][k] = multiplyMod(badFirstProbs[i][j][k], badProb);
            nextGoodFirstProbs[i][j][k] = multiplyMod(goodFirstProbs[i][j][k], badProb);
          }

          for (int p = 1; p < v; ++p) {
            int prevJ = j - ((p == v - 1) ? 0 : 1);

            if (prevJ >= 0) {
              nextBadFirstProbs[i][j][v] =
                  addMod(
                      nextBadFirstProbs[i][j][v],
                      multiplyMod(badFirstProbs[i - 1][prevJ][p], goodProb));
              nextGoodFirstProbs[i][j][v] =
                  addMod(
                      nextGoodFirstProbs[i][j][v],
                      multiplyMod(goodFirstProbs[i - 1][prevJ][p], goodProb));
            }
          }
        }
      }

      allBadProb = multiplyMod(allBadProb, badProb);

      badFirstProbs = nextBadFirstProbs;
      goodFirstProbs = nextGoodFirstProbs;
    }

    int[] regionNums = buildRegionNums(N);

    int result = allBadProb;
    for (int i = 1; i <= N; ++i) {
      for (int j = 0; j <= N; ++j) {
        for (int k = 1; k <= N; ++k) {
          result = addMod(result, multiplyMod(regionNums[i] + j + 1, badFirstProbs[i][j][k]));
          result =
              addMod(
                  result,
                  multiplyMod(regionNums[i] + j + (k == N ? 0 : 1), goodFirstProbs[i][j][k]));
        }
      }
    }

    return result;
  }

  int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  // http://oeis.org/A006522
  int[] buildRegionNums(int N) {
    return IntStream.rangeClosed(0, N)
        .map(n -> (n * n * n * n - 6 * n * n * n + 23 * n * n - 42 * n + 24) / 24)
        .toArray();
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + p0);
    System.out.println("]");
    PolygonalRegions obj;
    int answer;
    obj = new PolygonalRegions();
    long startTime = System.currentTimeMillis();
    answer = obj.expectedRegions(p0);
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
      res = answer == p1;
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

    // ----- test 0 -----
    p0 = 3;
    p1 = 1;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 4;
    p1 = 31250002;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 10;
    p1 = 346100029;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 100;
    all_right = KawigiEdit_RunTest(3, p0, false, p1) && all_right;
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
