/**
 * @author Mohammad Danyal
 */

/**
 * Tree Node Class
 * @param <T> Generic type
 */
public class TreeNode<T> extends java.lang.Object {

	T dataAtNode = null;
	
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	
	/**
	 * Constructor to create a new TreeNode with left and right child set to null
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		
		this.dataAtNode = dataNode;
		
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 * Makes Deep copies
	 * @param node the node
	 */
	public TreeNode(TreeNode<T> node) {
		
		this.dataAtNode = node.dataAtNode;
		
		if (node.leftChild != null) {
			
			this.leftChild = new TreeNode<T>(node.leftChild);
		}
		
		if (node.rightChild != null) {
			
			this.rightChild = new TreeNode<T>(node.rightChild);
		}
		
	}
	
	/**
	 * MUTATORS / SETTERS
	 */
	
	protected void setData(T data) {
		
		this.dataAtNode = data;
	}
	
	protected void setLeftChild(TreeNode<T> leftNode) {
		
		this.leftChild = leftNode;
	}
	
	protected void setRightChild(TreeNode<T> rightNode) {
		
		this.rightChild = rightNode;
	}
	
	
	/**
	 * ACCESSORS / GETTERS
	 */
	
	public T getData() {
		
		return dataAtNode;
	}
	
	protected TreeNode<T> getLeftChild() {
		
		return leftChild;
	}
	
	protected TreeNode<T> getRightChild() {
		
		return rightChild;
	}
}
