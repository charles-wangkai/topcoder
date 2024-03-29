import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Harmony {
  static final int SIZE = 3;

  public int[] mostHarmonious(int[] frequencies) {
    List<Chord> chords = new ArrayList<>();
    for (int i = 0; i < frequencies.length; ++i) {
      for (int j = i + 1; j < frequencies.length; ++j) {
        for (int k = j + 1; k < frequencies.length; ++k) {
          chords.add(new Chord(new int[] {frequencies[i], frequencies[j], frequencies[k]}));
        }
      }
    }

    return chords.stream()
        .min(
            (c1, c2) -> {
              for (int i = SIZE - 1; i >= 0; --i) {
                if (c1.denoms[i] != c2.denoms[i]) {
                  return Integer.compare(c1.denoms[i], c2.denoms[i]);
                }
              }

              for (int i = 0; i < SIZE; ++i) {
                if (c1.freqs[i] != c2.freqs[i]) {
                  return Integer.compare(c1.freqs[i], c2.freqs[i]);
                }
              }

              return 0;
            })
        .get()
        .freqs;
  }

  class Chord {
    int[] freqs;
    int[] denoms;

    Chord(int[] freqs) {
      this.freqs = freqs;
      Arrays.sort(freqs);

      denoms =
          IntStream.range(0, freqs.length)
              .map(i -> computeDenominator(freqs[i], freqs[(i + 1) % freqs.length]))
              .sorted()
              .toArray();
    }

    int computeDenominator(int x, int y) {
      return Math.min(x, y) / gcd(x, y);
    }

    int gcd(int x, int y) {
      return (y == 0) ? x : gcd(y, x % y);
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int[] p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}");
    System.out.println("]");
    Harmony obj;
    int[] answer;
    obj = new Harmony();
    long startTime = System.currentTimeMillis();
    answer = obj.mostHarmonious(p0);
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

    int[] p0;
    int[] p1;

    // ----- test 0 -----
    p0 = new int[] {200, 250, 400, 320, 350};
    p1 = new int[] {200, 250, 400};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[] {440, 320, 750, 660, 500, 550};
    p1 = new int[] {440, 550, 660};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[] {1960, 1000, 3050, 2341, 7253, 7864, 2000, 2352, 2940, 1534, 7234};
    p1 = new int[] {1960, 2352, 2940};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[] {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    p1 = new int[] {100, 200, 400};
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
