
public class BSTUse {

	public static void main(String[] args) {
		BST bst=new BST();
		bst.insert(5);
		bst.insert(3);
		bst.insert(8);
		bst.insert(7);
		bst.insert(9);
		bst.insert(2);
		bst.insert(4);
		bst.printTree();
		bst.search(5);
		bst.delete(5);
		bst.printTree();
		bst.search(5);
	}

}
