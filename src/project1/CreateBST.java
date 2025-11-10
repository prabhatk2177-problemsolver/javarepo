package project1;

public class CreateBST {

	
	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}
	private static Node makeBST (Node root, int value) {
		if (root == null) {
			Node newNode =  new Node(value);
			return newNode;
		}
		
		if (root.data > value) {
			root.left = makeBST(root.left, value);
		}
		else
			root.right = makeBST(root.right, value);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 18, 36, 9, 6, 12, 10, 1, 8 } ;
		Node root = null;
		for (int k : arr) {
			root =  makeBST(root, k);
		}
		inOrder(root);

	}

}
