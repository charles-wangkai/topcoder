public class Checkers {
	boolean board[][];
	int min;

	public int compute(String startPos, String[] pieces) {
		board = new boolean[8][8];
		for (int i=0;i<pieces.length;i++) {
			int x=pieces[i].charAt(0)-'0';
			int y=pieces[i].charAt(2)-'0';
			board[x][y]=true;
		}
		min=-1;
		search(startPos.charAt(0)-'0',startPos.charAt(2)-'0',0,false);
		return min;
	}
	
	void search(int x,int y,int step,boolean jump) {
		if (y==7) {
			if (min==-1 || step<min) {
				min=step;
			}
		}
		else {
			if (x>=1) {
				if (board[x-1][y+1]==false) {
					search(x-1,y+1,step+1,false);
				}
				else if (x>=2 && y<=5 && board[x-2][y+2]==false) {
					if (jump==true) {
						search(x-2,y+2,step,true);
					}
					else {
						search(x-2,y+2,step+1,true);
					}
				}
			}
			if (x<=6) {
				if (board[x+1][y+1]==false) {
					search(x+1,y+1,step+1,false);
				}
				else if (x<=5 && y<=5 && board[x+2][y+2]==false) {
					if (jump==true) {
						search(x+2,y+2,step,true);
					}
					else {
						search(x+2,y+2,step+1,true);
					}
				}
			}
		}
	}
}
