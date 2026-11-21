public class ChessCover {
	int row;
	int column;
	char board[][];
	public int getSafe(String[] boardLayout) {
		row=boardLayout.length;
		column=boardLayout[0].length();
		board=new char[row][column];
		for (int i=0;i<row;i++) {
			for (int j=0;j<column;j++) {
				board[i][j]=boardLayout[i].charAt(j);
			}
		}
		for (int i=0;i<row;i++) {
			for (int j=0;j<column;j++) {
				if (board[i][j]=='Q') {
					attack(i,j,new int[]{-1,-1,0,1,1,1,0,-1},new int[]{0,1,1,1,0,-1,-1,-1},true);
				}
				else if (board[i][j]=='R') {
					attack(i,j,new int[]{-1,0,1,0},new int[]{0,1,0,-1},true);
				}
				else if (board[i][j]=='B') {
					attack(i,j,new int[]{-1,1,1,-1},new int[]{1,1,-1,-1},true);
				}
				else if (board[i][j]=='K') {
					attack(i,j,new int[]{-2,-1,1,2,2,1,-1,-2},new int[]{1,2,2,1,-1,-2,-2,-1},false);
				}
				else if (board[i][j]=='P') {
					attack(i,j,new int[]{-1,1,1,-1},new int[]{1,1,-1,-1},false);
				}
			}
		}
		int count=0;
		for (int i=0;i<row;i++) {
			for (int j=0;j<column;j++) {
				if (board[i][j]=='U') {
					count++;
				}
			}
		}
		return count;
	}
	
	void attack(int x,int y, int offsetX[],int offsetY[],boolean extend) {
		for (int i=0;i<offsetX.length;i++) {
			int tempX=x;
			int tempY=y;
			do {
				tempX+=offsetX[i];
				tempY+=offsetY[i];
				if (tempX<0 || tempX>=row || tempY<0 || tempY>=column || (board[tempX][tempY]!='U' && board[tempX][tempY]!='X')) {
					break;
				}
				board[tempX][tempY]='X';
			} while(extend);
		}
	}
}
