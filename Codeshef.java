import java.util.Scanner;
public class Codeshef {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        String s=sc.next();
        if(n<=2){
            System.out.print(s);
        }else{
        char ch[]=new char[n];
        for(int p=0;p<n;p++){
            ch[p]=s.charAt(p);
        }
        int j=0;
        int k=n-1;
        while(j<=k){
            if(ch[j]=='0'){
                j++;
            }else{
                int temp=ch[j];
                ch[j]=ch[k];
                ch[k]=(char)temp;
                k--;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int m=0;m<n;m++){
            sb.append(ch[m]);
        }
        String ss=sb.toString();
        System.out.print(ss);
        }
        System.out.println();
    }

	

}
