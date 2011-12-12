package blatt5v3;

import static gdi.MakeItSimple.*;

public class Hashtable {
	private static final int DEFAULTARRAYLENGTH = 10;
	private static final int DEFAULTJUMPOFFSET = 3;


	private MatrikelNummer[] keys  = {null};
	private Student[] values  = {null};

	
	private double loadFactor;
	// jumpOffset : defines the number of jumps to the new hashcode
	private int jumpOffset;
	static Hashtable hashtable = new Hashtable();
	
	// constructors
	////////////////
	
	// default constructor
	public Hashtable(){
		// TODO setter getter methods instead
		this.keys = new MatrikelNummer [DEFAULTARRAYLENGTH];
		this.values = new Student[DEFAULTARRAYLENGTH];
		this.loadFactor = 0.75;
		this.jumpOffset = DEFAULTJUMPOFFSET;

	}
	public Hashtable(int length, double loadFactor, int jumpOffset){
		this.keys = new MatrikelNummer[length];
		this.values = new Student [length];
		this.loadFactor = loadFactor;
		this.jumpOffset = jumpOffset;
	}
	

	

	/**
	 * puts the key and its value into the belonging tables ( keys and values)
	 * the index is calculated by the private method h(String key) to get the
	 * hashcode if the key exists in the hashtable, remove the old value and put
	 * the new value, return the old value if not, return null, if the key is an
	 * empty string return null and do nothing
	 * 
	 * 
	 * @param key
	 * @param value
	 * @return old value of a given key or null
	 */
	public Student put(MatrikelNummer key, Student value) {

		Student oldValue;
	
		// get the hashcode of the key and calculate the hashtable index

		int hashIndex = key.hashCode()%keys.length;
		
		if (hashIndex >= 0) {
			// check whether key exists in the hashtable
			if (this.containsKey(key)) {

				// check whether a collision occurred, if yes, then check jump to the
				// next
				while (!key.equals(keys[hashIndex])) {

					// probing: get the next hashcode
					hashIndex = probing(hashIndex);

				}
				// replace the old value with the new value and return the old
				// value
				oldValue = values[hashIndex];
				values[hashIndex] = value;

				return oldValue;

			} else {
				// check whether index is already occupied --> collision
				while (keys[hashIndex] != null) {
					// probing: get the next hashcode
					println(key+" Collision with "+ keys[hashIndex]);
					hashIndex = probing(hashIndex);
				}
				// store key and value in the arrays: keys and values
				keys[hashIndex] = key;
				values[hashIndex] = value;

				

				// check whether the loadFactor is exceeded, if yes rehash the
				// hashtable
				if (this.loadFactor < getActualLoadFactor()) {
					println("**** REHASH ***");
					rehash();
				}

				return null;
			}
		}

		// key is an invalid number (negative) do nothing
		return null;
	}

	/**
	 * Returns the value to which the specified key is mapped in this hashtable
	 * 
	 * @param key
	 * @return the value to which the key is mapped in this hashtable null if
	 *         the key is not mapped to any value in this hashtable.
	 */
	public Student get(MatrikelNummer key) {

		// get the hashcode of the key
		int hashcode = key.hashCode();

		if (containsKey(key)) {
			// check whether a collision occured, if yes, then check jump to the
			// next
			while (!key.equals(keys[hashcode])) {

				// probing: get the next hashcode
				hashcode = probing(hashcode);

			}
			return values[hashcode];

		}
		// key does not exist
		return null;

	}
	/**
	 * removes the key and its mapped value and rehashes the Hashtable
	 * 
	 * @param key
	 * @return
	 */
	public boolean removeKey(MatrikelNummer key){
		
		if(containsKey(key)){
			
			// get the hashcode of the key
			int hashcode = key.hashCode();
			
			// check whether a collision occured, if yes, then check jump to the
			// next
			while (!key.equals(keys[hashcode])) {

				// probing: get the next hashcode
				hashcode = probing(hashcode);

			}
			
			// remove key and object
			keys[hashcode] = null;
			values[hashcode] = null;;
			
			// reorganize the hashtable
			reorganize();
			return true;
			
		}
		// if key does not exist: nothing to remove
		return false;
		
	}

	/**
	 * Tests if the specified key is a key in this hashtable.
	 * 
	 * @param possible
	 *            key
	 * @return true if and only if the specified object is a key in this
	 *         hashtable, false otherwise.
	 */
	public boolean containsKey(MatrikelNummer key) {

		for (int i = 0; i < keys.length; i++) {
			if (key.equals(keys[i])) {
				return true;
			}
		}
		// key does not exist
		return false;

	}

	/**
	 * Returns true if this Hashtable maps one or more keys to this value.
	 * 
	 * @param value
	 *            whose presence in this Hashtable is to be tested.
	 * @return true if this map maps one or more keys to the specified value.
	 */
	public boolean contains(Student value) {

		for (int i = 0; i < values.length; i++) {
			if (value.equals(values[i])) {
				return true;
			}
		}

		// value does not exist
		return false;
	}

	/**
	 * returns false if at least one element is stored in the hashtable
	 * 
	 * @return
	 */
	public boolean isEmpty() {

		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				return false;
			}
		}
		return true;

	}

	/**
	 * load factor is calculated by the number of elements stored in the
	 * hashtable divided by the length of the hashtable necessary for rehashing
	 * the hashtable once the load factor is exceeded
	 * 
	 * @return
	 */
	public double getActualLoadFactor() {
	
		return (double) (size()) / (double) keys.length;
	
	}
	/**
	 * returns the number of stored elements in the hashtable
	 * 
	 * @return
	 */
	public int size() {

		int size = 0;

		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				size++;
			}
		}
		return size;

	}

	/**
	 * Clears this hashtable so that it contains no keys.
	 * 
	 * @return ADTHashtable with no keys
	 */
	public Hashtable clear() {

		this.keys = new MatrikelNummer[keys.length];
		this.values = new Student[values.length];

		return this;

	}

	/**
	 * prints each index, key and value of the the hashtable
	 */
	public void print() {
		System.out.println("Index\tKey\tValue");
		for (int i = 0; i < keys.length; i++) {
			System.out.printf("%s\t%s\t%s\n", i, keys[i], values[i]);
		}
		
		System.out.println();

	}

	/**
	 * this hash function summarizes all the letters(characters) of a given key
	 * 
	 * @param key
	 * @return
	 */
	private int h(String key) {
	
		int sum = 0;
	
		// empty string cannot be stored in the hashtable
		if (key.length() == 0) {
	
			return -1;
		} else {
	
			for (int i = 0; i < key.length(); i++) {
				sum = sum + key.charAt(i);
			}
			sum = sum % keys.length;
		}
		return sum;
	
	}
	/**
	 * get the next hashcode, if a collision occurs
	 * 
	 * @param hashcode
	 * @return
	 */
	private int probing(int hashcode) {
	
		return (hashcode + jumpOffset) % keys.length;
	
	}
	/**
	 * clear the hashtable, doubles the length of the hashtable and puts all the
	 * keys and values again
	 * 
	 */
	private void rehash() {

		MatrikelNummer[] oldKeys = keys;
		Student[] oldValues = values;

		// clears the hashtable and doubles the length
		keys = new MatrikelNummer[keys.length * 2];
		values = new Student[values.length * 2];

		// put all the elements to the new reorganized hashtable
		for (int i = 0; i < oldKeys.length; i++) {
			// put only elements with a valid key
			if(oldKeys[i] != null){
				put(oldKeys[i], oldValues[i]);
			}
			
		}

	}
	/**
	 * like the method rehash, cut length of array into halves instead, if actual loadFactor under the given loadfactor
	 */
	private void reorganize(){
		
		MatrikelNummer[] oldKeys = keys;
		Student[] oldValues = values;

		
		this.clear();

		// put all the elements to the new reorganized hashtable

		for (int i = 0; i < oldKeys.length; i++) {
			// put only elements with a valid key
			if(oldKeys[i] != null){
				put(oldKeys[i], oldValues[i]);
			}
			
		}
	}

}
