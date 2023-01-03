import java.util.HashSet;
import java.util.Iterator;

public class Set {

	public static void main(String[] args) {
		HashSet<Integer> set=new HashSet<>();

		//set contains only unique element if elements are duplicate it will considered only once:
		//add element in the set:
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(1);
		set.add(4);
		//remove function delete the element from the hashset:
		set.remove(3);


		Iterator<Integer> it=set.iterator();
		//for iterating over the hashset because in this we have no index:
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//search
		if(set.contains(1)) {
			System.out.println("1 is present in the set");
		}
		//size() function tells the size of set
		System.out.println(set.size());

	}

}
