class pair{
	int len;
	String s;
}
public class LongestPlaindromicString {
	public static pair palindromeString(String s) {
		int start=-1;
		int end=-1;
		int max=-1;
		for(int i=0;i<s.length();i++) {
			int odd=ExpandAroundCenter(s,i,i);
			int even=ExpandAroundCenter(s,i,i+1);
			if(odd>max) {
				max=odd;
				start=i-(odd/2);
				end=i+(odd/2);
			}
			if(even>max) {
				max=even;
				start=i-(even-1)/2;
				end=i+(even/2);
			}

		}
		pair p=new pair();
		p.s=s.substring(start, end+1);
		p.len=end-start+1;
		return p;
	}
	public static int ExpandAroundCenter(String s,int left,int right) {
		while(left>=0 && right<s.length()&& s.charAt(left)==s.charAt(right) ) {
			left--;
			right++;
		}
		return right-left-1;
	}
	public static void main(String[] args) {
		String s="cabacabcdaa";
		pair ans=palindromeString(s);
		System.out.println(ans.len+" "+ans.s);		
	}

}
