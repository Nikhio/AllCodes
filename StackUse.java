
public class StackUse {

	public static void main(String[] args) throws StackEmptyException, StackFullException {
		StackUsingArray stack=new StackUsingArray(3);
		for(int i=0;i<5;i++) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
//		System.out.println(stack.top());

	}

}
