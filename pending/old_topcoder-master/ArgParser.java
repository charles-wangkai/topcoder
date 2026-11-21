import java.util.ArrayList;

public class ArgParser {
	public String[] parse(String input) {
		ArrayList<String> result = new ArrayList<String>();
		boolean valid=true;
		int length=input.length();
		if (length<2 || input.charAt(0)!='{' || input.charAt(length-1)!='}') {
			valid=false;
		}
		else {
			StringBuffer temp=new StringBuffer();
			int pos=1;
			while (pos<=length-2) {
				char ch=input.charAt(pos);
				if (ch==',') {
					if (pos+1>length-2 || input.charAt(pos+1)!=' ') {
						valid=false;
						break;
					}
					result.add(temp.toString());
					temp=new StringBuffer();
					pos+=2;
				}
				else if (ch=='\\') {
					if (pos+1<=length-2) {
						char ch1=input.charAt(pos+1);
						if (ch1==',' || ch1=='{' || ch1=='}') {
							temp.append(ch1);
							pos+=2;
						}
						else {
							temp.append('\\');
							pos++;
						}
					}
					else {
						temp.append('\\');
						pos++;
					}
				}
				else if (ch=='{' || ch=='}') {
					valid=false;
					break;
				}
				else {
					temp.append(ch);
					pos++;
				}
			}
			if (valid) {
				if (temp.toString().endsWith("\\")) {
					valid=false;
				}
				else {
					result.add(temp.toString());
				}
			}
		}
		if (valid) {
			return result.toArray(new String[0]);
		}
		else {
			return new String[]{"INVALID"};
		}
	}
}
