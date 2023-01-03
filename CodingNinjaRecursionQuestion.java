package recursion;
import java.util.Scanner;
public class CodingNinjaRecursionQuestion {
	public static String skipAchar(String s,char c) {
		String str="";
		if(s.length()==0) {
			return str;
		}
		if(s.charAt(0)!=c) {
			str=str+s.charAt(0);
//			return str;
		}
		String ans=skipAchar(s.substring(1), c);
		return str+ans;
	}
	public static int NumberOfDigit(int n) {
		if(n/10==0) {
			return 1;
		}
		int smallAns=NumberOfDigit(n/10);
		return smallAns+1;
	}
	public static void print(int n) {
		if(n==1) {
			System.out.print(n+" ");
			return;
		}
		print(n-1);
		System.out.print(n+" ");
	}
	public static int power(int x,int n) {
		if(n==1) {
			return x;
		}
		int smallAns=power(x,n-1);
		return x*smallAns;
	}
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int x=sc.nextInt();
//		int n=sc.nextInt();
//		int ans=power(x,n);
//		System.out.println(ans);
//		int n=sc.nextInt();
//		print(n);
//		int n=sc.nextInt();
//		int ans=NumberOfDigit(n);
//		System.out.println(ans);
		String ans=skipAchar("aaaaabcd",'a');
		System.out.println(ans);
	}
}
