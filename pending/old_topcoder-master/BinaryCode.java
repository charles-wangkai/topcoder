public class BinaryCode {
	public String[] decode(String message) {
		String results[]=new String[2];
		int length=message.length();
		int digits[]=new int[length];
		for (int i=0;i<2;i++) {
			digits[0]=i;
			results[i]=digits[0]+"";
			for (int j=1;j<length;j++) {
				if (j==1) {
					digits[j]=message.charAt(j-1)-'0'-digits[j-1];
				}
				else {
					digits[j]=message.charAt(j-1)-'0'-digits[j-1]-digits[j-2];
				}
				if (digits[j]!=0 && digits[j]!=1) {
					results[i]="NONE";
					break;
				}
				results[i]+=digits[j];
			}
			if (!results[i].equals("NONE") && ((length==1 && digits[0]!=message.charAt(length-1)-'0') || (length>1 && digits[length-2]+digits[length-1]!=message.charAt(length-1)-'0'))) {
				results[i]="NONE";
			}
		}
		return results;
	}
}
