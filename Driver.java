import java.util.Vector;

public class Driver implements DriverInterface {
	 private TreeItem<Integer, String>[] treeItems;

	@Override
	public Vector<TreeItem<Integer, String>> getVectorOfTreeItems() {
		Vector<TreeItem<Integer, String>> vector_tree = new Vector<TreeItem<Integer, String>>();

        final int max_count = 131071;
      


        for (int i = 0; i < max_count; i++)

        {

            int key = (int) ((int)i+10 * (Math.round(Math.random() * 1000)));

            String value = "String " +  key;

            TreeItem<Integer, String> item = new TreeItem<Integer, String>(key, value);

            vector_tree.add(item);

            //return treeVector;

        }

        return vector_tree;
    }


	@Override
	public BinarySearchTree<Integer, String> createAndPopulateBST(Vector<TreeItem<Integer, String>> treeItems) {
		 BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();

	        for (TreeItem<Integer, String> treeItem : treeItems) {

	            // add each tree item to BinarySearchTree
	            tree.insert(treeItem);
	        }


	        return tree;
	    }


	    public static void main(String args[]) {

	        Driver d = new Driver();

	        Vector<TreeItem<Integer, String>> treeItems = d.getVectorOfTreeItems();

	        BinarySearchTree<Integer, String> tree = d.createAndPopulateBST(treeItems);
	        System.out.println("Height of the Binary Search Tree : " + tree.height());

	        tree.balance();
	        System.out.println("Height of the Binary Search Tree after Balancing : " + tree.height());


	    }
	}

