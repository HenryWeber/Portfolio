
public class BST {
	
	BSTNode root;
	
	public BST(){
		root = null;
	}
	
	public void insert(int i) {
		
		if (root == null)
			root = new BSTNode(i);
		else
			root.insert(i);
	}
	public String inorder(BST tree) {
		
		if (root != null)
			return root.inorder(tree.root);
		else
			return "No values";
	}
	public String descending(BST tree) {
		
		if (root != null)
			return root.descending(tree.root);
		else
			return "No values";
	}
	public String leaves(BST tree) {
		
		if (root != null)
			return root.leaves(tree.root);
		else
			return "None";
	}
	public String between(BST tree) {
		
		if (root != null)
			return root.between(tree.root);
		else
			return "No values";
	}

	public int smallestoverx(BST tree,int x, BSTNode trueRoot) {
		
		if (root != null)  
			return root.smallestoverx(tree.root, x, root);
		else
			return -1;
	}

	public int sumleaves(BST tree) {

		if (root != null)  
			return root.sumleaves(tree.root);
		else
			return -1;
	}

	public int sum(BST tree) {
		
		if (root != null)
			return root.sum(tree.root);
		else
			return -1;
	}

	public int height(BST tree) {

		if (root != null) {
			
			int height = root.height(tree.root);
			if(height % 2 == 1)
				return (height/2)+1;
			else
				return height/2;
		}
		else
			return -1;
	}

	public String and(BST tree) {

		if (root != null)  
			return root.and(tree.root);
		else
			return "None Available";
	}

	public String levelOrder(BST tree) {

		if (root != null)  
			return root.levelOrder(tree.root);
		else
			return "None Available";
	}
	public void print2D(BST tree) {
		if (root != null)  
			root.print2D(tree.root);
		//else
			//return "None Available";
	}
			
	
	
	
}
