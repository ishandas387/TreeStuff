import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//bst
public class BinaryTree {
	Node root;

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (current.value > value) {
			current.left = addRecursive(current.left, value);

		} else if (current.value < value) {
			current.right = addRecursive(current.right, value);

		} else if (current.value == value) {
			return current;
		}

		return current;
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return current.value > value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);

	}

	public boolean contains(int value) {
		return containsNodeRecursive(root, value);
	}

	public void addValue(int value) {
		root = addRecursive(root, value);
	}

	// tree traversal
	// Depth first search

	// pre order postorder and in order

	// inorder
	private void inOrderTraversal(Node node) {
		if (null != node) {
			inOrderTraversal(node.left);
			System.out.println(node.value);
			inOrderTraversal(node.right);
		}
	}

	private void preOrderTraversal(Node node) {
		if (null != node) {
			System.out.println(node.value);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}

	}
	
	private void preOrderTraversalNonRecursive(Node node) {
		Stack<Node> st = new Stack<>();
		if (null != node) {
			st.push(node);
			while(!st.isEmpty()){
				Node temp = st.pop();
				
				System.out.println(temp.value);
				if(temp.right != null){
					st.push(temp.right);
					
				}
				if(temp.left != null){
					st.push(temp.left);
					
				}
				
			}
		}

	}

	private void postOrderTraversal(Node node) {
		if (null != node) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.value);
		}
	}
	
	private void postOrderTraversalNonRecursive(Node node) {
		Stack<Node> st = new Stack<>();
		if (null != node) {
			st.push(node);
			while(!st.isEmpty()){
				Node temp = st.peek();
				if(temp.left != null){
					st.push(temp.left);
					
				}
				if(temp.right != null){
					st.push(temp.right);
					
				}
				
				System.out.println(temp.value);
				st.pop();
				
			}
		}

	}
	
	public void inTraverse(){
		inOrderTraversal(root);
	}
	
	public void preTraverse(){
		preOrderTraversal(root);
	}
	

	public void preTraverseNonRecursive(){
		preOrderTraversalNonRecursive(root);
	}
	
	public void postTraverse(){
		postOrderTraversal(root);
	}
	
	public void postTraverseNonRecursive(){
		postOrderTraversalNonRecursive(root);
	}
	
	private int findMax(Node root){
		if(root == null){
			return 0;
		}
		int max =root.value;
		int left = findMax(root.left);
		int right = findMax(root.right);
		if(left> max){
			max = left;
		}
		if(right>max){
			max = right;
					
		}
		return max;
	}
	public int findMax(){
		return findMax(root);
	}
	//height of the tree
	private int getHeight(Node root){
		if(null == root){
			return 0;
		}
		int maxLeft = getHeight(root.left);
		
		int maxRight = getHeight(root.right);
		
		if(maxLeft>maxRight){
			return maxLeft+1;
			
					
		}else{
			return maxRight+1;
					
		}
		
	}
	public void getHeight(){
		System.out.println(getHeight(root));
	}
	
	//level order traversal
	private void levelOrderTraversal(Node node){
		int h = getHeight(root);
		
		for(int i =1 ; i<=h;i++){
			print(root,i);
		}
		
	}
	//level order traversal with queue
	private void leverOrderTraversalQueue(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node poll = q.poll();
			System.out.println(poll.value);
			if(poll.left!=null){
				q.add(poll.left);
			}
			if(poll.right!=null){
				q.add(poll.right);
			}
		}
	}

	private void print(Node root2, int i) {
		if(root2==null){
			return;
		}
		if(i==1){
			System.out.println(root2.value);
		}
		else if(i>1){
			print(root2.left,i-1);
			print(root2.right,i-1);
			
	
	}
		
		
	}

	public void levelOrderTraversal() {
		levelOrderTraversal(root);
		
	}
	
	public void leverOrderTraversalQueue(){
		leverOrderTraversalQueue(root);
	}
	
	public void deleteNode(){
		
	}
	
	/**
	 * Find number of full nodes in the tree
	 */
	
	private int fullNodeCount(Node root){
		if(root == null){
			return 0;
		}
		int count =0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node poll = q.poll();
		
			if(poll.left != null && poll.right!=null){
				count++;
			}
			if(poll.left !=null){
				q.add(poll.left);
			}
			
			if(poll.right !=null){
				q.add(poll.right);
			}
			
		}
		return count;
	}
	
	public int fullNodeCount(){
		return fullNodeCount(root);
	}
	
	public Node arryToBst(int[] ar, int start, int end){
		if(start>end){
			return null;
		}
		int mid = (start + end)/2;
		Node n = new Node(ar[mid]);
		n.left = arryToBst(ar,0,mid-1);
		n.right=arryToBst(ar, mid+1, end);
		return n;
	}
	public void printTheNewArrBst(Node root){
		inOrderTraversal(root);
	}

	public Node removeHalfNodes(Node node) {
		if(node == null){
			return null;
		}
		node.left = removeHalfNodes(node.left);
		node.right = removeHalfNodes(node.right);
		if(node.left == null && node.right==null){
			return node;
		}
		if(node.left==null)
		{
			return node.right;
		}
		else if(node.right == null){
			return node.left;
		}
		return node;
		
	}
	
	//check if a tree is bst
	public boolean checkIfBst(Node root){
		int min= Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return isBst(root, min,max);
	}

	private boolean isBst(Node root2, int min, int max) {
		
		if(root2 == null){
			return true;
		}
		if(root2.value <= min && root2.value > max){
			return false;
		}
		return isBst(root2.left, min, root.value) && isBst(root2.right, root.value, max);
	}
	
	
}
