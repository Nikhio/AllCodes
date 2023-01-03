
public class NQueenProblem {
	public static void PlaceNQueen(int n) {
		int visited[][]=new int[n][n];
		queenHelper(visited,n,0);
	}
	public static void queenHelper(int visited[][],int n,int row) {
		if(row==n) {
			System.out.println();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(visited[i][j]+" ");
				}
				System.out.println();
			}
			//    		System.out.println();

		}
		for(int c=0;c<n;c++) {
			if(isItSafe(n,visited,row,c)) {
				visited[row][c]=1;
				queenHelper(visited,n,row+1);
				visited[row][c]=0;
			}
		}
	}
	public static boolean isItSafe(int n,int visited[][],int r,int c) {
		//vertical
		for(int i=r-1,j=c; i>=0 && c<n;i--) {
			if(visited[i][j]==1) {
				return false;
			}
		}
		//left Diagonal
		for(int i=r-1,j=c-1 ; i>=0 && j>=0 ;i--,j--) {
			if(visited[i][j]==1) {
				return false;
			}
		}
		//right Diagonal
		for(int i=r-1,j=c+1; i>=0 && j<n;i--,j++) {
			if(visited[i][j]==1) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
//		int n=20;
//		PlaceNQueen(n);
        String s="abcd@e";
        String arr[]=s.split("@");
        for(int i=0;i<arr.length;i++) {
        	System.out.println(arr[i]+" ");
        }
        //String split method break a sentance into words jaisa humlog cheta hai space ka baad 
//        break ho to " " pass karna hoga
//        System.out.println(s.substring(3, 5));
	}

}
