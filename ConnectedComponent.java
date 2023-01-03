import java.util.*;
public class ConnectedComponent {
	private static ArrayList<Integer> connectedComponentHelper(int edges[][],boolean visited[],int sv,ArrayList<Integer> list){
		visited[sv]=true;
		list.add(sv);
		for(int i=0;i<edges.length;i++) {
			if(edges[sv][i]==1 && visited[i]==false) {
				ArrayList<Integer> temp=connectedComponentHelper(edges, visited, i, list);
			}
		}
		return list;
	}
	public static ArrayList<ArrayList<Integer>> connectedComponent(int edges[][]){
		boolean visited[]=new boolean[edges.length];
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<edges.length;i++) {
			if(visited[i]==false) {
				ArrayList<Integer> list=new ArrayList<Integer>();
				ArrayList<Integer> temp=connectedComponentHelper(edges,visited,i,list);
				ans.add(temp);
			}
		}
		return ans;
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
		ArrayList<ArrayList<Integer>> ans=connectedComponent(edges);
		for(int i=0;i<ans.size();i++) {
			ArrayList<Integer> temp=ans.get(i);
			for(int j=0;j<temp.size();j++) {
				System.out.print(temp.get(i)+" ");
			}
			System.out.println();
		}
	}

}
