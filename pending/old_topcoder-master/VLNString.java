public class VLNString {
	public String makeAcronym(String longName) {
		String acronym = "";
		String fields[] = longName.split(" ");
		for (String field : fields) {
			if (!field.equals("") && !field.equals("and")
					&& !field.equals("the") && !field.equals("of")) {
				acronym += Character.toUpperCase(field.charAt(0));
			}
		}
		return acronym;
	}
}
