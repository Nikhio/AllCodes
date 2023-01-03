import java.util.ArrayList;
class Node1<T>{
	T data;
	ArrayList<Node1<T>> children;
	public Node1(T data) {
		this.data=data;
		children=new ArrayList<>();
		
	}
}
public class TreeNode {

	public static void main(String[] args) {
      Node1<Integer> node =new Node1(5);
      Node1<Integer> node1 =new Node1(4);
      Node1<Integer> node2 =new Node1(3);
      Node1<Integer> node3 =new Node1(7);
      Node1<Integer> node4 =new Node1(66);
      Node1<Integer> node5 =new Node1(6);
      node.children.add(node1);
      node.children.add(node2);
      node.children.add(node3);
      node2.children.add(node4);
      node4.children.add(node5);
      System.out.println(node.children.get(0).data);
      
      
	}
}
