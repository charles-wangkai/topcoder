public class Flags {
	public long numStripes(String numFlags, String[] forbidden) {
		long flagNumber=Long.parseLong(numFlags);
		int colorNumber=forbidden.length;
		if (flagNumber<=colorNumber) {
			return 1;
		}
		flagNumber-=colorNumber;
		int possibles[][]=new int[colorNumber][];
		boolean moreThanOne=false;
		for (int i=0;i<colorNumber;i++) {
			String str[]=forbidden[i].split(" ");
			possibles[i]=new int[colorNumber-str.length];
			if (possibles[i].length>1) {
				moreThanOne=true;
			}
			int pos1=0;
			int pos2=0;
			for (int j=0;j<colorNumber;j++) {
				if (pos2<str.length && Integer.parseInt(str[pos2])==j) {
					pos2++;
				}
				else {
					possibles[i][pos1]=j;
					pos1++;
				}
			}
		}
		if (moreThanOne==false) {
			int count=0;
			for (int i=0;i<colorNumber;i++) {
				if (possibles[i].length==1) {
					count++;
				}
			}
			return ((flagNumber%count==0)?(flagNumber/count):(flagNumber/count+1))+1;
		}
		else {
			long numbers[]=new long[colorNumber];
			for (int i=0;i<colorNumber;i++) {
				numbers[i]=1;
			}
			long result=1;
			while (true) {
				long temp[]=new long[colorNumber];
				for (int i=0;i<colorNumber;i++) {
					for (int j=0;j<possibles[i].length;j++) {
						temp[i]+=numbers[possibles[i][j]];
						if (temp[i]>1E17) {
							return result+1;
						}
					}
					if (flagNumber<=temp[i]) {
						return result+1;
					}
					flagNumber-=temp[i];
				}
				numbers=temp;
				result++;
			}
		}
	}
}
