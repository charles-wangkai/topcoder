import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UserName {
  public String newMember(String[] existingNames, String newName) {
    Set<String> taken = Arrays.stream(existingNames).collect(Collectors.toSet());

    for (int i = 0; ; ++i) {
      String name = String.format("%s%s", newName, (i == 0) ? "" : String.valueOf(i));
      if (!taken.contains(name)) {
        return name;
      }
    }
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String[] p0, String p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}" + "," + "\"" + p1 + "\"");
    System.out.println("]");
    UserName obj;
    String answer;
    obj = new UserName();
    long startTime = System.currentTimeMillis();
    answer = obj.newMember(p0, p1);
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
    String p1;
    String p2;

    // ----- test 0 -----
    p0 = new String[] {"MasterOfDisaster", "DingBat", "Orpheus", "WolfMan", "MrKnowItAll"};
    p1 = "TygerTyger";
    p2 = "TygerTyger";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 =
        new String[] {
          "MasterOfDisaster",
          "TygerTyger1",
          "DingBat",
          "Orpheus",
          "TygerTyger",
          "WolfMan",
          "MrKnowItAll"
        };
    p1 = "TygerTyger";
    p2 = "TygerTyger2";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 =
        new String[] {
          "TygerTyger2000",
          "TygerTyger1",
          "MasterDisaster",
          "DingBat",
          "Orpheus",
          "WolfMan",
          "MrKnowItAll"
        };
    p1 = "TygerTyger";
    p2 = "TygerTyger";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 =
        new String[] {
          "grokster2",
          "BrownEyedBoy",
          "Yoop",
          "BlueEyedGirl",
          "grokster",
          "Elemental",
          "NightShade",
          "Grokster1"
        };
    p1 = "grokster";
    p2 = "grokster1";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 =
        new String[] {
          "Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10", "Lisa", "Marge", "Homer",
          "Bart", "Bart1", "Bart2", "Bart3", "Bart11", "Bart12"
        };
    p1 = "Bart";
    p2 = "Bart13";
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
