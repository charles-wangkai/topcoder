public class AccessLevel {
	public String canAccess(int[] rights, int minPermission) {
		String access = "";
		for (int right : rights) {
			access += (right >= minPermission) ? "A" : "D";
		}
		return access;
	}
}
