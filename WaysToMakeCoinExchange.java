
public class WaysToMakeCoinExchange {
    public static int ways(int arr[],int value) {
    	int storage[]=new int[value+1];
    	storage[0]=1;
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<=value;j++) {
    			if(j>=arr[i]) {
    				storage[j]=storage[j]+storage[j-arr[i]];
    			}
    		}
    	}
    	return storage[value];
    }
	public static void main(String[] args) {
	
	}

}
