import java.util.Scanner;

public class TreeUse {
	
	
	
	public static void printLevelWise(TreeNode<Integer> root) {
		
	}
	
 	public static int numNodes(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			count=count+numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		System.out.println("Enter the root ");
		Scanner sc=new Scanner(System.in);
		int rootdata=sc.nextInt();
		QueueUsingLinkedList<TreeNode<Integer>> pendingnodes=new QueueUsingLinkedList<>();
		TreeNode<Integer> root=new TreeNode<Integer>(rootdata);
		pendingnodes.enquee(root);
		while(!pendingnodes.isempty()) {
			try {
				TreeNode<Integer> frontNode=pendingnodes.dequee();
				System.out.println("enter the number of children of "+ frontNode.data);
				int numchild=sc.nextInt();
				for(int i=0;i<numchild;i++) {
					System.out.println("enter "+ (i+1)+" child of "+frontNode.data);
					int n=sc.nextInt();
					TreeNode<Integer> child=new TreeNode<Integer>(n);
					frontNode.children.add(child);
					pendingnodes.enquee(child);
					
				}
			} catch (QueueEmptyException e) {
				//never reach here
			}
		}
		return root;
		
	}
	public static TreeNode<Integer> takeInput() {

		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter the node");
		n=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(n);
		int countChildren;
		System.out.println("Enter the Number Of children");
		countChildren=sc.nextInt();
		for(int i=0;i<countChildren;i++) {
			TreeNode<Integer> child=takeInput();
			root.children.add(child);
		}
		return root;
	}
	public static void print(TreeNode<Integer> root) {
		String s=root.data+":";
		for(int i=0;i<root.children.size();i++) {
			s=s+root.children.get(i).data+",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	public static void main(String[] args) {
//		TreeNode<Integer> root =new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 =new TreeNode<Integer>(2);
//		TreeNode<Integer> node2 =new TreeNode<Integer>(3);
//		TreeNode<Integer> node3 =new TreeNode<Integer>(5);
//		TreeNode<Integer> node4 =new TreeNode<Integer>(6);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//		System.out.println(root);
		TreeNode<Integer> root=takeInput();
		int ans=numNodes(root);
		System.out.println(ans);
//		print(root);
//		TreeNode<Integer> root=takeInputLevelWise();
//		print(root);
	}
	
}
