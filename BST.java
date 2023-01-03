public class BST {
	private  BinaryTreeNode<Integer> root;
	public  void search(int data) {
		System.out.println(searchHelper(root,data));
		
	}
	private boolean searchHelper(BinaryTreeNode<Integer> root,int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data) {
			return true;
		}
		else {
			if(data>root.data) {
				boolean ans=searchHelper(root.right,data);
				if(ans==true) {
					return ans;
				}
			}else {
				boolean ans=searchHelper(root.left,data);
				if(ans==true) {
					return ans;
				}
			}
		}
		return false;
	}
	public void insert(int data) {
		root=insertHelper(root,data);
	}
	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int data) {
		if(root==null) {
			BinaryTreeNode<Integer> newNode=new BinaryTreeNode<>(data);
			return newNode;
		}
		else {
			if(data>root.data) {
				root.right=insertHelper(root.right,data);
				
			}else {
				root.left=insertHelper(root.left,data);
			}
		}
		return root;
	}
	public void delete(int data) {
		root=deleteHelper(root,data);
	}
	private BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root,int data){
		if(root==null) {
			return null;
		}
		if(data>root.data) {
			root.right=deleteHelper(root.right,data);
			return root;
		}else if(data<root.data) {
			root.left=deleteHelper(root.left,data);
			return root;
		}else {
			if(root.left==null && root.right==null) {
				return null;
			}else if(root.left==null) {
				return root.right;
			}else if(root.right==null) {
				return root.left;
			}else {
				BinaryTreeNode<Integer> maxNode=root.left;
				while(maxNode.right!=null) {
					maxNode=maxNode.right;
				}
				root.data=maxNode.data;
				root.left=deleteHelper(root.left,maxNode.data);
				return root;
			}
		}
	}
	public void printTree() {
		printTreeHelper(root);
	}
	private void printTreeHelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		String s=root.data+":";
		if(root.left!=null) {
			s=s+"L:"+root.left.data+",";
		}
		if(root.right!=null) {
			s=s+"R:"+root.right.data;
		}
				System.out.println(s);
				printTreeHelper(root.left);
				printTreeHelper(root.right);
	}
}
