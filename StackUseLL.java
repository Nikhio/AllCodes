import java.util.Stack;

public class StackUseLL {

	public static void main(String[] args) throws StackEmptyExceptionLL {
		StackUsingLinkedList<Integer> s=new StackUsingLinkedList<Integer>();
		s.push(5);
		s.push(10);
		s.push(100);
		s.push(1);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.push(15);
		s.push(20);
		System.out.println(s.size());
		System.out.println(s.top());
		System.out.println(s.isempty());
		Stack<String> snew=new Stack<String>();
		
	}

}
