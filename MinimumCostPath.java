public class MinimumCostPath {
	//	Memoization-->
	public static int minimumCostPathM(int arr[][]){
		int m=arr.length;
		int n=arr[0].length;
		int storage[][]=new int [m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				storage[i][j]=-1;
			}
		}
		return minCostPathM(arr,0,0,storage);
	}
	private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
		int m=arr.length;
		int n=arr[0].length;
		if(i==m-1 && j==n-1) {
			storage[i][j]=arr[i][j];
			return storage[i][j];
		}
		if(i>=m || j>=n) {
			return Integer.MAX_VALUE;
		}
		if(storage[i][j]!=-1) {
			return storage[i][j];
		}
		int op1=minCostPathM(arr,i+1,j,storage);
		int op2=minCostPathM(arr,i,j+1,storage);
		int op3=minCostPathM(arr,i+1,j+1,storage);
		storage[i][j]=arr[i][j]+Math.min(op1, Math.min(op2, op3));
		return storage[i][j];
	}
	//DP-->
	public static int minCostPathDP(int arr[][]) {
		int m=arr.length;
		int n=arr[0].length;
		int storage[][]=new int[m][n];
		storage[m-1][n-1]=arr[m-1][n-1];
		//Last Row will filled first because it can be filled with the help of arr[m-1][n-1]
		for(int j=n-2;j>=0;j--) {
			storage[m-1][j]=arr[m-1][j]+storage[m-1][j+1];
		}
		//Last Column will filled  because it can be filled with the help of arr[m-1][n-1]
		for(int i=m-2;i>=0;i--) {
			storage[i][n-1]=arr[i][n-1]+storage[i+1][n-1];
		}
		//Left over is filled in the right to left fashion
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				storage[i][j]=arr[i][j]+Math.min(storage[i+1][j], Math.min(storage[i][j+1], storage[i+1][j+1]));
			}
		}
		return storage[0][0];
	}
	public static void main(String[] args) {
		//		int arr[][]= {{1,2,3,4},
		//				{3,4,5,6},
		//				{7,3,5,66},
		//				{1222,3,4,5},
		//				{123,34,55,66}};
		//		System.out.println(minCostPathDP(arr));
		//		System.out.println(minimumCostPathM(arr));
		
	}

}
