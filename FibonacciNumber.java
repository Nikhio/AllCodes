package recursion_Practise;
import java.util.*;
import java.util.HashSet;
public class FibonacciNumber {
	public static boolean powerOf3(int n){
		int i=3;
		return powerOf3Helper(n,i);
		}
	public static boolean powerOf3Helper(int n,int i){
		if(n==i){
		return true;
		}
		if(i>n){
		return false;
		}
		return powerOf3Helper(n,3*i);
		}
	public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		int arr[]=new int[n];
//		for(int i=0;i<5;i++) {
//			arr[i]=sc.nextInt();
//		}
//		
//		int sum=0;
//		for(int i=0;i<n;i++) {
//			sum=sum+arr[i];
//		}
//		
//		System.out.println(sum);
//		int arr1[][]=new int[2][4];
//		for(int i=0;i<2;i++) {
//			for(int j=0;j<4;j++) {
//				int k=sc.nextInt();
//			}
//		}
//		int n=sc.nextInt();
//		System.out.println(powerOf3(n));
//        HashSet<Character> set=new HashSet<>();
//        set.add('a');
//        if(set.contains('a')) {
//        	System.out.println("jandubam ultra power");
//        }
//        set.add('a');
//        set.add('a');
//        System.out.println(set.size());
//        HashMap<Character,Integer> map=new HashMap<>();
//        map.cl
		
		char ch=(char) ('a'+5);
		System.out.println(ch);
	}

}
