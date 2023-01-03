import java.util.*;
public class PrimsAlgorithmImplement {
	public static int findMin(int weight[],boolean visited[]) {
		int minVertex=-1;
		for(int i=0;i<weight.length;i++) {
			if(visited[i]==false && (minVertex==-1 || weight[i]<weight[minVertex])) {
				minVertex=i;
			}
		}
		return minVertex;
	}
	public static void prims(int[][] edge, int n) {
		boolean visited[]=new boolean[n];
		int parent[]=new int[n];
		int weight[]=new int[n];
		weight[0]=0;
		for(int i=1;i<n;i++) {
			weight[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<n;i++) {
			int minVertex=findMin(weight,visited);
			visited[minVertex]=true;
			for(int j=0;j<n;j++) {
				if(edge[minVertex][j]!=0 && visited[j]==false) {
					if(edge[minVertex][j]<weight[j]) {
						weight[j]=edge[minVertex][j];
						parent[j]=minVertex;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			if(parent[i]<i) {
				System.out.println(parent[i]+" "+i+" "+weight[i]);
			}else {
				System.out.println(i+" "+parent[i]+" "+weight[i]);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int edge[][]=new int[n][n];
		for(int i=0;i<e;i++) {
			int fv=sc.nextInt();
			int sv=sc.nextInt();
			int weight=sc.nextInt();
			edge[fv][sv]=weight;
			edge[sv][fv]=weight;
		}
		prims(edge,n);
	}

	
}