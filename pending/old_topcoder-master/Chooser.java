public class Chooser {
	public int numSets(int[] easy, int[] middle, int[] hard) {
		int count=0;
		for (int i=0;i<easy.length;i++) {
			for (int j=0;j<middle.length;j++) {
				for (int k=0;k<hard.length;k++) {
					int time=easy[i]+middle[j]+hard[k];
					if (time>=60 && time<=75) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
