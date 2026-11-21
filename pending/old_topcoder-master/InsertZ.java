public class InsertZ {
	public String canTransform(String init, String goal) {
		return goal
				.chars()
				.filter(ch -> ch != 'z')
				.mapToObj(x -> (char) x)
				.collect(StringBuilder::new, StringBuilder::append,
						StringBuilder::append).toString().equals(init) ? "Yes"
				: "No";
	}
}
