import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class Graph {
	/*DFS --> WE ARE PRINTING IN depth first search approach it means
	we will go to the deep*/
	public static void printHelperDFS(int edges[][],int sv,boolean visited[]) {
		System.out.print(sv+" ");
		visited[sv]=true;
		int n=edges.length;
		for(int i=0;i<n;i++) {
			if(edges[sv][i]==1 && visited[i]==false) {
				printHelperDFS(edges, i, visited);
			}
		}
	}
	public static void DFS(int edges[][]){
		boolean visited[]=new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(visited[i]==false) {
				printHelperDFS(edges,i,visited);
			}
		}
	}

	//BFS --> Breadth First Search

	public static void BFS(int edges[][]){
		boolean visited[]=new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(visited[i]==false) {
				printHelperBFS(edges,i,visited);
			}
		}
	}
	/*In BFS we will maintain a Queue which will store all the adjacent node
	 * Breadth first search is same as Inorder Traversal of a tree
	 */
	public static void printHelperBFS(int edges[][],int sv,boolean visited[]) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(sv);
		visited[sv]=true;
		while(!queue.isEmpty()) {
			int front=queue.remove();
			System.out.print(front+" ");
			for(int i=0;i<edges[0].length;i++) {
				if(edges[front][i]==1 && visited[i]==false) {
					queue.add(i);
					visited[i]=true;
				}

			}
		}
		//		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		//we are creating a Adjacency matrix:
		int edges[][]=new int[n][n];
		/*Asking the vertices which has edge
		 * and marking those cell as 1-->true and other vertex which has no edge will marks as 0
		 * -->false
		 */
		for(int i=0;i<e;i++) {
			int fv=sc.nextInt();
			int sv=sc.nextInt();
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		}
		System.out.println("BFS traversal:");
		BFS(edges);
		System.out.println("DFS traversal:");
		DFS(edges);
	}

}
