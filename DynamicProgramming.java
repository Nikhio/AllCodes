public class DynamicProgramming {
	public static int fib(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return fib(n-1)+fib(n-2);
	}
	/*Memoizating techinique-->Top down approach mermoriz what we 
	 *calculated so that we donot have to calculate  again.
	space complexity increases but time complexity decreses from O(2^n) to O(n)*/
	public static int  fibM(int n) {
		int storage[]=new int[n+1];
		for(int i=0;i<=n;i++) {
			storage[i]=-1;
		}
		return fibM(storage,n);
	}
	public static int fibM(int storage[],int n) {
		if(n==0 || n==1) {
			storage[n]=n;
			return storage[n];
		}
		if(storage[n]!=-1) {
			return storage[n];
		}
		storage[n]=fibM(n-1)+fibM(n-2);
		return storage[n];
	}
	/*Dynamic programming-->Bottom up Approach it uses past calculated value to 
	 * calculate the present ones
	 */
	public static int fibD(int n) {
		int storage[]=new int[n+1];
		for(int i=0;i<=n;i++) {
			if(i==0 || i==1) {
				storage[i]=i;
			}else {
				storage[i]=storage[i-1]+storage[i-2];
			}
		}  
		return storage[n];
	}
	public static int countSteps(int n) {
		if(n==1) {
			return 0;
		}
		int op1=countSteps(n-1);
		int minSteps=op1;
		if(n%2==0) {
			int op2=countSteps(n/2);
			if(op2<minSteps) {
				minSteps=op2;
			}
		}
		if(n%3==0) {
			int op3=countSteps(n/3);
			if(op3<minSteps) {
				minSteps=op3;
			}
		}
		return 1+minSteps;
	}
	// Memoization Technique -->
	public static int countStepsM(int n) {
		int storage[]=new int[n+1];
		for(int i=0;i<=n;i++) {
			storage[i]=-1;
		}
		return countStepsM(n,storage);
	}
	public static int countStepsM(int n,int storage[]) {
		if(n==1) {
			storage[n]=1;
			return storage[n];
		}
		if(storage[n]!=-1) {
			return storage[n];
		}
		storage[n]=1+countSteps(n-1);//memoization remeber what we have calculated
		return storage[n];
	}
	public static int countStepsDP(int n) {
		int storage[]=new int[n+1];
		for(int i=0;i<=n;i++) {
			if(i==0 || i==1) {
				storage[i]=0;
			}
			else {
				if(i%2==0) {
					int temp=i-1;
					if(temp%3==0) {
						storage[i]=1+storage[i-1];
					}else {
						storage[i]=1+storage[i/2];
					}

				}
				if(i%3==0) {
					storage[i]=1+storage[i/3];
				}else {
					storage[i]=1+storage[i-1];
				}

			}
		}
		return storage[n];
	}
	//Minimum count of square of number require to represent a number::
	public static int minCount(int n) {
		if(n<=3) {
			return n;
		}
		int res=n;
		for(int i=1;i<n;i++) {
			int temp=i*i;
			if(temp>n) {
				break;
			}
			res=Math.min(res,minCount(n-temp)+1);
		}
		return res;
	}
	public static int minCountM(int n) {
		int storage[]=new int[n+1];
		return minCountM(n,storage);
	}
	public static int minCountM(int n,int storage[]) {
		if(n<=3) {
			return storage[n];
		}
		if(storage[n]!=0) {
			return storage[n];
		}
		storage[n]=minCount(n);
		return storage[n];
	}
	public static int minCountDP(int n) {
		if(n<=3) {
			return n;
		}
		int storage[]=new int[n+1];
		storage[0]=0;
		storage[1]=1;
		storage[2]=2;
		storage[3]=3;
		for(int i=4;i<=n;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=1;j<i;j++) {
				int temp=j*j;
				if(temp>i) {
					break;
				}
				if(storage[i-temp]+1<min) {
					min=storage[i-temp]+1;
				}
			}
			storage[i]=min;
		}
		return storage[n];
	}
	public static void main(String[] args) { 
		//System.out.println(fibD(95));		
		//System.out.println(countStepsM(1000));
//		System.out.println(countStepsDP(5));
		System.out.println(minCount(13));
	}
}
