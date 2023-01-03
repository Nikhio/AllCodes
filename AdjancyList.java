import java.util.*;
public class AdjancyList {
	public static void DFSHelper(ArrayList<ArrayList<Integer>> adjency, int n, boolean[] visited,int sv) {
		visited[sv]=true;
		System.out.print(sv+" ");
		ArrayList<Integer> list=adjency.get(sv);
		for(int i=0;i<list.size();i++) {
			if(visited[list.get(i)]==false) {
				DFSHelper(adjency,n,visited,list.get(i));
			}else {
				continue;
			}

		}

	}
	public static void DFS(ArrayList<ArrayList<Integer>> adjency, int n) {
		boolean visited[]=new boolean[n];
		DFSHelper(adjency, n, visited, 0);
	}

	public static void BFS(ArrayList<ArrayList<Integer>> adj,int n) {
		boolean visited[]=new boolean[n];
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				BFSHelper(adj,n,visited,i);
			}
		}

	}
	public static void BFSHelper(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited,int sv) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(sv);
		visited[sv]=true;
		while(!queue.isEmpty()) {
			int front=queue.remove();
			System.out.print(front+" ");
			ArrayList<Integer> list=adj.get(front);
			for(int i=0;i<list.size();i++) {
				if(visited[list.get(i)]==false) {
					queue.add(list.get(i));
					visited[list.get(i)]=true;
				}

			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<ArrayList<Integer>> adjency=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++) {
			adjency.add(new ArrayList<Integer>());
		}
		int e=sc.nextInt();
		for(int i=0;i<e;i++) {
			int sv=sc.nextInt();
			int ev=sc.nextInt();
			adjency.get(sv).add(ev);
			adjency.get(ev).add(sv);
		}
		DFS(adjency,n);
		BFS(adjency,n);



	}
}
