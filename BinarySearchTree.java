
public class BinarySearchTree {
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int left=maximum(root.left);
		int right=minimum(root.right);
		if(root.data<left) {
			return false;
		}
		if(root.data>right) {
			return false;
		}
		boolean leftOutput=isBST(root.left);
		boolean rightOutput=isBST(root.right);
		if(leftOutput && rightOutput) {
			return true;
		}
		return false;
	}
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data,Math.max(maximum(root.left),maximum( root.right)));
	}
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		return Math.max(root.data,Math.max(minimum(root.left),minimum( root.right)));
	}
	public static Pair<Boolean,Integer,Integer> isBST2(BinaryTreeNode<Integer> root){
		if(root==null) {
			Pair<Boolean,Integer,Integer> output=new Pair<>();
			output.isbst=true;
			output.min=Integer.MAX_VALUE;
			output.max=Integer.MIN_VALUE;
			return output;
		}
		Pair<Boolean,Integer,Integer> leftoutput=isBST2(root.left);
		Pair<Boolean,Integer,Integer> rightoutput=isBST2(root.right);
		int min=Math.min(root.data, Math.min(leftoutput.min,rightoutput.min));
		int max=Math.max(root.data, Math.max(leftoutput.max,rightoutput.max));
		boolean isBST=(root.data>leftoutput.max) && (root.data<=rightoutput.min)&& leftoutput.isbst && rightoutput.isbst;
		Pair<Boolean,Integer,Integer> output=new Pair<>();
		output.isbst=isBST;
		output.min=min;
		output.max=max;
		return output;
	}
	public static boolean isBST3(BinaryTreeNode<Integer> root,int min,int max) {
		if(root==null) {
			return true;
		}
		if(root.data<min || root.data>max) {
			return false;
		}
		boolean isLeftOk=isBST3(root.left,min,root.data-1);
		boolean isRightOk=isBST3(root.right,root.data,max);
		return isLeftOk && isRightOk;
	}
	public static void main(String[] args) {
		
	}
}
