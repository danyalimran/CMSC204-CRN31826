/**
 * @author Mohammad Danyal
 */

import java.util.ArrayList;

/**
 * MorseCodeTree Class
 */
public class MorseCodeTree extends java.lang.Object implements LinkedConverterTreeInterface<java.lang.String> {

	TreeNode<String> treeRoot;
	
	/**
	 * This constructor calls the buildTree() method
	 */
	public MorseCodeTree() {
		
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		
		return treeRoot;
	}

	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		
		this.treeRoot = newNode;
	}

	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		// TODO Auto-generated method stub
		
		// Call the recursive addNode() method
		addNode(treeRoot, code, result);
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * A '.' (dot) means traverse to the left
	 * A "-" (dash) means traverse to the right
	 * The code ".-" would be stored as the right child of the left child
	 * of the root.
	 * 
	 * Algorithm for the recursive method:
	 * 1. If there is only 1 character
	 * 		a. If the character is '.' (dot) store to the left of the current root.
	 * 		b. If the character is a "-" (dash) store to the right of the current root.
	 * 		c. return 2
	 * 
	 * 2. If there is more than 1 character:
	 * 		a. If the first character is "." (dot) new root becomes the left child.
	 * 		b. If the first character is "-" (dash) new root becomes the right child.
	 * 		c. new code becomes all remaining characters in the code (beyond the first character)
	 * 		d. Call addNode(new root, new code, letter)
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		
		int subStringIndex = 1;
		
		TreeNode<String> addLeftNode = new TreeNode<>(letter);
		TreeNode<String> addRightNode = new TreeNode<>(letter);
		
		// Base Case
		if (code == null) {
			
			return;
		}
		
		// Case 1: If there is only 1 character:
		if (code.length() == 1) {
			
			// If the character is a "." (dot)
			if (letter.equals(".")) {
				
				root.setLeftChild(addLeftNode);
			}
			
			// If the character is a "-" (dash)
			else if (letter.equals("-")) {
				
				root.setRightChild(addRightNode);
			}
			
			return;
		}
		
		// Case 2: If there is more than 1 character
		else if (code.length() > 1) {
			
			// If the character is a "." (dot)
			if (code.charAt(0) == '.') {
				
				root = root.getLeftChild();
			}
			
			// If the character is a "-" (dash)
			else if (code.charAt(0) == '-') {
				
				root = root.getRightChild();
			}
			
			// Recursive call
			addNode(root, code.substring(subStringIndex), letter);
		}
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		
		// Return the recursive fetchNode() method
		return fetchNode(treeRoot, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		
		int subStringIndex = 1;
		String letterAtNode = "";
		
		// Base Case
		if (code.length() == 1) {
			
			if (code.charAt(0) == '.' && root != null && root.getLeftChild() != null) {
				
				letterAtNode = root.getLeftChild().getData();
				
				return letterAtNode;
			}
			
			else if (code.charAt(0) == '-' && root != null &&root.getRightChild() != null) {
				
				letterAtNode = root.getRightChild().getData();
				
				return letterAtNode;
			}
		}
		
		if (code.length() != 0) {
			
			if (code.charAt(0) == '.') {
				
				if (root != null) {
					
					root = root.getLeftChild();
				}
				
				letterAtNode = fetchNode(root, code.substring(subStringIndex));
			}
			
			else if (code.charAt(0) == '-') {
				
				if (root != null) {
					
					root = root.getRightChild();
				}
				
				letterAtNode = fetchNode(root, code.substring(subStringIndex));
			}
			
		}
		
		return letterAtNode;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		
		// Initialize root (an empty String)
		TreeNode<String> root = new TreeNode<String>("");
		
		// Letters of the Alphabet to add in Tree
		TreeNode<String> a = new TreeNode<String>("a");
		TreeNode<String> b = new TreeNode<String>("b");
		TreeNode<String> c = new TreeNode<String>("c");
		TreeNode<String> d = new TreeNode<String>("d");
		TreeNode<String> e = new TreeNode<String>("e");
		TreeNode<String> f = new TreeNode<String>("f");
		TreeNode<String> g = new TreeNode<String>("g");
		TreeNode<String> h = new TreeNode<String>("h");
		TreeNode<String> i = new TreeNode<String>("i");
		TreeNode<String> j = new TreeNode<String>("j");
		TreeNode<String> k = new TreeNode<String>("k");
		TreeNode<String> l = new TreeNode<String>("l");
		TreeNode<String> m = new TreeNode<String>("m");
		TreeNode<String> n = new TreeNode<String>("n");
		TreeNode<String> o = new TreeNode<String>("o");
		TreeNode<String> p = new TreeNode<String>("p");
		TreeNode<String> q = new TreeNode<String>("q");
		TreeNode<String> r = new TreeNode<String>("r");
		TreeNode<String> s = new TreeNode<String>("s");
		TreeNode<String> t = new TreeNode<String>("t");
		TreeNode<String> u = new TreeNode<String>("u");
		TreeNode<String> v = new TreeNode<String>("v");
		TreeNode<String> w = new TreeNode<String>("w");
		TreeNode<String> x = new TreeNode<String>("x");
		TreeNode<String> y = new TreeNode<String>("y");
		TreeNode<String> z = new TreeNode<String>("z");
		
		setRoot(root);
		
		// Create a Left and Right child for the root
		root.setLeftChild(e);
		root.setRightChild(t);
		
		e.setLeftChild(i);
		e.setRightChild(a);
		
		t.setLeftChild(n);
		t.setRightChild(m);
		
		i.setLeftChild(s);
		i.setRightChild(u);
		
		a.setLeftChild(r);
		a.setRightChild(w);
		
		n.setLeftChild(d);
		n.setRightChild(k);
		
		m.setLeftChild(g);
		m.setRightChild(o);
		
		s.setLeftChild(h);
		s.setRightChild(v);
		
		u.setLeftChild(f);
		
		r.setLeftChild(l);
		
		w.setLeftChild(p);
		w.setRightChild(j);
		
		d.setLeftChild(b);
		d.setRightChild(x);
		
		k.setLeftChild(c);
		k.setRightChild(y);
		
		g.setLeftChild(z);
		g.setRightChild(q);
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		
		ArrayList<String> treeToArrayList = new ArrayList<String>();
		
		LNRoutputTraversal(treeRoot, treeToArrayList);
		
		return treeToArrayList;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		
		if (root.getLeftChild() != null) {
			
			LNRoutputTraversal(root.getLeftChild(), list);
		}
		
		list.add(root.getData());
		
		if (root.getRightChild() != null) {
			
			LNRoutputTraversal(root.getRightChild(), list);
		}
	}
}
