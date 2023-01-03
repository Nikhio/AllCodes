
public class reverse_Array {

	public static int maxSubArray(int[] nums) {
		//Brute force solution:here we are finding all possible subarrays
		//Time complexity:O(n^2)

		int sum=Integer.MIN_VALUE;;
		for(int i=0;i<nums.length;i++){
			int ans=0;
			for(int j=i;j<nums.length;j++){
				ans=ans+nums[j];
				if(ans>sum){
					sum=ans;
				}
			}
		}

		/*Kandens Algorithm:we will traverse and keep adding element  in ans but when we encountter 
		 * that out ans<0 we will stop and make out ans 0 and start traversing again::
		 * Time complexity O(n)
		 */



		//	        int sum=Integer.MIN_VALUE;
		//	        int ans=0;
		//	        for(int i=0;i<nums.length;i++){
		//	            ans=ans+nums[i];
		//	            if(ans>sum){
		//	                sum=ans;
		//	            }
		//	            if(ans<0){
		//	                ans=0;
		//	            }
		//	        }

		return sum;
	}
	//Two Pointer Algorithm:Here we are using two pointer and start swapping until we swap each element
	//in the array::
	public static int[] reverse(int arr[]) {
		int i=0;
		int j=arr.length-1;
		while(j>=i) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			j--;
			i++;
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[]= {1,-2,3,-4,5,6,-88,9,-5,4};
		int ans[]=reverse(arr);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		int sum=maxSubArray(arr);
		System.out.println(sum);
	}

}
