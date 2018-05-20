public class BinarySearchTree <K extends Comparable<? super K>, V> {

	private TreeNode<K,V> root;
     
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	
	public BinarySearchTree(TreeNode<K,V> root) {
		this.root = root;
	}

	

	public TreeNode<K, V> getRoot() {
		return root;
	}

	

	public void setRoot(TreeNode<K, V> root) {
		this.root = root;
	}
	

	public TreeItem<K,V> getRootItem() throws TreeException {
		if (this.root == null) {
			throw new TreeException("TreeException: Tree Is Empty, No Root Item");
		} else {
			return this.root.getTreeItem();
		}
	}
	
	

	public boolean isEmpty() {
		return (root == null);
	}
	
	

	public void makeEmpty() {
		this.root = null;
	}

	
	

	public TreeItem<K,V> find(K key) {
		return findItem(this.root, key);
	}

	

	private TreeItem<K,V> findItem(TreeNode<K,V> node, K key) {
		if (node == null) {
			return null; 
		} else if (node.getTreeItem().getKey().compareTo(key) == 0) {
			return node.getTreeItem(); 
		} else if (node.getTreeItem().getKey().compareTo(key) > 0) {
			return findItem(node.getLeftChild(), key); 
		} else {
			return findItem(node.getRightChild(), key);
		}
	}
	
	
	public void insert(TreeItem<K,V> treeItem) {
		this.root = insertItem(this.root, null, treeItem);
	}

	
	private TreeNode<K,V> insertItem(TreeNode<K,V> node, TreeNode<K,V> parent, TreeItem<K,V> treeItem) {
		if (node == null) {
			node = new TreeNode<K,V> (treeItem);
			node.setParent(parent);
		} else if (node.getTreeItem().getKey().compareTo(treeItem.getKey()) > 0) {
			node.setLeftChild(this.insertItem(node.getLeftChild(), node, treeItem));
		} else {
			node.setRightChild(this.insertItem(node.getRightChild(), node, treeItem));
		}
		
		return node;
	}
	

	public void delete(K key)  throws TreeException {
		setRoot(deleteItem(getRoot(), key));
	}   // end delete

	
	private TreeNode<K,V> deleteItem(TreeNode<K,V> node, K key)  {

		if (node == null)  {
			 throw new TreeException("TreeException:  Item not found" ) ;
		 } else {
		       TreeItem<K,V> treeItem = node.getTreeItem();
		       if (key.compareTo(treeItem.getKey()) == 0)  {
		    	   // item is in this node, which is the root of a subtree
		    	   node = deleteNode(node) ;   // delete the item
		       } else if (key.compareTo(treeItem.getKey()) < 0)  {
		    	   // search the left subtree
		    	   node.setLeftChild(deleteItem(node.getLeftChild(), key));
		       } else {  
		    	   // search the right subtree
		    	   node.setRightChild(deleteItem(node.getRightChild(), key));
		       } // end if
		 } // end if
		 return node;
	} // end delete
	
	private TreeNode<K,V> deleteNode( TreeNode<K,V> node)  {
	    if ((node.getLeftChild() == null) && (node.getRightChild() == null)  )  {
	    	// node is a leaf
	    	return null;
	    } else if (node.getLeftChild() == null) {  
	    	// no left child
	    	return node.getRightChild();
	    } else if (node.getRightChild() == null)  {
	    	// no right child
	    	return node.getLeftChild();
	    } else { 
    	    // there are two children:
		    TreeNode<K,V> successorNode;
	    	successorNode = findLeftmost(node.getRightChild()) ;
	    	node.setTreeItem(successorNode.getTreeItem());
	    	node.setRightChild(deleteLeftmost(node.getRightChild()));
	    	return node;
	    }   // end if
	}   // end deleteNode

	
	
	private TreeNode<K,V> findLeftmost( TreeNode<K,V> node)   {
		if ( node.getLeftChild() == null)  {
			return node;
		} else {
			return findLeftmost(node.getLeftChild()) ;
		}   // end if
	}   // end findLeftmost

	
	
	private TreeNode<K,V> deleteLeftmost( TreeNode<K,V> node)  {
		if (node.getLeftChild() == null)  {
			return node.getRightChild();
		} else {
			node.setLeftChild(deleteLeftmost(node.getLeftChild())) ;
			return node;
		}   // end if
	
	}   // end deleteLeftmost
	
	public int height(){
		return treeHeight(this.root);
	}
	
	private int treeHeight(TreeNode<K,V> root){
		int height = 0;
		if (root != null) {
			int left_height = treeHeight(root.getLeftChild());
			int right_height = treeHeight(root.getRightChild());
			height = Math.max(left_height, right_height) + 1;

		}
		return height;
		
	}
	
	public boolean isBalanced(){
		boolean result = true;
		if (root == null) {
			return result;
		}
		return isBalancedSubtree(getRoot());
	}
	
	private boolean isBalancedSubtree(TreeNode<K,V> root){
		boolean result = true;
		if (root == null) {
			return result;
		}
		int left = treeHeight(root.getLeftChild());
		int right = treeHeight(root.getRightChild());
		result = (Math.abs(left - right) <= 1) && (isBalancedSubtree(root.getLeftChild()) && isBalancedSubtree(root.getRightChild()));
		return result;
	}
	
	public void balance(){
		if(!isBalanced()){
			TreeIterator iterator = new TreeIterator(this);
			iterator.setInorder();
			Object array = new Object[iterator.size()];
			int index = 0;
			while(iterator.hasNext()) {
				
				
			}
			
		}
	}
	
	@SuppressWarnings("unused")
	private TreeNode<K,V> balanceTree(Object[] arr, int first, int last){
		
		TreeNode<K,V> node = null;
		if (first <= last) {
			int midpoint = (first + last) / 2;
			@SuppressWarnings("unchecked")
			TreeItem<K,V> item = (TreeItem<K,V>) arr[midpoint];
			node = new TreeNode<K,V>(item);
			node.setLeftChild(balanceTree(arr, first, (midpoint -1)));
			node.setRightChild(balanceTree(arr, (midpoint +1), last));

	
		}
		return node;
	}
		
	}



