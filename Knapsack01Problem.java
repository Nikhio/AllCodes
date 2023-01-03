
public class Knapsack01Problem {
	//Recursive Approach--> Brute force Approach(solution)
	public static int knapsack(int weights[],int values[],int n,int maxWeight) {
		return knapsack(weights,values,n,maxWeight,0);
	}
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight, int i) {
        //base case -->
		/* when the value if i==weight.length or when the maxWeight==0 that means 
		 * we have no space left for other item to store
		 */
		if( i==weights.length || maxWeight==0 ) {
			return 0;
		}
		//one more base can be this n-->number of items
//		if(n==0) {
//			return 0;
//		}
		if(weights[i]>maxWeight) {
			return knapsack(weights,values,n-1,maxWeight,i+1);
		}else {
			//include ith item
			int op1=values[i]+knapsack(weights,values,n-1,maxWeight-weights[i],i+1);
			//don't include the ith item 
			int op2=knapsack(weights,values,n-1,maxWeight,i+1);
			return Math.max(op1, op2);
		}
	}
	public static void main(String[] args) {
       int weight[]= {1,2,4,5};
       int []values= {5,4,8,6};
       int maxWeight=5;
       int n=4;
       System.out.println(knapsack(weight, values, n, maxWeight));
	}
}
