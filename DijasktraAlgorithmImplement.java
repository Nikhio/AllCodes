import java.util.Scanner;
import java.util.*;
public class DijasktraAlgorithmImplement {
	public static int findMin(int distance[],boolean visited[]) {
		int minVertex=-1;
		for(int i=0;i<distance.length;i++) {
			if(visited[i]==false && (minVertex==-1 || distance[i]<distance[minVertex])) {
				minVertex=i;
			}
		}
		return minVertex;
	}
	public static void Dijasktra(int[][] edge, int n) {
		int distance[]=new int[n];
		distance[0]=0;
		for(int i=1;i<n;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		boolean visited[]=new boolean[n];
		for(int i=0;i<n;i++) {
			int minVertex=findMin(distance,visited);
			visited[minVertex]=true;
			for(int j=0;j<n;j++) {
				if(edge[minVertex][j]!=0 && visited[j]==false) {
					if(edge[minVertex][j]+distance[minVertex]<distance[j]) {
						distance[j]=edge[minVertex][j]+distance[minVertex];
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(i+" "+distance[i]);
			System.out.println();
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
		Dijasktra(edge,n);
	}



}
