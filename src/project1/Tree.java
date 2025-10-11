package project1;

import java.util.ArrayList;
import java.util.List;

// Node1 structure for tree
class Node1 {
    int data;
    List<Node1> children;

    Node1(int x) {
        data = x;
        children = new ArrayList<>();
    }
}

class Tree{
    // Function to add a child to a Node1
    static void addChild(Node1 parent, Node1 child) {
        parent.children.add(child);
    }

    // Function to print parents of each Node1
    static void printParents(Node1 Node1, Node1 parent) {
        if (parent == null)
            System.out.println(Node1.data + " -> NULL");
        else
            System.out.println(Node1.data + " -> " + parent.data);

        for (Node1 child : Node1.children)
            printParents(child, Node1);
    }

    // Function to print children of each Node1
    static void printChildren(Node1 Node1) {
    	if (Node1 == null)
    		return;
        System.out.print(Node1.data + " -> ");
       for (Node1 child : Node1.children)
            System.out.print(child.data + " ");
        System.out.println();

       for (Node1 child : Node1.children) {
    	    System.out.println("came here");
            printChildren(child);
       }
    }

    // Function to print leaf Node1s
    static void printLeafNode1s(Node1 Node1) {
        if (Node1.children.isEmpty()) {
            System.out.print(Node1.data + " ");
            return;
        }
        for (Node1 child : Node1.children)
            printLeafNode1s(child);
    }

    // Function to print degrees of each Node1 
    static void printDegrees(Node1 Node1, Node1 parent) {
        int degree = Node1.children.size();
        if (parent != null)
            degree++;
        System.out.println(Node1.data + " -> " + degree);

        for (Node1 child : Node1.children)
            printDegrees(child, Node1);
    }

    public static void main(String[] args) {
        // Creating Node1s
        Node1 root = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(3);
        Node1 n4 = new Node1(4);
        Node1 n5 = new Node1(5);

        // Constructing tree
        addChild(root, n2);
        addChild(root, n3);
        addChild(n2, n4);
        addChild(n2, n5);

        System.out.println("Parents of each Node1:");
        printParents(root, null);

        System.out.println("Children of each Node1:");
        printChildren(root);

        System.out.print("Leaf Node1s: ");
        printLeafNode1s(root);
        System.out.println();

        System.out.println("Degrees of Node1s:");
        printDegrees(root, null);
    }
}


