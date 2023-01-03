import java.util.*;
public class LinkedListUse {
	//Timecomplexity isO(n)----
	public static Node<Integer> reverseBetter(Node<Integer>head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> reversetail=head.next;
		Node<Integer> ans=reverseBetter(head.next);
		reversetail.next=head;
		head.next=null;
		return ans;
	}
	//Time compexity is O(n)--------
	public static DoubleNode reverse(Node<Integer> head) {
		if(head==null || head.next==null) {
			DoubleNode newNode=new DoubleNode();
			newNode.head=head;
			newNode.tail=head;
			return newNode;
		}
		DoubleNode SmallAns=reverse(head.next);
		SmallAns.tail.next=head;
		head.next=null;
		DoubleNode ans=new DoubleNode();
		ans.head=SmallAns.head;
		ans.tail=head;
		return ans;
	}
//	public static Node<Integer> insertRecursively(Node<Integer> head,int pos,int elem){
//		if(pos==0) {
//			Node<Integer> newNode=new Node<Integer>(elem);
//			newNode.next=head;
//			return newNode;
//		}
//		if(head==null) {
//			return head;
//		}
//		head.next=insertRecursively(head.next, pos-1, elem);
//		return head;
//	}
	//Inserting a node in a LinkedList-------------------------------------
//	public static Node<Integer> insert(Node<Integer> head,int data,int pos){
//		Node<Integer> temp=head;
//		Node<Integer> newNode=new Node<Integer>(80);
//		int i=0;
//		if(pos==0) {
//			newNode.next=head;
//			return newNode;
//		}
//		while(i<pos-1) {
//			temp=temp.next;
//			i++;
//		}
//		newNode.next=temp.next;
//		temp.next=newNode;
//		return head;
//	}
	//Taking input from user and making LinkedList
	public static Node<Integer> takeInput(){
		Node<Integer> head=null;
		Node<Integer> tail=null;
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();
		while(data!=-1) {
			Node<Integer> newNode=new Node<Integer>(data);
			if(head==null) {
				head=newNode;
				tail=newNode;
			}else {
//				Node<Integer> temp=head;
//				while(temp.next!=null) {
//					temp=temp.next;
//				}
//				temp.next=newNode;
				tail.next=newNode;
				tail=newNode;
			}
			data=s.nextInt();
		}
		return head;
	}
	public static void print(Node<Integer> head) {
		Node<Integer> temp=head;
		
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
//		head=temp;
//		while(head!=null) {
//			System.out.print(head.data+" ");
//			head=head.next;
//		}
	}
	public static void main(String[] args) {
//		Node<Integer> node1=new Node<Integer>(10);
//		Node<Integer> node2=new Node<Integer>(20);
//		Node<Integer> node3=new Node<Integer>(30);
//		Node<Integer> node4=new Node<Integer>(40);
//		node1.next=node2;
//		node2.next=node3;
//		node3.next=node4;
//		Node<Integer> head=node1;
//		print(head);
//		print(head);
		Node<Integer> head=takeInput();
//		head=insertRecursively(head,2,10);
		print(head);
	}

}
class DoubleNode{
	Node<Integer> head;
	Node<Integer> tail;
}
