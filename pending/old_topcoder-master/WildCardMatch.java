public class WildCardMatch {
	public int minimalChanges(String file, String pattern) {
		int min[][]=new int[file.length()+1][pattern.length()+1];
		for (int i=0;i<=pattern.length();i++) {
			min[0][i]=i;
		}
		for (int i=0;i<=file.length();i++) {
			min[i][0]=i;
		}
		for (int i=1;i<=file.length();i++) {
			for (int j=1;j<=pattern.length();j++) {
				min[i][j]=Integer.MAX_VALUE;
				char ch1=file.charAt(i-1);
				char ch2=pattern.charAt(j-1);
				if (ch1==ch2 || ch2=='?') {
					min[i][j]=Math.min(min[i][j], min[i-1][j-1]);
				}
				else {
					min[i][j]=Math.min(min[i][j], min[i-1][j-1]+1);
				}
				min[i][j]=Math.min(min[i][j], min[i-1][j]+1);
				min[i][j]=Math.min(min[i][j], min[i][j-1]+1);
			}
		}
		return min[file.length()][pattern.length()];
	}
}
