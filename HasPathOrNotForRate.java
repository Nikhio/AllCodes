
public class HasPathOrNotForRate {
    public static boolean solveMaze(int maze[][],int path[][],int i,int j) {
    	//check cell is valid or not
    	int n=maze.length;
    	if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
    		return false;
    	}
    	path[i][j]=1;
    	if(i==n-1 && j==n-1) {
    		return true;
    	}
    	//top
    	if(solveMaze(maze, path, i-1, j)) {
    		return  true;
    	}
    	//right
    	if(solveMaze(maze, path, i, j+1)) {
    		return  true;
    	}
    	//left
    	if(solveMaze(maze, path, i, j-1)) {
    		return  true;
    	}
    	//down
    	if(solveMaze(maze, path, i+1, j)) {
    		return  true;
    	}
    	return false;
    }
	public static boolean ratInMaze(int maze[][],int n) {
    	int path[][]=new int[n][n];
    	return solveMaze(maze,path,0,0);
    }
	public static void main(String[] args) {
	int maze[][]= {{1,1,0},{1,1,1},{1,1,1}};
	boolean ans=ratInMaze(maze,maze.length);
	System.out.println(ans);
	}

}
