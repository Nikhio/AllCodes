import java.util.ArrayList;
public class Map<K,V> {
	ArrayList<MapNode<K,V>> bucket=new ArrayList<>();
	int size;
	int numBuckets;
	public Map() {
		size=0;
		numBuckets=5;
		for(int i=0;i<numBuckets;i++) {
			bucket.add(null);
		}
	}
	//getBucketIndex return a integer value regarding any type of key
	private int getBucketIndex(K key) {
		int hashcode=key.hashCode();
		return hashcode%numBuckets;
	}
	public double loadFactor() {
		return (1.0*size)/numBuckets;
	}
	private void rehash() {
		System.out.println("Rehashing .."+loadFactor()+size+" "+numBuckets);
		ArrayList<MapNode<K,V>> temp=bucket;
		bucket=new ArrayList<>();
		for(int i=0;i<2*numBuckets;i++) {
			bucket.add(null);
		}
		size=0;
		numBuckets=2*numBuckets;
		for(int i=0;i<temp.size();i++) {
			MapNode<K,V> head=temp.get(i);
			while(head!=null) {
				K key=head.key;
				V value=head.value;
				insert(key, value);
				head=head.next;
			}
		}
	}
	public void insert(K key,V value) {
		int num=getBucketIndex(key);
		MapNode<K,V> head=bucket.get(num);
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		head=bucket.get(num);
		MapNode<K,V> newNode=new MapNode<>(key,value);
		size++;
		newNode.next=head;
		double loadFactor=(1.0*size)/numBuckets;
		if(loadFactor>0.7) {
			rehash();
		}
		bucket.set(num, newNode);
	}
	public int size() {
		return size;
	}
	public V getValue(K key) {
		int num=getBucketIndex(key);
		MapNode<K,V> head=bucket.get(num);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	public V remove(K key) {
		int num=getBucketIndex(key);
		MapNode<K,V> head=bucket.get(num);
		MapNode<K,V> prev=null;
		while(head!=null) {
			if(head.key.equals(key)) {
				size--;
				if(prev==null) {
					bucket.set(num,head.next);
				}else {
					prev.next=head.next;
				}
				return head.value;
			}
			prev=head;
			head=head.next;

		}
		return null;
	}
}
