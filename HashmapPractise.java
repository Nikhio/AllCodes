import java.util.HashMap;
public class HashmapPractise {
	public  static void main(String[] args) {
		HashMap<Character,Integer> map=new HashMap<>();
		map.put('a', 97);
		map.put('b', 98);
		map.put('c', 99);
		map.put('d', 100);
		int k=map.getOrDefault('a',1110);
		int k1=map.get('a');
		System.out.println(k);
		System.out.println(k1);
	}

}
class pair implements
