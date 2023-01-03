//sliding window:
public class slidingWindow {
    public static int[] printk(int arr[],int k,int n) {
    	int newarr[]=new int[n-k+1];
    	for(int i=0;i<=n-k;i++){
    	     int count=0;
    	      int max=0;
    		for(int j=i;count<k;j++){
    			if(max==0 || max<arr[j]){
    				max=arr[j];
    	                  
    	               }
    			count++;
    	           }
    	          newarr[i]=max;
    	     }
    	return newarr;
    }
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,9,6,4,3,2};
		int newarr[]=printk(arr, 3, arr.length);
		for(int i=0;i<newarr.length;i++) {
			System.out.print(newarr[i]+" ");
		}

	}

}
