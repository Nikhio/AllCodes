class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode arr[];
	int childCount=0;
	public TrieNode(char input){
		data=input;
		arr=new TrieNode[26];
		childCount=0;
	}
}
public class Trie {
  TrieNode root;
  public Trie() {
	  root=new TrieNode('\0');
  }
  private void insertHelper(TrieNode root,String word) {
	  if(word.length()==0) {
		  root.isTerminating=true;
		  return;
	  }
	  int index=word.charAt(0)-'a';
	  TrieNode child=root.arr[index];
	  if(child==null) {
		  child=new TrieNode(word.charAt(0));
		  root.arr[index]=child;
		  root.childCount++;
	  }
	  insertHelper(child,word.substring(1));
  }
   public void insert(String word) {
	   insertHelper(root,word);
   }
   public boolean search(String word) {
	   return search(root,word);
   }
  private boolean search(TrieNode root, String word) {
	  if(word.length()==0) {
			return root.isTerminating;
		}
		int index=word.charAt(0)-'a';
		TrieNode child=root.arr[index];
		if(child==null) {
			return false;
		}
		return search(child,word.substring(1));
  }
  public void remove(String word) {
	  remove(root,word);
  }
  private void remove(TrieNode root, String word) {
	if(word.length()==0) {
		root.isTerminating=false;
		return;
	}
	int index=word.charAt(0)-'a';
	TrieNode child=root.arr[index];
	if(child==null) {
		return;
	}
	remove(child,word.substring(1));
	//we will delete a node only if it is non terminating and it has no child:
//	if(!child.isTerminating) {
//		int numchild=0;
//		for(int i=0;i<26;i++) {
//			if(child.arr[i]!=null) {
//				numchild++;
//			}
//		}
//		if(numchild==0) {
//			root.arr[index]=null;
//			child=null;
//		}
//	}
	//if we donot want to traverse the whole loop we can maintain a childcount which will tell 
//	how many child a node have
	if(!child.isTerminating && child.childCount==0) {
		root.arr[index]=null;
      	child=null;
      	root.childCount--;
	}
 }

}
