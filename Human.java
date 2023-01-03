package oops;

public class Human {
	public static int mul(int a,int b,int c) {
		int ans=(a*b)+c;
		return ans;
	}
	public static void main(String args[]) {
		int ans=mul(2,3,4);
		System.out.println(ans);
	}
}
