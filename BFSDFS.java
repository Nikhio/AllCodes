import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class BFSDFS {
	public static int MotherVertex(int edges[][],int n) {
		int ans=-1;
	
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(edges[i][j]==1) {
					count++;
				}
			}
			if(count==n-1) {
				ans=i;
				return i;
			}
		}
		return ans;
	}
	
	public static void DFSHelper(int edges[][],boolean visited[],int n,int sv) {
		visited[sv]=true;
		System.out.print(sv+" ");
		for(int i=0;i<n;i++) {
			if(edges[sv][i]!=0 && visited[i]==false) {
				DFSHelper(edges,visited,n,i);
			}
		}
	}
   public static void DFS(int edges[][],int n) {
	   boolean visited[]=new boolean[n];
	   for(int i=0;i<n;i++) {
		   if(visited[i]==false) {
			   DFSHelper(edges,visited,n,i);
		   }
	   }
	   
   }
   public static void BFS(int edges[][],int n) {
	   boolean visited[]=new boolean[n];
	   for(int i=0;i<n;i++) {
		   if(visited[i]==false) {
			   BFSHelper(edges,visited,n,i);
		   }
	   }
	   
   }
	public static void BFSHelper(int[][] edges, boolean[] visited, int n, int sv) {
	Queue<Integer> queue=new LinkedList<>();
	queue.add(sv);
	visited[sv]=true;
	while(!queue.isEmpty()) {
		int front=queue.remove();
		System.out.print(front+" ");
		for(int i=0;i<n;i++) {
			if(edges[front][i]==1 && visited[i]==false) {
				queue.add(i);
				visited[i]=true;
			}
		}
	}
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int edges[][]=new int[n][n];
		for(int i=0;i<e;i++) {
			int fv=sc.nextInt();
			int sv=sc.nextInt();
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		}
//		BFS(edges,n);
//     	DFS(edges,n);
		int Vertex=MotherVertex(edges, n);
		System.out.println(Vertex);
	}
   
}
