 class ListNode {
     int val;
     ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
	public static ListNode partition(ListNode head, int x) {
    if(head==null || head.next==null){
        return head;
    }
   ListNode fHead=null;
   ListNode fTail=null;
   ListNode temp=head;
   while(temp!=null){
     if(temp.val<x){
         if(fHead==null && fTail==null){
             fHead=temp;
             fTail=temp;
         }else{
             fTail.next=temp;
             fTail=temp;
         }
     }
       temp=temp.next;
  }
   	fTail.next=null;
    ListNode sHead=null;
    ListNode sTail=null;
    ListNode temp1=head;
    while(temp1!=null){
        if(temp1.val>=x){
            if(sHead==null && sTail==null){
                sHead=temp1;
                sTail=temp1;
            }else{
                sTail.next=temp1;
                sTail=temp1;
            }
        }
       temp1=temp1.next;
    }
    fTail.next=sHead;
    return fHead;
}
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(4);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(2);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(2);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=null;
		ListNode head=partition(l1,3);
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
		
	}
}
