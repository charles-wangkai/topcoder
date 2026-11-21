public class PrintScheduler {
	public String getOutput(String[] threads, String[] slices) {
		String output = "";
		int indices[] = new int[threads.length];
		for (String slice : slices) {
			String fields[] = slice.split(" ");
			int thread = Integer.parseInt(fields[0]);
			int time = Integer.parseInt(fields[1]);
			for (int i = 0; i < time; i++) {
				output += threads[thread].charAt(indices[thread]);
				indices[thread] = (indices[thread] + 1)
						% threads[thread].length();
			}
		}
		return output;
	}
}
