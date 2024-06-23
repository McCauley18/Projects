import java.nio.ByteBuffer;
import java.util.Iterator;
 

public class HashTable<K,V> implements IMap<K,V> {
	Object[] table;
	int size;
	int capacity;

	/**
	 * Default constructor
	 */   
	public HashTable() {
		this(100);
	}  
	
	/**
	 * Constructor - provides the size of the array
	 * @param initialSize the initial size
	 */
	public HashTable(int initialSize) {
		this.capacity = initialSize;
		this.table = createArray(this.capacity);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Create an array that contains the positionslists that act as buckets
	 * @param size the size of the array to create
	 * @return the array that was created
	 
	 */
	private Object[] createArray(int size) {
		//TODO: COMPLETE CODE HERE
		//create new array of size "size" return, act as bucket
		Object[] newobejctArray = new Object[size];
		//iterate through the size and each index for position entry\
		//Initialize each index to contain a positionList
		for (int i=0; i<size ; i++) {
			newobejctArray[i] = new PositionList <Entry<K,V>>();
		}  
		//return created object
		return newobejctArray;
	}
	
	/**  
	 * Hash a string input
	 * @param str The input string
	 * @return the hash code for the integer
	 */
	private long hash(String str) {
		return hash(str.getBytes());
	}
	
	/**
	 * A hash an integer input
	 * @param inputInt the input input
	 * @return the hash code for the integer
	 */
	private long hash(int inputInt) {
		byte[] bytes = ByteBuffer.allocate(4).putInt(inputInt).array();
		return hash(bytes);
	}
	
	/**
	 * Calculate a hash code using the djb2 hash function
	 * This hash function was created by Dan Bernstein, however
	 * normally it works with string inputs, this has been modified
	 * to work with byte inputs
	 * @param input the input array of bytes
	 * @return a hash value for the input
	 */
	private long hash(byte[] input) {
		long hash = 5381;
		for (int i = 0; i < input.length; i++) {
			hash = ((hash << 5) + hash) + input[i];
		}
		return hash;
	}
	
	/**
	 * Calculate a hash for either a string or an Integer
	 * @param item the item to hash
	 * @return a compressed hash code for the item
	 */
	private long hash(K item) {
		if (item instanceof Integer) {
			return hash((Integer)item) % capacity;
		}
		
		if (item instanceof String) {
			return hash((String)item) % capacity;
		}
		
		return (long)item.hashCode() % capacity;
	}
	
	@Override
	/**
	 * Remove an item from the hash table
	 * @param key the key of the item to remove
	  
	 */
	public V remove(K key) {
		//TODO: COMPLETE CODE HERE
		long hashcodekey = hash(key);
		//Get the index in your hash table where the key occurs
		//(index = h(k))
		PositionList<Entry<K,V>> hashbucketlist = (PositionList<Entry<K,V>>) table[(int) hashcodekey];
	    //check if null to avoid PositionList hashbucketlist is null or them void
	    if (hashbucketlist != null) {
	    	//Get a reference to the list at the index
	    	//Iterator to iterate throught the bucket list and find the key hence from there remove per method
	        Iterator<Entry<K,V>> iteratorlist = hashbucketlist.iterator();
	        while (iteratorlist.hasNext()) {
	        	//Once in has next list entry then the found entry with correspond key is removed
	            Entry<K,V> checkentrypair = iteratorlist.next();
	            
	            //Check if the item’s key equals the given key
	            if (checkentrypair.getKey().equals(key)) {
	            	//-If so, remove the item (use the iterator.remove function)
	            	//remocve found key
	            	iteratorlist.remove();
	            	//-reduce the size
	                size--;
	                //-return the item’s value
	                return checkentrypair.getValue();
	            }
	        }
	    }
	    //Otherwise return null
	    return null;
	}

	@Override
	/**
	 * Get the value for a given key
	 * @param key the key for the item
	 * @returns the value for the associated key
	 
	 */
	public V get(K key) {
		//TODO: COMPLETE CODE HERE
		//Get the index in your hash table where the key occurs
		 long hashcodekey = hash(key);
		 //Get a reference to the list at the index
		    PositionList<Entry<K,V>> hashbucketlist = (PositionList<Entry<K,V>>) table[(int) hashcodekey];
		    if (hashbucketlist != null) {
		    	//Get an iterator over the list at index (iterator() method)
		    	//As long as the iterator has a next item:
		        for (Entry<K,V> foundindexentry : hashbucketlist) {
		        	//Check if the item’s key equals the given key
		            if (foundindexentry.getKey().equals(key)) {
		            	//-If so, return the item’s value
		                return foundindexentry.getValue();
		            }  
		        }
		    }
		    //Otherwise return null
		    return null;		
	}
   
	@Override
	/**
	 * Put an item into the hash table
	 * @param key the key for the item (unique)
	 * @param value the value for the item
	 
	 */     
	public void put(K key, V value) {
		//TODO: COMPLETE CODE HERE
		//Get the index in your hash table where the key occur
		 long hashcodekey = hash(key);
		    //Get a reference to the list at the index
		    PositionList<Entry<K,V>> hashbucketlist = (PositionList<Entry<K,V>>) table[(int) hashcodekey];
		    //Get an iterator over the list at index (iterator() method)
		    //-Check if the item’s key equals the given key
		   // -If so, change the value of that item
		    if (hashbucketlist == null) {
		    	hashbucketlist = new PositionList<>();
		        table[(int) hashcodekey] = hashbucketlist;  
		    }
		    //As long as the iterator has a next item
		    for (Entry<K,V> foundindexentry : hashbucketlist) {
		        if (foundindexentry.getKey().equals(key)) {
		        	foundindexentry.setValue(value);
		            return;
		        }
		    }
		    //Otherwise add a new Entry<K,V> last into the list
		    hashbucketlist.addLast(new Entry<>(key, value));
		    //Increment hash table size
		    size++;
	}

	@Override
	/**
	 * Returns an iterator over the keys of the hash table
	 
	 */
	public Iterator<K> keys() {
		//TODO: COMPLETE CODE HERE
		PositionList<K> positionlistkeys = new PositionList<K>();
	    for (Object o : table) {
	       //search through object with keys and return keys of all entries
	        PositionList<Entry<K,V>> hashbucketlist = (PositionList<Entry<K,V>>) o;
	        if (hashbucketlist != null) {
	        	//once the key has been
	            for (Entry<K,V> foundindexentry : hashbucketlist) {
	            	//add last list with found keys, as list 
	            	positionlistkeys.addLast(foundindexentry.getKey());
	            }
	        }
	    }
	    //return itertor
	    return positionlistkeys.iterator();
	}
  
	@Override
	/**
	 * Returns an iterator over the values in the hash table
	 */
	public Iterator<V> values() {
		PositionList<V> val = new PositionList<V>();
		for (int i = 0; i < table.length; i++) {
			PositionList<Entry<K,V>> bucket = (PositionList<Entry<K,V>>)table[i];
			Iterator<Entry<K,V>> bucketIterator = bucket.iterator();
			while (bucketIterator.hasNext()) {
				Entry<K,V> item = bucketIterator.next();
				val.addLast(item.getValue());
			}
		}
		
		return val.iterator();
	}

	@Override
	/**
	 * Returns the size of the hashtable
	 */
	public int size() {
		return this.size;
	}

	@Override
	/**
	 * Returns true if the hashtable is empty;
	 */
	public boolean isEmpty() {
		return size == 0;
	}

}
