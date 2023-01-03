
public class TrieUse {

	public static void main(String[] args) {
		Trie t=new Trie();
		t.insert("abc");
		t.insert("news");
		t.insert("no");
		System.out.println(t.search("abc"));
		t.remove("abc");
		System.out.println(t.search("abc"));
     
     
	}

}
