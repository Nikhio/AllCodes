
public class LinkedListQuestionPractise {
	public static Node<Integer> detectCycle(Node<Integer> head){
		if(head==null || head.next==null){
            return null;
        }
		Node temp=head;
		int count=0;
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
       Node temp1=head;
       Node temp2=head.next;
        while(temp1.next!=null){
        	int i=0;
            while(i<count){
                if(temp2.next==temp1){
                    return temp1;
                }
                temp2=temp2.next;
                i++;
            }
            temp2=head;
            temp1=temp1.next;
            temp2=temp1.next;
        }
        return null;
	}
	public static void main(String[] args) {
		Node<Integer> n1=new Node<>(3);
		Node<Integer> n2=new Node<>(2);
		Node<Integer> n3=new Node<>(0);
		Node<Integer> n4=new Node<>(-4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n2;
		Node<Integer> ans=detectCycle(n1);
		System.out.println(ans);
		System.out.println(n2);
	}
}
