import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Uptime {
  public String calcUptime(String started, String now) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM y 'at' h:m:s a");
    long seconds =
        Duration.between(
                LocalDateTime.parse(started, formatter), LocalDateTime.parse(now, formatter))
            .getSeconds();

    List<String> parts = new ArrayList<>();

    long d = seconds / 86400;
    if (d != 0) {
      parts.add(String.format("%dd", d));
    }

    long h = seconds % 86400 / 3600;
    if (h != 0) {
      parts.add(String.format("%dh", h));
    }

    long m = seconds % 3600 / 60;
    if (m != 0) {
      parts.add(String.format("%dm", m));
    }

    long s = seconds % 60;
    if (s != 0) {
      parts.add(String.format("%ds", s));
    }

    return String.join(" ", parts);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(
      int testNum, String p0, String p1, boolean hasAnswer, String p2) {
    System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
    System.out.println("]");
    Uptime obj;
    String answer;
    obj = new Uptime();
    long startTime = System.currentTimeMillis();
    answer = obj.calcUptime(p0, p1);
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

    String p0;
    String p1;
    String p2;

    // ----- test 0 -----
    p0 = "7 Jun 2004 at 04:41:32 PM";
    p1 = "8 Jun 2004 at 07:16:28 PM";
    p2 = "1d 2h 34m 56s";
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = "7 Jun 2004 at 04:41:32 PM";
    p1 = "7 Jun 2004 at 04:41:32 PM";
    p2 = "";
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = "28 Feb 2004 at 01:23:45 PM";
    p1 = "1 Mar 2004 at 12:34:56 AM";
    p2 = "1d 11h 11m 11s";
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = "28 Feb 2005 at 01:23:45 PM";
    p1 = "1 Jan 2015 at 12:34:56 AM";
    p2 = "3593d 11h 11m 11s";
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = "25 Jan 1922 at 05:58:52 AM";
    p1 = "26 Feb 2190 at 11:53:14 AM";
    p2 = "97918d 5h 54m 22s";
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
