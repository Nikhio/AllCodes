import java.util.Scanner;

public class DoublyLinkedList {
	public static Node1<Integer> delete(Node1<Integer> head,int pos){
		Node1<Integer> temp=head;
		if(head==null || head.next==null) {
			return head;
		}
		if(pos==0) {
			temp.next.prev=null;
			head=temp.next;
			temp.next=null;
			return head;
		}
		int i=0;
		while(i<pos-1) {
			temp=temp.next;
			i++;
		}
		temp.next.prev=null;
		Node1<Integer> temp1=temp;
		temp=temp.next;
		temp.next.prev=temp1;
		temp1.next=temp.next;
		temp.next=null;

		return head;
	}

	public static Node1<Integer> insert(Node1<Integer> head,int data,int pos){
		Node1<Integer> newNode=new Node1<Integer>(data);
		Node1<Integer> temp=head;
		if(head==null || head.next==null) {
			return head;
		}
		if(pos==0) {
			temp.prev=newNode;
			newNode.next=temp;
			head=newNode;
			newNode.prev=null;
			return head;
		}
		//		Node1<Integer> temp=head;
		int i=0;
		while(i<pos-1) {
			temp=temp.next;
			i++;
		}
		newNode.next=temp.next;
		newNode.prev=temp;
		temp.next.prev=newNode;
		temp.next=newNode;
		return head;
	}
	public static Node1<Integer> takeInput(){
		Node1<Integer> head=null;

		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		while(data!=-1) {
			Node1<Integer> newNode=new Node1<Integer>(data);
			if(head==null) {
				head=newNode;

			}
			else {
				Node1<Integer> temp=head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next=newNode;
				newNode.prev=temp;
			}
			data=sc.nextInt();
		}
		return head;

	}
	public static void main(String[] args) {
		//		Node1<Integer> list1=new Node1<Integer>(10);
		//		Node1<Integer> list2=new Node1<Integer>(20);
		//		Node1<Integer> list3=new Node1<Integer>(30);
		//		Node1<Integer> list4=new Node1<Integer>(40);
		//		Node1<Integer> head=list1;
		//		list1.next=list2;
		//		list1.prev=null;
		//		list2.prev=list1;
		//		list2.next=list3;
		//		list3.prev=list2;
		//		list3.next=list4;
		//		list4.prev=list3;
		//		list4.next=null;
		//		while(head!=null) {
		//			System.out.print(head.data+" ");
		//			head=head.next;
		//		}
		Node1<Integer> head=takeInput();
		head=delete(head,0);
		while(head!=null) {
			System.out.print(head.data+" ");
			//			System.out.println();
			head=head.next;
		}
	}

}
