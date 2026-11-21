import java.util.ArrayList;

public class Undo {
	public String getText(String[] commands, int[] time) {
		ArrayList<CommandNTime> cts = new ArrayList<CommandNTime>();
		for (int i = 0; i < commands.length; i++) {
			cts.add(new CommandNTime(commands[i], time[i]));
		}
		for (int i = cts.size() - 1; i >= 0; i--) {
			CommandNTime ct = cts.get(i);
			if (ct.command.startsWith("undo")) {
				int undoSecond = Integer
						.parseInt(getCommandArgument(ct.command));
				while (i > 0 && cts.get(i - 1).time + undoSecond >= ct.time) {
					cts.remove(i - 1);
					i--;
				}
				cts.remove(i);
			}
		}
		String text = "";
		for (CommandNTime ct : cts) {
			text += getCommandArgument(ct.command);
		}
		return text;
	}

	String getCommandArgument(String command) {
		return command.split(" ")[1];
	}
}

class CommandNTime {
	String command;
	int time;

	public CommandNTime(String command, int time) {
		this.command = command;
		this.time = time;
	}
}