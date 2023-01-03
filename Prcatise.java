
public class Prcatise {
	public static int countSame(int arr1[],int arr2[]) {
		int count=0;
		if(arr1.length>arr2.length) {
			for(int i=0;i<arr1.length;i++) {
				for(int j=0;j<arr2.length;j++) {
					if(arr1[i]==arr2[j]) {
						count++;
					}
				}
			}
		}else {
			for(int i=0;i<arr2.length;i++) {
				for(int j=0;j<arr1.length;j++) {
					if(arr2[i]==arr1[j]) {
						count++;
					}
				}
		 }
	  }
		return count;
	}
	public static void main(String[] args) {
		int arr2[]= {1,2,3,4,5,6};
		int arr1[]= {1,2,3,4,5,6};
		int ans=countSame(arr1,arr2);
		System.out.println(ans);
	}

}
