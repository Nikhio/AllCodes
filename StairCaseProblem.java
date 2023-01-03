public class StairCaseProblem {
	public static int ways(int n) {
		if(n==0) {
			return 1;
		}
		else if(n<0) {
			return 0;
		}else {
			return ways(n-1)+ways(n-2)+ways(n-3);
		}
	}
	/*Memoization-->Remember what you have calculated
    we can do memoization and dp because this has problem has
    1)overlapping sub problem
    2)optimal sub structure
	 */
	public static int waysM(int n) {
		int storage[]=new int[n+1];
		return waysM(n,storage);
	}
	public static int waysM(int n,int storage[]) {
		if(n==0) {
			return 1;
		}
		if(storage[n]!=0) {
			return storage[n];
		}
		storage[n]=ways(n-1)+ways(n-2)+ways(n-3);
		return storage[n];
	}
	//Dynamic Programming(DP)-->
	public static int waysDP(int n) {
		if(n==1 || n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}
		int storage[]=new int[n+1];
		storage[0]=1;
		storage[1]=1;
		storage[2]=2;
		for(int i=3;i<=n;i++) {
			storage[i]=storage[i-1]+storage[i-2]+storage[i-3];
		}
		return storage[n];
	}
	public static void main(String[] args) {
    	System.out.println(waysDP(-8));
//		System.out.println(waysM(10));
	}

}
