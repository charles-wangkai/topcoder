public class DigitalDisplay {
	public int waysToInterpret(String display) {
		int orders[][]={{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
		int numbers[]=new int[3];
		for (int i=0;i<3;i++) {
			numbers[i]=Integer.parseInt(display.substring(i*3, i*3+2));
		}
		int way=0;
		for (int i=0;i<orders.length;i++) {
			if (check(numbers[orders[i][0]],numbers[orders[i][1]],numbers[orders[i][2]])) {
				way++;
			}
		}
		return way;
	}
	
	boolean check(int hour,int minute,int second) {
		if (hour>=1 && hour<=12 && minute>=0 && minute<=59 && second>=0 && second<=59) {
			return true;
		}
		else {
			return false;
		}
	}
}
