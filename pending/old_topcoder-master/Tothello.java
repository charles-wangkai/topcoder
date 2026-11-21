import java.util.ArrayList;

public class Tothello {
    static int grid[][];

    public static int bestMove(String[] redPieces, String[] blackPieces, String whoseTurn) {
        grid=new int[8][8];
        int sign;
        if (whoseTurn.equals("Red")==true) {
            sign=1;
        }
        else {
            sign=-1;
        }
        for (int i=0;i<redPieces.length;i++) {
            int r=redPieces[i].charAt(1)-'1';
            int c=redPieces[i].charAt(0)-'A';
            grid[r][c]=sign;
        }
        for (int i=0;i<blackPieces.length;i++) {
            int r=blackPieces[i].charAt(1)-'1';
            int c=blackPieces[i].charAt(0)-'A';
            grid[r][c]=-sign;
        }
        int already=0;
        int added=0;
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (grid[i][j]==1) {
                    already++;
                }
                else if (grid[i][j]==0) {
                    int count=change(i,j);
                    if (count>added) {
                        added=count;
                    }
                }
            }
        }
        return already+added;
    }

    static int change(int row,int column) {
        int added=1;
        ArrayList<Square> squares=new ArrayList<Square>();
        grid[row][column]=1;
        squares.add(new Square(row,column));
        for (int i=0;i<squares.size();i++) {
            Square square=squares.get(i);
            int offsetX[]={-1,-1,0,1,1,1,0,-1};
            int offsetY[]={0,1,1,1,0,-1,-1,-1};
            for (int j=0;j<8;j++) {
                int tempX=square.x+offsetX[j];
                int tempY=square.y+offsetY[j];
                while (tempX>=0 && tempX<8 && tempY>=0 && tempY<8 && grid[tempX][tempY]==-1) {
                    tempX+=offsetX[j];
                    tempY+=offsetY[j];
                }
                if (tempX>=0 && tempX<8 && tempY>=0 && tempY<8 && grid[tempX][tempY]==1) {
                    int x=square.x+offsetX[j];
                    int y=square.y+offsetY[j];
                    while (x!=tempX || y!=tempY) {
                        grid[x][y]=1;
                        squares.add(new Square(x,y));
                        x+=offsetX[j];
                        y+=offsetY[j];
                        added++;
                    }
                }
            }
        }
        for (int i=1;i<squares.size();i++) {
            Square square=squares.get(i);
            grid[square.x][square.y]=-1;
        }
        grid[row][column]=0;
        return added;
    }

    static class Square {
        int x;
        int y;

        public Square(int X,int Y) {
            this.x=X;
            this.y=Y;
        }
    }
}
