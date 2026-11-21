public class FormatAmt {
	public String amount(int dollars, int cents) {
		String result="$";
		String dollarStr=dollars+"";
		for (int i=0;i<dollarStr.length();i++) {
			result+=dollarStr.charAt(i);
			if (i!=dollarStr.length()-1 && (dollarStr.length()-1-i)%3==0) {
				result+=",";
			}
		}
		result+=".";
		if (cents<10) {
			result+="0"+cents;
		}
		else {
			result+=cents;
		}
		return result;
	}
}
