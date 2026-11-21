public class RockStar {
	public int getNumSongs(int ff, int fs, int sf, int ss) {
		int songNum = 0;
		boolean fastOrSlow = ff > 0 || fs > 0;
		while (true) {
			if (fastOrSlow) {
				if (ff > 0) {
					songNum += ff;
					ff = 0;
				} else if (fs > 0) {
					songNum++;
					fs--;
					fastOrSlow = false;
				} else {
					break;
				}
			} else {
				if (ss > 0) {
					songNum += ss;
					ss = 0;
				} else if (sf > 0) {
					songNum++;
					sf--;
					fastOrSlow = true;
				} else {
					break;
				}
			}
		}
		return songNum;
	}
}
