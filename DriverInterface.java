import java.util.Vector;

public interface DriverInterface {

	
		
		public Vector<TreeItem<Integer,String>> getVectorOfTreeItems();
		
		public BinarySearchTree<Integer,String> createAndPopulateBST(Vector<TreeItem<Integer, String>> treeItems);

}
