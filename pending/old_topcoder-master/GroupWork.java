import java.util.Arrays;

public class GroupWork {
	public long bestGroup(int[] p, int[] s) {
		Group groups[] = new Group[p.length];
		for (int i = 0; i < groups.length; i++) {
			groups[i] = new Group(p[i], s[i]);
		}
		Arrays.sort(groups);
		long totalPeople = 0;
		for (Group group : groups) {
			totalPeople += group.peopleNum;
		}
		long maxProductivity = 0;
		for (Group group : groups) {
			maxProductivity = Math.max(maxProductivity, totalPeople
					* group.skill);
			totalPeople -= group.peopleNum;
		}
		return maxProductivity;
	}
}

class Group implements Comparable<Group> {
	long peopleNum;
	int skill;

	public Group(long peopleNum, int skill) {
		this.peopleNum = peopleNum;
		this.skill = skill;
	}

	public int compareTo(Group other) {
		return skill - other.skill;
	}
}