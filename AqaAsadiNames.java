public class AqaAsadiNames {
	public String getName(String Dad, String Mom, String FirstChild, String Gender) {
		String parentWithSameGender = Gender.equals("Boy") ? Dad : Mom;

		String firstName;
		String lastName;
		if ("AEIOUY".indexOf(FirstChild.charAt(0)) >= 0 == Gender.equals("Girl")) {
			firstName = parentWithSameGender.split(" ")[0];
			lastName = FirstChild.split(" ")[1];
		} else {
			firstName = parentWithSameGender.split(" ")[1];
			lastName = parentWithSameGender.split(" ")[0];
		}

		return String.format("%s %s", firstName, lastName);
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, String p2, String p3,
			boolean hasAnswer, String p4) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"" + "," + "\"" + p2 + "\""
				+ "," + "\"" + p3 + "\"");
		System.out.println("]");
		AqaAsadiNames obj;
		String answer;
		obj = new AqaAsadiNames();
		long startTime = System.currentTimeMillis();
		answer = obj.getName(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p4 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p4);
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
		String p3;
		String p4;

		// ----- test 0 -----
		p0 = "Mohammad Reza";
		p1 = "Yasaman Sadat";
		p2 = "Baqer Ali";
		p3 = "Boy";
		p4 = "Mohammad Ali";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "Mohammad Reza";
		p1 = "Yasaman Sadat";
		p2 = "Baqer Ali";
		p3 = "Girl";
		p4 = "Sadat Yasaman";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "Mohammad Reza";
		p1 = "Yasaman Sadat";
		p2 = "Umi Kulsum";
		p3 = "Girl";
		p4 = "Yasaman Kulsum";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "Mohammad Reza";
		p1 = "Yasaman Sadat";
		p2 = "Umi Kulsum";
		p3 = "Boy";
		p4 = "Reza Mohammad";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "Mohammad Ali";
		p1 = "Yasaman Sadat";
		p2 = "Mohammad Reza";
		p3 = "Boy";
		p4 = "Mohammad Reza";
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "Dhikrullah Ali";
		p1 = "Umi Kulsum";
		p2 = "Reza Hosseinzadeh";
		p3 = "Boy";
		p4 = "Dhikrullah Hosseinzadeh";
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
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
