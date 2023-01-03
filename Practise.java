package recursion;

public class Practise {
	 public static int fibo(int n) {

		 if(n<2) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}
	public static void main(String[] args) {
//	int ans=fibo(5);
//	System.out.println(ans);
	int data =5/2;
	System.out.println(data);
	}

}
