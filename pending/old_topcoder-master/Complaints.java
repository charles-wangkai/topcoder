public class Complaints {
	public int howMany(int[] line) {
		int count=0;
		for (int i=0;i<line.length;i++) {
			for (int j=i+1;j<line.length;j++) {
				if (line[i]<line[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
