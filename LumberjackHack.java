import java.util.Arrays;
import java.util.PriorityQueue;

public class LumberjackHack {
	static int[] R_OFFSETS = { -1, 0, 1, 0 };
	static int[] C_OFFSETS = { 0, 1, 0, -1 };

	public int timeToShore(String[] riverMap) {
		int row = riverMap.length;
		int col = riverMap[0].length();

		boolean[][] map = new boolean[row][col];
		int startR = -1;
		int startC = -1;
		for (int r = 0; r < row; ++r) {
			for (int c = 0; c < col; ++c) {
				map[r][c] = riverMap[r].charAt(c) != '.';

				if (riverMap[r].charAt(c) == '+') {
					startR = r;
					startC = c;
				}
			}
		}

		int[][] dryDistances = new int[row][col];
		int[][] wetDistances = new int[row][col];
		for (int r = 0; r < row; ++r) {
			Arrays.fill(dryDistances[r], Integer.MAX_VALUE);
			Arrays.fill(wetDistances[r], Integer.MAX_VALUE);
		}

		PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.distance, e2.distance));
		pq.offer(new Element(startR, startC, false, 0));
		while (!pq.isEmpty()) {
			Element head = pq.poll();

			int[][] distances = head.wet ? wetDistances : dryDistances;
			if (head.distance >= distances[head.r][head.c]) {
				continue;
			}
			distances[head.r][head.c] = head.distance;

			for (int i = 0; i < R_OFFSETS.length; ++i) {
				int adjR = head.r + R_OFFSETS[i];
				int adjC = head.c + C_OFFSETS[i];

				if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col) {
					if (map[adjR][adjC]) {
						pq.offer(new Element(adjR, adjC, head.wet, head.distance + (i % 2 == 0 ? 1 : 2)));
					} else if (!head.wet) {
						pq.offer(new Element(adjR, adjC, true, head.distance + 3));
					}
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for (int r = 0; r < row; ++r) {
			if (dryDistances[r][0] != Integer.MAX_VALUE) {
				result = Math.min(result, dryDistances[r][0]);
			}
			if (dryDistances[r][col - 1] != Integer.MAX_VALUE) {
				result = Math.min(result, dryDistances[r][col - 1]);
			}
			if (wetDistances[r][0] != Integer.MAX_VALUE) {
				result = Math.min(result, wetDistances[r][0]);
			}
			if (wetDistances[r][col - 1] != Integer.MAX_VALUE) {
				result = Math.min(result, wetDistances[r][col - 1]);
			}
		}

		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	class Element {
		int r;
		int c;
		boolean wet;
		int distance;

		Element(int r, int c, boolean wet, int distance) {
			this.r = r;
			this.c = c;
			this.wet = wet;
			this.distance = distance;
		}
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		LumberjackHack obj;
		int answer;
		obj = new LumberjackHack();
		long startTime = System.currentTimeMillis();
		answer = obj.timeToShore(p0);
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

		String[] p0;
		int p1;

		// ----- test 0 -----
		p0 = new String[] { ".+.", "||." };
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "..+", "||." };
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "....|||", "....|..", "...||..", "||.+...", "...|...", "...||||" };
		p1 = 7;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "||.|....", "........", ".|.+|..|", "...|....", "|..|.|.|" };
		p1 = -1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { ".........|.|.|.|.|..||...||.|..|.||...|.|.|||...||",
				".||.||...||..|||.....|.||||...|.|.|.|.|..|...|.|||",
				"||.|.|..||.||....|.....|.||.|||||.|.|.||.|||||.|..",
				"|.....|.|.||||.||..|.|..|..|.|||||.....||.|.||....",
				"..|..||...||.|.......|||+||.||||....||||.....|..||",
				"...||..||||.|......||..|.|||||.|.|||||.||..|||...|",
				"|||...|..|..|.|||.||.|..|...||.|||..|..||.|.||....",
				"|..|||||||||.||.....|..|.|.|||||...||...|.|.|||||.",
				".|..||...|||............|.|..|||.||.|||.||..||.|||",
				".|.|||...||..|..|...||.||..|..|||||.|.|...||..||.|",
				"||||.|||.|..||||..|..||...|..||.|.||||...|...|.|..",
				".||..||...|.....|||.|||||..||......|.||.||.|..||..",
				"|.|||....|||||.|..|..|.|||..|.||.||.|.|.|.|..||...",
				".||.||||||...||||||..||....|..||.|||..||...|.|||||",
				".||||.|....|...|.||..||..|||.|||||....|...||.|.||.",
				".|...|..||....||...|.||||.....||||.||.|||||||..|||",
				".||||...|...|..||...|...|...|.|..|.|.|..|..|||.||.",
				".|.|||..||||||||........|||||||||.|.|........|||||",
				".....|...||.||...|||...||||..|||...||....||..|" + "|.||",
				"||...||..||.||...||...||||..|.|..|...|||..||..|||.",
				"|..||||.||..|...|....||||||...|||.|.|||||..|||...|",
				".....|||..||.|||.....||..||||...|||||.||.|.||..|||",
				"|..|.||..|..||..||..|...|..|.||..||||..|...||..|..",
				"||.|..|.|||||...|...|.|..|||||...|.......|.||.||||",
				".|.....|.|||||.....|||...|..|||||...|.||..||.|||.|",
				".|...||....|||...|||.||.|.|......|........|.||||||",
				"..|.|.|.|||||..|||..|.........|...|.|.|...||.....|",
				".|.|.|.|..|.|||||||||||.|.|||....|||||...|.||||.|.",
				"|.|||....|.||||..||......|..|||||.....||.|..||..|.",
				"||.||.|||.|......|..|.|...|..||.|||..||.....|.|..|",
				".||||..|.|.||||.|||.||.||.....|....|....||...|..||",
				".....|||...||.||.||....|.||..||....|....|||||.|..|",
				"|.|.|||||...|.||..|..|..|.|..|.|........||..|.|.||",
				"....|..|.|..|.||||||....||||.|.||||||.|.|.|.......",
				"||||....|..|...||..||||||||...|.|||||.|.|||.|...||",
				"|...|.|..|..|..|....|..||..|||....||..||..|..|..|.",
				"|||||....|.||.|..|.||..|||..|.|.|..||.|...|.|..||.",
				"..|.|||.|.||..|...|||.|..|||..||...||..." + "||||.....|",
				"..||||.|.|.....|||..||||..|.||||..|..|||.....||.||",
				"|..|||||....|........|.||||.||..||||.|....|||||||.",
				".|...||.|.||..|.|....|.||..|.|....|.|.||.||.||.|..",
				".|..|..|.||||.||||....|||.....|.|...|.|...|...||..",
				"|..|||..|.||.|||..||.....|.|..|.|.|...|.....|.....",
				"||..||.|...|.||...|..|..||.|||.||.|.||...|....|||.",
				".|....|.|||.|..|||..|.....|.||.||...|...||.......|",
				".||..|||.|.|....|||...|..|.||.||.|.|...|||||.|.|.|",
				"|.|.||.||.|.|.||.|||.||....||.|||||.||.|.|||......",
				"|...|||...|.||||....|.||.||.|.........|..||.|..||.",
				".|.....|.|.|....||.||...|||.|..||...||.|||.||.|.|.",
				"||.||.|||.|||..||......|......||..||||.|..||.||||." };
		p1 = 63;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] { ".+." };
		p1 = 3;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = new String[] { "..+.." };
		p1 = -1;
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
