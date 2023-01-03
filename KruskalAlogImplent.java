import java.util.*;
public class KruskalAlogImplent {
	public static int findParent(int v,int parent[]){
		if(parent[v]==v) {
			return v;
		}
		return findParent(parent[v],parent);
	}
	public static void Kruskal(Edge input[],int n) {
		Arrays.sort(input);
		Edge output[]=new Edge[n-1];
		int parent[]=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		int count=0;
		int j=0;
		while(count!=n-1) {
			Edge curr=input[j];
			int sourceV=findParent(curr.sourse,parent);
			int destV=findParent(curr.dest,parent);
			if(sourceV!=destV) {
				output[count]=curr;
				count++;
				parent[sourceV]=destV;
			}
			j++;
		}
		for(int k=0;k<n-1;k++) {
			if(output[k].sourse<=output[k].dest) {
				System.out.print(output[k].sourse+" "+output[k].dest+" "+output[k].weight);
			}else {
				System.out.print(output[k].dest+" "+output[k].sourse+" "+output[k].weight);
			}
		}

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		Edge input[]=new Edge[e];
		for(int i=0;i<e;i++) {
			Edge e1=new Edge();
			e1.sourse=sc.nextInt();
			e1.dest=sc.nextInt();
			e1.weight=sc.nextInt();
			input[i]=e1;
		}
		Kruskal(input,n);

	}

}
class Edge implements Comparable<Edge>{
	int sourse;
	int dest;
	int weight;
	public int compareTo(Edge o) {
		return this.weight-o.weight;//sorting in increasing order.
		//return o.weight-this.weight sorting in decreasing order.
	}

}