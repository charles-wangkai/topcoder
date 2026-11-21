public class Wizarding {
	int max = -1;
	String result;

	public String counterspell(String spell, String rules) {
		search(spell, rules, 0, 1, "");
		return result;
	}

	void search(String spell, String rules, int index, int score, String str) {
		if (index == spell.length()) {
			if (str.length()>0 && (max == -1
					|| score > max
					|| (score == max && (str.length() < result.length() || (str
							.length() == result.length() && str
							.compareTo(result) < 0))))) {
				max=score;
				result = str;
			}
		}
		else {
			search(spell,rules,index+1,score,str);
			char ch=spell.charAt(index);
			search(spell,rules,index+1,score*(ch-'A'+1)%77077,str+ch);
			ch=rules.charAt(spell.charAt(index)-'A');
			if (ch!='-') {
				search(spell,rules,index+1,score*(ch-'A'+1)%77077,str+ch);
			}
		}
	}
}
