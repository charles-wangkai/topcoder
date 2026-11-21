import java.util.ArrayList;

public class RelativePath {
	public String makeRelative(String path, String currentDir) {
		ArrayList<String> pathParts = convertToParts(path);
		ArrayList<String> currentDirParts = convertToParts(currentDir);
		while (!pathParts.isEmpty() && !currentDirParts.isEmpty()
				&& pathParts.get(0).equals(currentDirParts.get(0))) {
			pathParts.remove(0);
			currentDirParts.remove(0);
		}
		String relative = "";
		for (int i = 0; i < currentDirParts.size(); i++) {
			relative = appendToPath(relative, "..");
		}
		for (String part : pathParts) {
			relative = appendToPath(relative, part);
		}
		return relative;
	}

	ArrayList<String> convertToParts(String path) {
		ArrayList<String> parts = new ArrayList<String>();
		for (String part : path.split("/")) {
			if (!part.equals("")) {
				parts.add(part);
			}
		}
		return parts;
	}

	String appendToPath(String path, String part) {
		return path + (path.equals("") ? "" : "/") + part;
	}
}
