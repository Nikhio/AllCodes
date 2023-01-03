
public class QueuesUseArray {

	public static void main(String[] args) throws QueueEmptyException, QueueFullException {
		QuesueUsingArray queue =new QuesueUsingArray();
			for(int i=0;i<10;i++) {
				queue.enquee(i);
			}
			System.out.println(queue.front());
		while(!queue.isempty()) {
			System.out.print(queue.dequee()+" ");
		}
		System.out.println();
		System.out.println(queue.size());
		System.out.println(queue.isempty());
//		System.out.println(queue.front());
//		System.out.println(rear);
	}

}
