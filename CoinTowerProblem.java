
public class CoinTowerProblem {
  public static void CoinGame(int n,int x,int y) {
	  int dp[]=new int[n+1];
	  //Bittu and chintu palying game ,bittu remove first we have to tell bittu will win ot lose
	  //n-->5,x=2,y=4;
	  dp[0]=0;
	  dp[1]=1;
	  
	  for(int i=2;i<=n;i++) {
		  if (dp[i-1]==0) {
			  dp[i]=1;
		  }
		  else if(i-x>=0 && dp[i-x]==0) {
			  dp[i]=1;
		  }else if(i-y>=0 && dp[i-y]==0) {
			  dp[i]=1;
		  }else {
			  dp[i]=0;
		  }
	  }
	  if(dp[n]==0) {
		  System.out.println("chintu has won the game of coin tower ");
	  }else {
		  System.out.println("bittu has won the game of coin tower ");
	  }
  }
  public static void main(String[] args) {
	CoinGame(0, 5, 3);
}
}
