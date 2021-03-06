
public class Tree {
	static class Node  
	{  
	    int key;  
	    Node left, right, parent;  
	} 
	  
	//--------------------
	// Create a new node
	//--------------------	  
	static Node newNode(int item)  {  
	    Node temp = new Node();  
	    temp.key = item;  
	    temp.left = null; 
	    temp.right = null;  
	    temp.parent = null;  
	    return temp;  
	}  
	  
	//--------------------
	// InOrder Traversal
	//--------------------  
	static void inorder(Node root)  {  
	    if (root != null)  
	    {  
	        inorder(root.left);  
	        System.out.print("Node : "+ root.key + " , ");  
	        if (root.parent == null)  
	        System.out.println("Parent : NULL");  
	        else
	        System.out.println("Parent : " + root.parent.key);  
	        inorder(root.right);  
	    }  
	}  
	  
	//--------------------
	// Insert a node to root with given Key
	//--------------------
	static Node insert(Node node, int key)  {
		
		// Base Case
	    if (node == null) 
	    	return newNode(key);  
	  
	    // Current moves Left
	    if (key < node.key)  {  
	    	
	    	// Recursive Insert
	        Node lchild = insert(node.left, key); 
	        
	        // Set Child
	        node.left = lchild;  
	  
	        //Set Parent
	        lchild.parent = node;  
	    }  
	    
	    // Current moves Right
	    else if (key > node.key)  {  
	    	
	    	// Recursive Insert
	        Node rchild = insert(node.right, key);  
	        
	        // Set Child
	        node.right = rchild;  
	  
	        // Set Parent
	        rchild.parent = node;  
	    }  
	  
	    // Return the (Unchanged) Node pointer 
	    return node;  
	}  
	  
	public static void main(String[] args)  
	{  
	    /* Let us create following BST  
	            50  
	        /     \  
	        30     70  
	        / \ / \  
	    20 40 60 80 */
	    Node root = null;  
	    root = insert(root, 50);  
	    insert(root, 30);  
	    insert(root, 20);  
	    insert(root, 40);  
	    insert(root, 70);  
	    insert(root, 60);  
	    insert(root, 80);  
	  
	    inorder(root);  
	} 
}  