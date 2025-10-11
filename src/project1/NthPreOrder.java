package project1;

//Java program for  nth Node4 of
//preorder traversals

class Node4 {
	int data;
	Node4 left, right;

	Node4(int x) {
		data = x;
		left = null;
		right = null;
	}
}

class NthPreOrder {
	static int index  = 1;

	// Given a binary tree, print its nth
	// preorder Node4.
	
	//Preorder == Root, Left, Right
	static int nthPreorder(Node4 root,  int desired) {

		if (root == null)
			return -1;
		
		if (index == desired) {
			System.out.println("GOTCHA" + root.data);
			return root.data; 
			
		}
		System.out.println(root.data +   "--->"  + index);
		index ++;
		/*nthPreorder(root.left, desired);
		nthPreorder(root.right,  desired); */
		
		int left = nthPreorder(root.left,  desired);
		if (left != -1)
			return left;
		int right = nthPreorder(root.right,  desired);
		

		return right; 
	}

	public static void main(String[] args) {

		// hard coded binary tree.
		// 10
		// / \
		// 20 30
		// / \
		// 40 50
		Node4 root = new Node4(10);
		root.left = new Node4(20);
		root.right = new Node4(30);
		root.left.left = new Node4(40);
		root.left.right = new Node4(50);
		//nthPreorder(root,4 );
		// int[] n = {4};

	    System.out.println(nthPreorder(root,5 ));
	}
}