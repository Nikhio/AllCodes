
public class StackUsingLinkedList<T> {
	private StackNode<T> head;
	private int size;
	public StackUsingLinkedList() {
		head=null;
		size=0;
	}
	public int size() {
		return size-1;
	}
	public boolean isempty() {
		return (head==null);
	}
	public T top() {
		return head.data;
	}
	public void push(T elem) {
		StackNode<T> newNode=new StackNode<T>(elem);
		++size;
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.next=head;
			head=newNode;
		}
	}
	public T pop() throws StackEmptyExceptionLL {
		if(head==null) {
			StackEmptyExceptionLL e=new StackEmptyExceptionLL();
			throw e;
		} if(head.next!=null) {
		head=head.next;
		--size;
		}
		return head.data;
	}
}
