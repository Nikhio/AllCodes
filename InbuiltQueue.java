//import java.util.LinkedList;
//import java.util.Queue;
import java.util.*;

public class InbuiltQueue {

	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(10);
		queue.add(4);
		queue.add(100);
		queue.add(42);
		queue.add(101);
		queue.add(40192);
		while(!queue.isEmpty()) {
			System.out.print(queue.remove()+" ");
		}
	}

}
