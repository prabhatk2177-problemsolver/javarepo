package project1;

import java.util.LinkedList;
import java.util.Queue;

class TBTNode {
	int data;
	TBTNode left, right;
	boolean isRight;
	
	
	  public TBTNode(int item)
	    {
	        data = item;
	        left = right = null;
	    }
}

public class TBT {

	static void populateQueue(TBTNode TBTNode, Queue<TBTNode> q) {
		if (TBTNode == null)
			return;

		if (TBTNode.left != null)
			populateQueue(TBTNode.left,q);
		q.add(TBTNode);
		if (TBTNode.right != null)
            populateQueue(TBTNode.right, q);
	}
	
	 static void createThreadedUtil(TBTNode TBTNode, Queue<TBTNode> q) {
		  if (TBTNode == null)
			  return;
		  if (TBTNode.left != null)
				createThreadedUtil(TBTNode.left,q);
		  q.remove();
		  if (TBTNode.right != null)
				createThreadedUtil(TBTNode.right,q);
		  else {
			  TBTNode.right = q.peek();
	            TBTNode.isRight = true;
		  }
		  
	  }
	
	   void createThreaded(TBTNode TBTNode)
	    {
	        // Create a queue to store inorder traversal
	        Queue<TBTNode> q = new LinkedList<TBTNode>();

	        // Store inorder traversal in queue
	        populateQueue(TBTNode, q);

	        // Link NULL right pointers to inorder successor
	        createThreadedUtil(TBTNode, q);
	    }

	   TBTNode leftMost(TBTNode TBTNode)
	    {
	        while (TBTNode != null && TBTNode.left != null)
	            TBTNode = TBTNode.left;
	        return TBTNode;
	    }
 
	   void inOrder(TBTNode TBTNode)
	    {
	        if (TBTNode == null)
	            return;

	        // Find the leftmost TBTNode in Binary Tree
	        TBTNode cur = leftMost(TBTNode);

	        while (cur != null) {
	            System.out.print(" " + cur.data + " ");

	            // If this TBTNode is a thread TBTNode, then go to
	            // inorder successor
	            if (cur.isRight == true)
	                cur = cur.right;
	            else // Else go to the leftmost child in right subtree
	                cur = leftMost(cur.right);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
