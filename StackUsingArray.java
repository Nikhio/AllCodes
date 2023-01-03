
public class StackUsingArray {
	private int data[];
	private int top;
	public StackUsingArray() {
		data=new int[10];
		top=-1;
	}
	private void doubleCapacity() {
		int temp[]=data;
		data=new int[2*temp.length];
		for(int i=0;i<=top;i++) {
			data[i]=temp[i];
		}
	}
	public StackUsingArray(int capacity) {
		data=new int[capacity];
		top=-1;
	}
	public boolean isEmpty() {
		return (top==-1);
	}
	public int size() {
		return top+1;
	}
	public int top() throws StackEmptyException{
		if(size()==0) {
			StackEmptyException s=new StackEmptyException();
			throw s;
		}
		return data[top];
	}
	public void push(int elem)throws StackFullException {
		if(size()==data.length) {
//			StackFullException s1=new StackFullException();
//			throw s1;
			doubleCapacity();
		}
		top++;
		data[top]=elem;
	}
	public int pop() throws StackEmptyException{
		if(size()==0) {
			StackEmptyException s=new StackEmptyException();
			throw s;
		}
		int temp=data[top];
		top--;
		return temp;
	}
}
