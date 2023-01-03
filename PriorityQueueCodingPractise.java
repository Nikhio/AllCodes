//import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
class MinComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1<o2) {
			return -1;
		}else if(o1>o2) {
			return 1;
		}
		return 0;
	}
	
}
class MaxComperator implements Comparator<Integer>{
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		}else if(o1<o2) {
			return 1;
		}
		return 0;
	}
	 
 }
public class PriorityQueueCodingPractise {
    public static void sortKsorted(int arr[],int k) {
    	PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    	int i=0;
    	for(;i<k;i++) {
    		pq.add(arr[i]);
    	}
    	for(;i<arr.length;i++) {
    		arr[i-k]=pq.remove();
    		pq.add(arr[i]);
    	}
    	for(int j=arr.length-k;j<arr.length;j++) {
    		arr[j]=pq.remove();
    		
    	}
    }
	public static void main(String[] args) {
		MaxComperator max=new MaxComperator();
		MinComparator min=new MinComparator();
		PriorityQueue<Integer> pq=new PriorityQueue<>(min);
//		int arr[]= {2,4,1,9,6,8};
//		sortKsorted(arr, 3);
//		for(int i=0;i<arr.length;i++) {
//			System.out.print(arr[i]+" ");
//		}
		pq.add(1);
		pq.add(72);
		System.out.println(pq.remove());
		
	}
}
