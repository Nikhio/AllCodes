import java.util.ArrayList;
import java.util.Scanner;
public class BinaryTreeUse {
	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root,int data){
		if(root==null) {
			return null;
		}
		if(root.data==data) {
			ArrayList<Integer> output=new ArrayList<>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput= getRootToNodePath(root.left,data);
		if(leftOutput!=null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput= getRootToNodePath(root.left,data);
		if(rightOutput!=null) {
			rightOutput.add(root.data);
			return rightOutput;
		}else {
			return null;
		}
	}
	public static BinaryTreeNode<Integer> takeInputBetter(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the root data");
		int n=sc.nextInt();
		if(n==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(n);
		QueueUsingLL<BinaryTreeNode<Integer>> pending=new QueueUsingLL<>();
		pending.enquee(root);
		while(!pending.isempty()) {
			try {
				BinaryTreeNode<Integer> front=pending.dequee();
				System.out.println("Enter the left child of "+front.data);
				int lc=sc.nextInt();
				if(lc!=-1) {
					BinaryTreeNode<Integer> leftchild=new BinaryTreeNode<Integer>(lc);
					pending.enquee(leftchild);
					front.left=leftchild;
				}
				
				System.out.println("Enter the right child of "+front.data);
				int rc=sc.nextInt();
				if(rc!=-1) {
					BinaryTreeNode<Integer> rightchild=new BinaryTreeNode<Integer>(rc);
					pending.enquee(rightchild);
					front.right=rightchild;
				}
				
			
			}	catch (QueueEmptyException e) {
				//Never Reached Here;
			}
		}
		return root;
	}
	public static pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){
		if(root==null) {
			pair<Integer,Integer> output =new pair<>();
			output.first=0;
			output.second=0;
			return output;
		}
		pair<Integer,Integer> lo=heightDiameter(root.left);
		pair<Integer,Integer> ro=heightDiameter(root.right);
		int height=1+Math.max(lo.first,ro.first);
		int option1=lo.first+ro.first;
		int option2=lo.second;
		int option3=ro.second;
		int diameter=Math.max(option1, Math.max(option2, option3));
		pair<Integer,Integer> output =new pair<>();
		output.first=height;
		output.second=diameter;
		return output;
	}
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int option1=height(root.left)+height(root.right);
		int option2=height(root.left);
		int option3=height(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}
	public static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		return 1+Math.max(lh, rh);
		
	}
	public static BinaryTreeNode<Integer> takeInputIterativly(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the root data:");
		int rootdata=sc.nextInt();
		if(rootdata==-1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pending=new QueueUsingLL<>();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
		pending.enquee(root);
		while(!pending.isempty()) {
			try {
				BinaryTreeNode<Integer> front=pending.dequee();
				System.out.println("Enter "+front.data+" left child");
				int n=sc.nextInt();
				if(n!=-1) {
					BinaryTreeNode<Integer> left=new BinaryTreeNode<Integer>(n);
					pending.enquee(left);
					front.left=left;
				}
				System.out.println("Enter "+ front.data+" right child ");
				int m=sc.nextInt();
				if(m!=-1) {
					BinaryTreeNode<Integer> right=new BinaryTreeNode<Integer>(m);
					pending.enquee(right);
					front.right=right;
				}
				}
				
		catch (QueueEmptyException e) {
				//Never reach here
			}
			
		}
		return root;
	}
	public static BinaryTreeNode<Integer> takeinput(Scanner s) {
		int rootData;
		System.out.println("Enter root data:");
		rootData=s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		root.left=takeinput(s);
		root.right=takeinput(s);
		return root;
	}
	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		String s=root.data+"";
		if(root.left!=null) {
			s=s+":"+"L"+root.left.data+",";
		}
		if(root.right!=null) {
			s=s+":"+"R"+root.right.data;
		}
		System.out.println(s);
		print(root.left);
		print(root.right);
	}
	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node1=new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(3);
//		root.left=node1;
//		root.right=node2;
//		System.out.println(root);
//		Scanner sc=new Scanner(System.in);
//		BinaryTreeNode<Integer> root=takeinput(sc);
//		print(root);
//		BinaryTreeNode<Integer> root=takeInputIterativly();
//		print(root);
//		System.out.println(diameter(root));
		BinaryTreeNode<Integer> node=takeInputBetter();
		print(node);
	}
		
}
