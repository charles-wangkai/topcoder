public class EllysDirectoryListing {
	public String[] getFiles(String[] files) {
		int pos[] = new int[2];
		int index = 0;
		for (int i = 0; i < files.length; i++) {
			if (files[i].equals(".") || files[i].equals("..")) {
				pos[index] = i;
				index++;
			}
		}
		if (pos[0] < files.length - 2) {
			swap(files, pos[0], files.length - 1);
			if (pos[1] == files.length - 1) {
				swap(files, pos[0], files.length - 2);
			} else {
				swap(files, pos[1], files.length - 2);
			}
		}
		return files;
	}

	void swap(String[] files, int index1, int index2) {
		String temp = files[index1];
		files[index1] = files[index2];
		files[index2] = temp;
	}
}
