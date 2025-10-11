package project1;


import java.util.ArrayList;

//Node2 Structure
class Node2 {
  int data;
  Node2 left;
  Node2 right;

  Node2(int x) {
      data = x;
      left = right = null;
  }
}

public class Inorder{
	static int count = 0;

  static void inOrder(Node2 Node2, ArrayList<Integer> res) {
      if (Node2 == null)
          return;
      
      // Traverse the left subtree first
      inOrder(Node2.left, res);
      
      // Visit the current Node2
      res.add(Node2.data);
      System.out.println(Node2.data + "---" + count++);
      
      // Traverse the right subtree last
      inOrder(Node2.right, res);
  }

  public static void main(String[] args) {
      // Create binary tree
      //       1
      //      /  \
      //    2     3
      //   / \     \
      //  4   5     6
      Node2 root = new Node2(1);
      root.left = new Node2(2);
      root.right = new Node2(3);
      root.left.left = new Node2(4);
      root.left.right = new Node2(5);
      root.right.right = new Node2(6);

      ArrayList<Integer> res = new ArrayList<>();
      inOrder(root, res);

      for(int Node2 : res)
          System.out.print(Node2 + " ");
  }
}