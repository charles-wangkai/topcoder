public class FolderSize {
	public int[] calculateWaste(String[] files, int folderCount, int clusterSize) {
		int wastes[] = new int[folderCount];
		for (String file : files) {
			String fields[] = file.split(" ");
			int folder = Integer.parseInt(fields[0]);
			int size = Integer.parseInt(fields[1]);
			wastes[folder] += (clusterSize - size % clusterSize) % clusterSize;
		}
		return wastes;
	}
}
