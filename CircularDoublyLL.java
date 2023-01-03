import java.util.Scanner;
public class CircularDoublyLL {
	public static Node1<Integer> takeinput(){
		Node1<Integer> head=null;
		Node1<Integer> tail=null;
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		Node1<Integer> newNode=new Node1<Integer>(data);
		while(data!=-1) {
			if(head==null) {
				head=newNode;
				tail=newNode;
			}else {
				tail.next=newNode;
				newNode.prev=tail;
				tail=newNode;
				head.prev=tail;
				tail.next=head;
			}
			data=sc.nextInt();
		}
		return head;
	}
	public static void print(Node1<Integer> head) {
		Node1<Integer> temp=head;
		while(temp.next.next!=head) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(head.prev.data);
	}
	public static void main(String[] args) {
		Node1<Integer> head=takeinput();
		print(head);
	}
}
