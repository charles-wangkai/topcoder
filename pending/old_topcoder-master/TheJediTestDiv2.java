public class TheJediTestDiv2 {
	public int countSupervisors(int[] students, int Y, int J) {
		int minJediNum = Integer.MAX_VALUE;
		for (int i = 0; i < students.length; i++) {
			students[i] -= Y;

			int jediNum = 0;
			for (int j = 0; j < students.length; j++) {
				if (students[j] >= 0) {
					jediNum += divideToCeil(students[j], J);
				}
			}
			minJediNum = Math.min(minJediNum, jediNum);

			students[i] += Y;
		}
		return minJediNum;
	}

	int divideToCeil(int a, int b) {
		return a / b + (a % b == 0 ? 0 : 1);
	}
}
