public class BracketMaze {
	char cells[][][];
	int paths[][][][];
	public int properPaths(String[] maze, int N) {
		String str="";
		for (int i=0;i<maze.length;i++) {
			str+=maze[i];
		}
		cells=new char[N][N][N];
		paths=new int[N][N][N][N*3+1];
		int pos=0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				for (int k=0;k<N;k++) {
					cells[i][j][k]=str.charAt(pos);
					pos++;
					for (int p=0;p<paths[0][0][0].length;p++) {
						paths[i][j][k][p]=-2;
					}
				}
			}
		}
		return search(N-1,N-1,N-1,0);
	}
	
	int search(int x,int y,int z,int rest) {
		if (paths[x][y][z][rest]!=-2) {
			return paths[x][y][z][rest];
		}
		char cell=cells[x][y][z];
		int newRest;
		if (cell=='.') {
			newRest=rest;
		}
		else if (cell=='(') {
			newRest=rest-1;
		}
		else {
			newRest=rest+1;
		}
		if (newRest<0) {
			return 0;
		}
		if (x==0 && y==0 && z==0 && newRest==0) {
			return 1;
		}
		paths[x][y][z][rest]=0;
		if (x>=1) {
			int temp=search(x-1,y,z,newRest);
			if (temp==-1) {
				return -1;
			}
			paths[x][y][z][rest]+=temp;
			if (paths[x][y][z][rest]>1E9) {
				return -1;
			}
		}
		if (y>=1) {
			int temp=search(x,y-1,z,newRest);
			if (temp==-1) {
				return -1;
			}
			paths[x][y][z][rest]+=temp;
			if (paths[x][y][z][rest]>1E9) {
				return -1;
			}
		}
		if (z>=1) {
			int temp=search(x,y,z-1,newRest);
			if (temp==-1) {
				return -1;
			}
			paths[x][y][z][rest]+=temp;
			if (paths[x][y][z][rest]>1E9) {
				return -1;
			}
		}
		return paths[x][y][z][rest];
	}
}
