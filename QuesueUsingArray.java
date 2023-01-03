public class QuesueUsingArray {
	private int data[];
	private int front;
	private int rear;
	private int size;
	public QuesueUsingArray() {
		data=new int[3];
		size=0;
		front=-1;
		rear=-1;
	}
	public QuesueUsingArray(int capacity) {
		data=new int[capacity];
		size=0;
		front=-1;
		rear=-1;
	}
	public int size() {
		return size;
	}
	public boolean isempty() {
		return (size==0);
	}
	public int front() throws QueueEmptyException{
		if(size==0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	public void enquee(int elem){
		if(size==data.length) {
//			throw new QueueFullException();
			doublecapacity();
		}
		if(size==0) {
			front=0;
		}
		if(rear==data.length ) {
			rear=0;
		
		}
		rear++;
		data[rear]=elem;
		size++;
		
		
	}
	private void doublecapacity() {
		int temp[]=data;
		data=new int[2*temp.length];
		int index=0;
		for(int i=front;i<temp.length;i++) {
			data[index]=temp[i];
			index++;
		}
		for(int i=0;i<=front-1;i++) {
			data[index]=temp[i];
			index++;
		}
		front=0;
		rear=temp.length-1;
	}
	public int dequee() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		int temp=data[front];
		front++;
		size--;
		if(front==data.length) {
			front=0;
		}
		if(front==data.length && size==0) {
			front=-1;
			rear=-1;
		}
		
		return temp;
	}
}
