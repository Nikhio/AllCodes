
public class CircularLinkedist {
	public static void main(String[] args) {
		Node<Integer> node1=new Node<Integer>(10);
		Node<Integer> node2=new Node<Integer>(100);
		Node<Integer> node3=new Node<Integer>(1000);
		Node<Integer> node4=new Node<Integer>(10000);
		Node<Integer> head=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=head;
		Node<Integer> temp=head;
		while(temp.next!=head) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print(temp.data+" "+temp.next+" ");
		System.out.println(node1);
	}
}
