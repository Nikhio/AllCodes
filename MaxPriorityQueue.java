import java.util.ArrayList;
public class MaxPriorityQueue {
  private ArrayList<Integer> heap;
  public MaxPriorityQueue() {
	  heap=new ArrayList<>();
  }
  public int size() {
	  return heap.size();
  }
  public boolean isEmpty() {
	  return heap.size()==0;
  }
  public void insert(int elem) {
	  heap.add(elem);
	  int childIndex=heap.size()-1;
	  int parentIndex=(childIndex-1)/2;
	  while(childIndex>0) {
		  if(heap.get(childIndex)>heap.get(parentIndex)) {
			  int temp=heap.get(childIndex);
			  heap.set(childIndex, heap.get(parentIndex));
			  heap.set(parentIndex, temp);
			  childIndex=parentIndex;
			  parentIndex=(childIndex-1)/2;
		  }else {
			  return;
		  }
	  }
  }
  public int remove() {
	  int temp=heap.get(0);
	  heap.set(0, heap.get(heap.size()-1));
	  heap.remove(heap.size()-1);
	  int index=0;
	  int maxIndex=index;
	  int left=2*index+1;
	  int right=2*index+2;
	  while(left<heap.size()) {
		  if(heap.get(left)>heap.get(maxIndex)) {
			  maxIndex=left;
		  }
		  if(right<heap.size() && heap.get(right)>heap.get(maxIndex)) {
			  maxIndex=right;
		  }
		  if(index==maxIndex) {
			  break;
		  }else {
			  int temp1=heap.get(maxIndex);
			  heap.set(maxIndex, heap.get(index));
			  heap.set(index, temp1);
			  index=maxIndex;
			  left=2*index+1;
			  right=2*index+2;
		  }
	  }
	  return temp;
  }
}
