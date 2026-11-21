public class GForce {
	int x[];
	int y[];
	double slopes[];

	public double avgAccel(int period, int[] accel, int[] time) {
		x = time;
		y = accel;
		int segmentNum = accel.length - 1;
		slopes = new double[segmentNum];
		for (int i = 0; i < slopes.length; i++) {
			slopes[i] = (double) (accel[i + 1] - accel[i])
					/ (time[i + 1] - time[i]);
		}
		int startSeg = 0;
		double start = time[0];
		int endSeg = 0;
		double end = time[0];
		double area = 0;
		while (end - start < period) {
			if (time[endSeg + 1] - start <= period) {
				area += (accel[endSeg + 1] + calcY(endSeg, end))
						* (time[endSeg + 1] - end) / 2;
				end = time[endSeg + 1];
				endSeg++;
			} else {
				double temp = start + period;
				area += (calcY(endSeg, end) + calcY(endSeg, temp))
						* (temp - end) / 2;
				end = temp;
			}
		}
		double max = area;
		while (end < time[segmentNum]) {
			double X = solveX(start, calcY(startSeg, start), slopes[startSeg],
					start, calcY(endSeg, end), slopes[endSeg]);
			double offset;
			if (X > start && X < time[startSeg + 1] && X + period > end
					&& X + period < time[endSeg + 1]) {
				offset = X - start;
			} else {
				offset = Math.min(time[startSeg + 1] - start, time[endSeg + 1]
						- end);
			}
			area += (calcY(endSeg, end) + calcY(endSeg, end + offset))
					* offset
					/ 2
					- (calcY(startSeg, start) + calcY(startSeg, start + offset))
					* offset / 2;
			max = Math.max(max, area);
			start += offset;
			if (start == time[startSeg + 1]) {
				startSeg++;
			}
			end += offset;
			if (end == time[endSeg + 1]) {
				endSeg++;
			}
		}
		return max / period;
	}

	double solveX(double x0, double y0, double k0, double x1, double y1,
			double k1) {
		if (k0 == k1) {
			return -1;
		}
		return (k0 * x0 - k1 * x1 - y0 + y1) / (k0 - k1);
	}

	double calcY(int segIndex, double X) {
		return y[segIndex] + slopes[segIndex] * (X - x[segIndex]);
	}
}
