public class TroytownKeeper {
    static int row;
    static int column;
    static int grid[][];
    static int offsetX[]={-1,0,1,0};
    static int offsetY[]={0,1,0,-1};
    public static int limeLiters(String[] maze) {
        row=maze.length;
        column=maze[0].length();
        grid=new int[row][column];
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (maze[i].charAt(j)=='.') {
                    grid[i][j]=-1;
                }
                else {
                    grid[i][j]=0;
                }
            }
        }
        for (int i=0;i<column;i++) {
            if (grid[0][i]==-1) {
                grid[0][i]=1;
                DFS(0,i);
            }
            if (grid[row-1][i]==-1) {
                grid[row-1][i]=1;
                DFS(row-1,i);
            }
        }
        for (int i=0;i<row;i++) {
            if (grid[i][0]==-1) {
                grid[i][0]=1;
                DFS(i,0);
            }
            if (grid[i][column-1]==-1) {
                grid[i][column-1]=1;
                DFS(i,column-1);
            }
        }
        int paint=0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (grid[i][j]==0) {
                    for (int k=0;k<4;k++) {
                        int x=i+offsetX[k];
                        int y=j+offsetY[k];
                        if (isInside(x,y)==false || grid[x][y]==1) {
                            paint++;
                        }
                    }
                }
            }
        }
        return paint;
    }

    static boolean isInside(int x,int y) {
        if (x>=0 && x<row && y>=0 && y<column) {
            return true;
        }
        else {
            return false;
        }
    }

    static void DFS(int x,int y) {
        for (int i=0;i<4;i++) {
            int newX=x+offsetX[i];
            int newY=y+offsetY[i];
            if (isInside(newX,newY)==true && grid[newX][newY]==-1) {
                grid[newX][newY]=1;
                DFS(newX,newY);
            }
        }
    }
}
