package project1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache1 {

	private int capacity;
	private LinkedList<Integer> ll;
	private Map<Integer, Integer> map;

	LRUCache1(int capacity) {
		this.capacity = capacity;
		ll = new LinkedList<>();
		map = new HashMap<>();
	}

	// Function to get the value for a given key
	public int get(int key) {
		int value = 0;
		if (!map.containsKey(key))
			return -1;

		else { // retrun the value and update its order in the ll ..move it to the beginning
			value = map.get(key);
			ll.remove(key);
			ll.addFirst(key);
		}

		return value;

	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			map.put(key, value);
			ll.remove(key);

		} else {
			if (map.size() >= capacity) {
				int last = ll.removeLast();
				map.remove(last);

			}
			map.put(key, value);

		}
		ll.addFirst(key);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
