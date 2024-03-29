import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Animation {
  public String[] animate(int speed, String init) {
    Set<Integer> leftIndices =
        IntStream.range(0, init.length())
            .filter(i -> init.charAt(i) == 'L')
            .boxed()
            .collect(Collectors.toSet());
    Set<Integer> rightIndices =
        IntStream.range(0, init.length())
            .filter(i -> init.charAt(i) == 'R')
            .boxed()
            .collect(Collectors.toSet());
    List<String> result = new ArrayList<>();
    while (true) {
      Set<Integer> leftIndices_ = leftIndices;
      Set<Integer> rightIndices_ = rightIndices;
      result.add(
          IntStream.range(0, init.length())
              .mapToObj(i -> (leftIndices_.contains(i) || rightIndices_.contains(i)) ? "X" : ".")
              .collect(Collectors.joining()));

      if (leftIndices.isEmpty() && rightIndices.isEmpty()) {
        break;
      }

      leftIndices =
          leftIndices.stream()
              .map(leftIndex -> leftIndex - speed)
              .filter(leftIndex -> leftIndex >= 0)
              .collect(Collectors.toSet());
      rightIndices =
          rightIndices.stream()
              .map(rightIndex -> rightIndex + speed)
              .filter(rightIndex -> rightIndex < init.length())
              .collect(Collectors.toSet());
    }

    return result.toArray(new String[0]);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, int p0, String p1, boolean hasAnswer, String[] p2) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + "\"" + p1 + "\"");
    System.out.println("]");
    Animation obj;
    String[] answer;
    obj = new Animation();
    long startTime = System.currentTimeMillis();
    answer = obj.animate(p0, p1);
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
    String p1;
    String[] p2;

    // ----- test 0 -----
    p0 = 2;
    p1 = "..R....";
    p2 = new String[] {"..X....", "....X..", "......X", "......."};
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 3;
    p1 = "RR..LRL";
    p2 = new String[] {"XX..XXX", ".X.XX..", "X.....X", "......."};
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 2;
    p1 = "LRLR.LRLR";
    p2 = new String[] {"XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", "........."};
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 10;
    p1 = "RLRLRLRLRL";
    p2 = new String[] {"XXXXXXXXXX", ".........."};
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = 1;
    p1 = "...";
    p2 = new String[] {"..."};
    all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = 1;
    p1 = "LRRL.LR.LRR.R.LRRL.";
    p2 =
        new String[] {
          "XXXX.XX.XXX.X.XXXX.",
          "..XXX..X..XX.X..XX.",
          ".X.XX.X.X..XX.XX.XX",
          "X.X.XX...X.XXXXX..X",
          ".X..XXX...X..XX.X..",
          "X..X..XX.X.XX.XX.X.",
          "..X....XX..XX..XX.X",
          ".X.....XXXX..X..XX.",
          "X.....X..XX...X..XX",
          ".....X..X.XX...X..X",
          "....X..X...XX...X..",
          "...X..X.....XX...X.",
          "..X..X.......XX...X",
          ".X..X.........XX...",
          "X..X...........XX..",
          "..X.............XX.",
          ".X...............XX",
          "X.................X",
          "..................."
        };
    all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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
