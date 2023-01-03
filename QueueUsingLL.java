
public class QueueUsingLL<T> {
	private QueueNode<T> front;
	private QueueNode<T> rear;
	private int size;
	public QueueUsingLL() {
		front=null;
		rear=null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isempty() {
		return (size()==0);
	}
	public T front() throws QueueEmptyException{
		if(size()==0) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
	public void enquee(T elem) {
		QueueNode<T> newNode=new QueueNode<T>(elem);
		size++;
		if(front==null) {
			front=newNode;
			rear=newNode;
		}else if(rear!=null){
			rear.next=newNode;
			rear=newNode;
		}
	}
	public T dequee() throws QueueEmptyException {
		if(size()==0) {
			throw new QueueEmptyException();
		}
//		if(front==null) {
//			
//		}
		T temp=front.data;
		
		front=front.next;
		size--;
		if(size()==1) {
			rear=null;
		}
		return temp;
	}
}
