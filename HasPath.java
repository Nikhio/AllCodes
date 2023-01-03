import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class HasPath {
	private static boolean hasPathBFSHelper(int v1,int v2,int edges[][],boolean visited[]) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(v1);
		visited[v1]=true;
		while(!queue.isEmpty()) {
			int front=queue.remove();
			for(int i=0;i<edges.length;i++) {
				if(edges[front][i]==1 && i==v2) {
					return true;
				}else {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		return false;
	}
    public static boolean hasPathBFS(int v1,int v2,int edges[][]) {
    	boolean visited[]=new boolean[edges.length];
    	return hasPathBFSHelper(v1,v2,edges,visited);
    }
    private static boolean hasPathDFSHelper(int v1,int v2,int edges[][],boolean visited[]){
    	visited[v1]=true;
    	for(int i=0;i<edges.length;i++) {
    		if(edges[v1][i]==1 && i==v2) {
    			return true;
    		}else if(edges[v1][i]==1 && visited[i]==false) {
    			boolean ans=hasPathDFSHelper(i, v2, edges, visited);
    			if(ans==true) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public static boolean hasPathDFS(int v1,int v2,int edges[][]){
    	boolean visited[]=new boolean[edges.length];
    	return hasPathDFSHelper(v1,v2,edges,visited);
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
		int v1=sc.nextInt();
		int v2=sc.nextInt();
//        boolean ans=hasPathBFS(v1,v2,edges);
        boolean ans=hasPathDFS(v1,v2,edges);
        System.out.println(ans);
       
        
	}
 
}


