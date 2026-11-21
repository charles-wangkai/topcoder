import java.util.HashMap;

public class Stamp {
    HashMap<Index_PrevColor, Integer> cache;

    public int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
        int minCost = Integer.MAX_VALUE;
        for (int stampLen = 1; stampLen <= desiredColor.length(); stampLen++) {
            cache = new HashMap<Index_PrevColor, Integer>();
            int pushCount = getPushCount(desiredColor, stampLen, 0, (char) -1);
            if (pushCount != Integer.MAX_VALUE) {
                int cost = stampLen * stampCost + pushCount * pushCost;
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    int getPushCount(String desiredColor, int stampLen, int index,
            char prevColor) {
        if (index == desiredColor.length()) {
            return 0;
        }

        Index_PrevColor ip = new Index_PrevColor(index, prevColor);
        if (cache.containsKey(ip)) {
            return cache.get(ip);
        }

        int pushCount = Integer.MAX_VALUE;
        char[] colors = { 'R', 'G', 'B' };
        for (int startIndex = Math.max(index - stampLen + 1, 0); startIndex <= index
                && startIndex + stampLen <= desiredColor.length(); startIndex++) {
            for (char color : colors) {
                if (isValid(desiredColor, startIndex,
                        startIndex + stampLen - 1, index, prevColor, color)) {
                    int nextPushCount = getPushCount(desiredColor, stampLen,
                            startIndex + stampLen, color);
                    if (nextPushCount != Integer.MAX_VALUE) {
                        pushCount = Math.min(pushCount, nextPushCount + 1);
                    }
                }
            }
        }
        cache.put(ip, pushCount);
        return pushCount;
    }

    boolean isValid(String desiredColor, int startIndex, int endIndex,
            int index, char prevColor, char curColor) {
        if (startIndex < index && prevColor != curColor) {
            return false;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            if (!isColorMatched(desiredColor.charAt(i), curColor)) {
                return false;
            }
        }
        return true;
    }

    boolean isColorMatched(char color1, char color2) {
        return color1 == '*' || color2 == '*' || color1 == color2;
    }
}

class Index_PrevColor {
    int index;
    char prevColor;

    Index_PrevColor(int index, char prevColor) {
        this.index = index;
        this.prevColor = prevColor;
    }

    @Override
    public int hashCode() {
        return index * prevColor;
    }

    @Override
    public boolean equals(Object obj) {
        Index_PrevColor other = (Index_PrevColor) obj;
        return index == other.index && prevColor == other.prevColor;
    }
}