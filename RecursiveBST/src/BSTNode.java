import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BSTNode {
	
	int data, parent;
	BSTNode left, right;
	
	String result = "";
	int resultInteger = -1;
	int llargest = 0;
	int rlargest = 0;
	final static int COUNT = 4;
	
	public void resetResult() {
		this.result = "";
		this.resultInteger = -1;
	}
	
	public BSTNode(int v){
		data = v;
		left = null;
		right = null;
		parent = v;
	}
	
	public void insert(int v){
		if (v < data){
			if (left == null){
				BSTNode child = new BSTNode(v);
				child.parent = data;
				left = child;
			}
			else 
				left.insert(v);
		}
		else if (v > data){
			if (right == null){
				BSTNode child = new BSTNode(v);
				child.parent = data;
				right = child;
			}
			else 
				right.insert(v);
		}	
	}
	
	public String inorder(BSTNode tree){
		
		resetResult();
		
		if (left != null)
			 result += tree.left.inorder(tree.left);
		
		result += data + ", ";
		
		if (right != null)
			result += tree.right.inorder(tree.right);
		
		return result;
	}
	
	public String descending(BSTNode tree){
		
		resetResult();
		
		if (right != null) 
			 result += tree.right.descending(tree.right);
			
		result += data + ", ";
		
		if (left != null) 
			result += tree.left.descending(tree.left);
		
		return result;
	}

	public String between(BSTNode tree) {
		
		resetResult();
		
		if(tree.data > 50 && tree.data < 100 )
			result += data + " ";
		
		if (right != null)
			 result += tree.right.between(tree.right);
		
		if (left != null)
			result += tree.left.between(tree.left);
		
		return  result;
	}
	
	public String and(BSTNode tree) {
		
		resetResult();
				
		if (left != null) 
			result += tree.left.and(tree.left);
		
		if (right != null) 
			result += tree.right.and(tree.right);
		
		if(right == null && left == null)
			result += data + " ";
		
		return result;
	}
	public int smallestoverx(BSTNode tree, int x, BSTNode trueRoot) {
		
		resetResult();
		
		resultInteger = parent;
		
		//left leaves
		if(left ==null && right == null && tree.parent < x && x < trueRoot.data)
			resultInteger = trueRoot.data;
	
		//if small enough
		if((tree.data > x && tree.left == null)  || (tree.data > x && tree.left.data < x)){	
			resultInteger = data;
			
			//right leaves
			if(tree.data > x && tree.data > trueRoot.data && right == null && parent < x)
				return resultInteger;
			
		}
		if(tree.right != null && tree.data <= x  )
			return tree.right.smallestoverx(tree.right, x, trueRoot);		
		
		if(tree.left != null && tree.data > x)  
			return tree.left.smallestoverx(tree.left , x, trueRoot);
		
		return resultInteger;
	}
	
	public String leaves(BSTNode tree) {
		
		resetResult();
		
		if(right == null && left == null)
			result += ", " + data;
		
		if (left != null)
			result += left.leaves(tree.left);
		
		if (right != null)
			result += right.leaves(tree.right);

		return result;
	}

	public int sumleaves(BSTNode tree) {
		
		resetResult();
		
		if(right == null && left == null)
			resultInteger += data;
		
		if (right != null) 
			resultInteger += tree.right.sumleaves(tree.right);
			
		if (left != null) 
			resultInteger += tree.left.sumleaves(tree.left);
		
		return resultInteger;
	}

	public int sum(BSTNode tree) {

		resetResult();
		
		if (right != null) 
			 resultInteger += tree.right.sum(tree.right);
			
		resultInteger += data;
		
		if (left != null) 
			resultInteger += tree.left.sum(tree.left);
	
		return resultInteger;
	}

	public int height(BSTNode tree) {
		
		if(left != null) {
			llargest += 1;	
			llargest += tree.left.height(tree.left);
		}
		
		if(right != null)  {
			rlargest += 1;
			rlargest += tree.right.height(tree.right);
		}
		
		return 1 + Math.max(rlargest, llargest);		
	}

	public String levelOrder(BSTNode root) {
		String returnValue = "";
		Queue<BSTNode> queue=new LinkedList<BSTNode>();
		 queue.add(root);
		 while(!queue.isEmpty())
		 {
			 BSTNode tempNode = queue.poll();
			 returnValue += ", " + tempNode.data;
			 if(tempNode.left!=null)
				 queue.add(tempNode.left);
			 if(tempNode.right!=null)
				 queue.add(tempNode.right);
		 }
		return returnValue;
	}
	static void print2DUtil(BSTNode root, int space)  
	{  
	    if (root == null)  
	        return;  
	  
	    // Increase distance between levels  
	    space += COUNT;  
	  
	    // Process right child first  
	    print2DUtil(root.right, space);  
	  
	    // Print current node after space  
	    // count  
	    System.out.print("\n");  
	    for (int i = COUNT; i < space; i++)  
	        System.out.print(" ");  
	    System.out.print(root.data + "\n");  
	  
	    // Process left child  
	    print2DUtil(root.left, space);  
	}  
	  
	// Wrapper over print2DUtil()  
	static void print2D(BSTNode root)  
	{  
	    // Pass initial space count as 0  
	    print2DUtil(root, 0);  
	}  

}
