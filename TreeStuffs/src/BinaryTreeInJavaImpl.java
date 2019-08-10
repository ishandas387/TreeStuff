/**
 * implement binary tree in java. 
 * @author ishan
 *
 */
public class BinaryTreeInJavaImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree bt = new BinaryTree();
		bt.addValue(4);
		bt.addValue(2);
		bt.addValue(12);
		bt.addValue(3);
		bt.addValue(1);
		bt.addValue(14);
		
		System.out.println(bt.contains(4));
		bt.getHeight();
		System.out.println("********");
		
		bt.postTraverse();

		System.out.println("****non recursive****");
		
		//bt.postTraverseNonRecursive();
		
		System.out.println("***********");

		bt.levelOrderTraversal();
		
		System.out.println("********");

		bt.leverOrderTraversalQueue();
		System.out.println("*****number of full node***");

		System.out.println(bt.fullNodeCount());
		int[] ar ={1,2,3,4,5,6,7};
		Node arryToBst = bt.arryToBst(ar, 0, ar.length-1);
		System.out.println("********");
		bt.printTheNewArrBst(arryToBst);
		System.out.println("********");		
		
		System.out.println("***############****");	
		BinaryTree treeHalf = new BinaryTree(); 
        Node NewRoot = null; 
        treeHalf.root = new Node(2); 
        treeHalf.root.left = new Node(7); 
        treeHalf.root.right = new Node(5); 
        treeHalf.root.left.right = new Node(6); 
        treeHalf.root.left.right.left = new Node(1); 
        treeHalf.root.left.right.right = new Node(11); 
        treeHalf.root.right.right = new Node(9); 
        treeHalf.root.right.right.left = new Node(4); 
   
        System.out.println("the inorder traversal of tree is "); 
        treeHalf.inTraverse(); 
   
        NewRoot = treeHalf.removeHalfNodes(treeHalf.root); 
   
        System.out.print("\nInorder traversal of the modified tree \n"); 
        treeHalf.inTraverse(); 
	}

}
