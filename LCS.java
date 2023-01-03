//LCS-->Longest common Subsequence abce and adc lcs will be 2
//Recursively Brute force approach
public class LCS {
	public static int LCS(String s,String t) {
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		if(s.charAt(0)==t.charAt(0)) {
			return 1+LCS(s.substring(1),t.substring(1));
		}
		else {
			int op1=LCS(s,t.substring(1));
			int op2=LCS(s.substring(1),t);
			/*we donot have to handle this op3 case as it is internally handled by op1 and op2 so we 
	donot have to write explicitly		
	int op3=LCS(s.substring(1),t.substring(1));*/
			return Math.max(op1,op2);
		}
	}
	//Memoization-->
	public static int LCSM(String s,String t) {
		int m=s.length();
		int n=t.length();
		int storage[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				storage[i][j]=-1;
			}
		}
		return LCSM(s,t,storage);
	}
	public static int LCSM(String s,String t,int storage[][]) {
		int m=s.length();
		int n=t.length();
		if(m==0 || n==0) {
			storage[m][n]=0;
			return storage[m][n];
		}
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(s.charAt(0)==t.charAt(0)) {
			storage[m][n]= 1+LCSM(s.substring(1),t.substring(1),storage);
		}else {
			int op1=LCSM(s,t.substring(1),storage);
			int op2=LCSM(s.substring(1),t,storage);
			storage[m][n]=Math.max(op1, op2);
		}
		return storage[s.length()][t.length()];
	}
	//DP-->
	public static int LCSDP(String s,String t) {
		int m=s.length();
		int n=t.length();
		int storage[][]=new int[m+1][n+1];
		for(int  j=0;j<=n;j++) {
			storage[0][j]=0;
		}
		for(int i=0;i<=m;i++) {
			storage[i][0]=0;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(m-i)==t.charAt(n-j)) {
					storage[i][j]=1+storage[i-1][j-1];
				}else {
					storage[i][j]=Math.max(storage[i-1][j], storage[i][j-1]);
				}
			}
		}
		return storage[m][n];
	}


	//editDistance-->Recursively -->Brute force approach

	/*editDistance--> minimum operation required to make string s equals to string t we do not have
	to change the string we only need to count minimum operation
	operation can be 1)insert a character,2)delete a character or 3)substitute a character with other
    character*/ 

	public static int editDistance(String s,String t) {
		/*base case if s.length()==0 so we have to insert t.length characters 
		 if t.length()==0 we have delete s.length characters
		 */
		if(s.length()==0) {
			return t.length();
		}
		if(t.length()==0) {
			return s.length();
		}
		if(s.charAt(0)==t.charAt(0)) {
			return editDistance(s.substring(1), t.substring(1));
		}else {
			//insert
			int op1=editDistance(s, t.substring(1));
			//delete
			int op2=editDistance(s.substring(1), t);
			//substitute
			int op3=editDistance(s.substring(1), t.substring(1));
			return 1+Math.min(op1, Math.min(op2, op3));
		}
	}
	//Memoization-->memorize what is already calculated and ues it further if require
	public static int editDistanceM(String s,String t) {
		int m=s.length();
		int n=s.length();
		int storage[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				storage[i][j]=-1;
			}
		}
		return editDistanceM(s, t,storage);
	}
	public static int editDistanceM(String s, String t, int[][] storage) {
		int m=s.length();
		int n=t.length();
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(m==0) {
			storage[m][n]=n;
			return storage[m][n];
		}
		if(n==0) {
			storage[m][n]=m;
			return storage[m][n];
		}
		if(m==0 && n==0) {
			storage[m][n]=0;
			return storage[m][n];
		}
		if(s.charAt(0)==t.charAt(0)) {
			storage[m][n]=editDistanceM(s.substring(1), t.substring(1),storage);
		}else {
			int op1=editDistanceM(s, t.substring(1),storage);
			int op2=editDistanceM(s.substring(1), t,storage);
			int op3=editDistanceM(s.substring(1), t.substring(1),storage);
			storage[m][n]=1+Math.min(op1,Math.min(op2, op3));

		}
		return storage[m][n];
	}
	//	DP--> Dynamic programming Approach-->
	public static int editDistanceDP(String s,String t) {
		int m=s.length();
		int n=t.length();
		int storage[][]=new int[m+1][n+1];
		//1st row
		for(int i=0;i<=n;i++) {
			storage[0][i]=i;
		}
		//1st column
		for(int i=0;i<=m;i++) {
			storage[i][0]=i;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(m-i)==t.charAt(n-j)) {
					storage[i][j]=storage[i-1][j-1];
				}else {
					storage[i][j]=1+Math.min(storage[i-1][j],Math.min(storage[i][j-1], storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
	}
	public static void main(String[] args) {
		String s="abceabceabceabceabceabceabceabceabceabceabceabceabceabceabce";
		String t="adcababceabceabcekjfjewjfpwfpwefwwfwfweflwkwhfwwr";
		//		System.out.println(LCSDP(s,t));
		//		System.out.println(LCSM(s,t));
		System.out.println(editDistanceM(s, t));
		System.out.println(editDistanceDP(s, t));
//		System.out.println(editDistance(s, t));

	}

}
