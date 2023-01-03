public class MaxPriorityUse {
  public static void main(String[] args) {
    MaxPriorityQueue max=new MaxPriorityQueue();
    for(int i=0;i<10;i++) {
    	max.insert(i+1);
    }
    while(!max.isEmpty()) {
    	System.out.print(max.remove()+" ");
    }
 }
}
