
public class QueueUseLL {

	public static void main(String[] args) throws QueueEmptyException {
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<Integer>();
		for(int i=0;i<5;i++) {
			queue.enquee(i+1);
		}
		while(!queue.isempty()) {
			System.out.print(queue.dequee()+" ");
		}
		System.out.println(queue.front());
	}

}
