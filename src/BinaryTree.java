public class BinaryTree {
	
	/*
	 * Once you have the tree, you should compute and output the average depth 
	 * of all the leaves in the tree and the maximum depth of all the leaves. 
	 * To do this, you will need three recursive subroutines: one to count the leaves, 
	 * one to find the sum of the depths of all the leaves, and one to find the maximum
	 * depth. The latter two subroutines should have an int-valued parameter,
	 * depth, that tells how deep in the tree you've gone. When you call this
	 * routine from the main program, the depth parameter is 0; when you call
	 * the routine recursively, the parameter increases by 1.
	 */
	
	public static void main(String[] args) {
		// Insert 1023 itens to the tree
		for(int i = 0; i < 1022; i++) {
			treeInsert(Math.random());
		}
	}
	
	private static TreeNode root; 	// Pointer to the root node in the tree.
									// When the tree is empty, root is null.
	
	private static class TreeNode{
		
		double item; // The data in this node.
		TreeNode left; // Pointer to left subtree.
		TreeNode right; // Pointer to right subtree.
		TreeNode(double dbl) {
			// Constructor. Make a node containing str.
			// Note that left and right pointers are null.
			item = dbl;
		}
	} // end class TreeNode
	
	/**
	* Return true if item is one of the items in the binary
	* sort tree to which root points. Return false if not.
	* @param root the node that will be considered as the root
	* @param item the content that will be considered
	*/
	static boolean treeContains( TreeNode root, double item ) {
		if ( root == null ) {
			// Tree is empty, so it certainly doesn’t contain item.
			return false;
		} else if ( item == root.item ) {
			// Yes, the item has been found in the root node.
			return true;
		} else if ( item < root.item ) {
			// If the item occurs, it must be in the left subtree.
			return treeContains( root.left, item );
		} else {
			// If the item occurs, it must be in the right subtree.
			return treeContains( root.right, item );
		}
	} // end treeContains()
	
    /**
     * Add the item to the binary sort tree to which the global variable 
     * "root" refers.  (Note that root can't be passed as a parameter to 
     * this routine because the value of root might change, and a change 
     * in the value of a formal parameter does not change the actual parameter.)
     */
    private static void treeInsert(double newItem) {
        if ( root == null ) {
                // The tree is empty.  Set root to point to a new node containing
                // the new item.  This becomes the only node in the tree.
            root = new TreeNode( newItem );
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if ( newItem  < runner.item ) {
                    // Since the new item is less than the item in runner,
                    // it belongs in the left subtree of runner.  If there
                    // is an open space at runner.left, add a new node there.
                    // Otherwise, advance runner down one level to the left.
                if ( runner.left == null ) {
                    runner.left = new TreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.left;
            }
            else {
                    // Since the new item is greater than or equal to the item in
                    // runner it belongs in the right subtree of runner.  If there
                    // is an open space at runner.right, add a new node there.
                    // Otherwise, advance runner down one level to the right.
                if ( runner.right == null ) {
                    runner.right = new TreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.right;
            }
        } // end while
    }  // end treeInsert()

}
