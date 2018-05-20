
import java.util.NoSuchElementException;
import java.util.Vector;


public class TreeIterator<K extends Comparable<? super K>,V> implements java.util.Iterator<TreeItem<K,V>> {

	private BinarySearchTree<K,V> binarySearchTree;
	private TreeNode<K,V> currentNode;
	private Vector<TreeNode<K,V>> treeNodes;

	public TreeIterator(BinarySearchTree<K,V> binarySearchTree) {
		this.binarySearchTree = binarySearchTree;
		currentNode = null;
		// empty vector indicates no traversal type currently
		// selected or end of current traversal has been reached
		treeNodes = new Vector<TreeNode<K,V>>();
	} // end constructor

	public int size() {
		if (this.treeNodes == null) {
			return 0;
		} else {
			return treeNodes.size();
		}
	}


	public boolean hasNext() {
		if (this.treeNodes == null) {
			return false;
		} else {
			return !treeNodes.isEmpty();
		}
	} // end hasNext


	public TreeItem<K,V> next() throws java.util.NoSuchElementException {
		if (this.treeNodes == null) {
			throw new NoSuchElementException("No TreeItems are available...");
		}
		currentNode = treeNodes.elementAt(0);
		treeNodes.remove(0);
		return currentNode.getTreeItem();
	} // end next


	public void setPreorder() {
		this.treeNodes = new Vector<TreeNode<K,V>>();
		preorder(binarySearchTree.getRoot());
	} // setPreOrder


	
	private void preorder(TreeNode<K,V> treeNode) {
		if (treeNode != null) {
			treeNodes.add(treeNode);
			preorder(treeNode.getLeftChild());
			preorder(treeNode.getRightChild());
		} // end if
	} // end preorder

	public void setInorder() {
		this.treeNodes = new Vector<TreeNode<K,V>>();
		inorder(binarySearchTree.getRoot());
	} // end setInorder

	
	
	private void inorder(TreeNode<K,V> treeNode) {
		if (treeNode != null) {
			inorder(treeNode.getLeftChild());
			treeNodes.add(treeNode);
			inorder(treeNode.getRightChild());
		} // end if
	} // end inorder

	public void setPostorder() {
		this.treeNodes = new Vector<TreeNode<K,V>>();
		postorder(binarySearchTree.getRoot());
	} // end setPostorder

	
	
	private void postorder(TreeNode<K,V> treeNode) {
		if (treeNode != null) {
			postorder(treeNode.getLeftChild());
			postorder(treeNode.getRightChild());
			treeNodes.add(treeNode);
		} // end if
	} // end postorder
} // end TreeIterator