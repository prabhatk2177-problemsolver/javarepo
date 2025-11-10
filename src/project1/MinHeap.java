package project1;

public class MinHeap {

	final int MAX_CAP = 50;

	private int[] heapArray;

	private int capacity;

	private int curr_heap_size;

	MinHeap(int n) {
		capacity = n;
		heapArray = new int[n];
		curr_heap_size = 0;
	}

	// Helper methods
	
	private int parent (int key) {
		return (key-1)/2;
	}

	private int left(int key) {
		return 2 * key + 1;
	}

	private int right(int key) {
		return 2 * key + 2;
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// A recursive method to heapify a subtree
	// with the root at given index
	// This method assumes that the subtrees
	// are already heapified
	private void minHeapify(int key) {

		int left = left(key);
		int right = right(key);

		int smallest = key;
		if (left < curr_heap_size && heapArray[left] < heapArray[smallest])
			smallest = left;
		if (right < curr_heap_size && heapArray[right] < heapArray[smallest])
			smallest = right;

		if (smallest != key) {

			swap(heapArray, smallest, key);
			minHeapify(smallest);

		}

	}

	
	public void decreaseKey(int key, int new_val) {
		heapArray[key] = new_val;
		
		while (key !=0 && heapArray[key] < heapArray[parent(key)]) {
			swap(heapArray, key, parent(key));
			key = parent(key);
			
		}
		
		
	}
	
	  public int extractMin() {
		  if (curr_heap_size <= 0) {
	            return Integer.MAX_VALUE;
	        }
		  
		  int min = heapArray[0];
		  
		  swap(heapArray,0, curr_heap_size - 1);
		  curr_heap_size --;
		  minHeapify(0);
		  
		  
		  return min;
	  }
	
	  
	  public void deleteKey(int key) {
		  swap(heapArray, key, curr_heap_size-1);
		  curr_heap_size --;
		  minHeapify(key);
		  
	  
	  }
	  
	  public boolean insertKey(int key) {
		  if (curr_heap_size >= capacity)
			  return false;
		  
		  int i = curr_heap_size;
		  heapArray[curr_heap_size] = key;
		  curr_heap_size++;
		  
		  
		  
		  while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
			  swap(heapArray, i, parent(i));
			  i = parent(i);
		  }
		  
		  
		  return true;
		  
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
