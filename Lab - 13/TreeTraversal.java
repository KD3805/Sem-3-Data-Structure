class TreeTraversal{
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node p = new Node(4);
		Node p1 = new Node(1);
		Node p2 = new Node(6);
		Node p3 = new Node(5);
		Node p4 = new Node(2);

		p.left = p1;
	    p.right = p2;
	    p1.left = p3;
	    p1.right = p4;

		bt.preOrder(p);
		
	}
}

class Node{
	int data;
	Node left;
	Node right;

	public Node(int x){
		data = x;
		left = null;
		right = null;
	}
}

class BinaryTree{
	// Node p = new Node(4);
	// Node p1 = new Node(1);
	// Node p2 = new Node(6);
	// Node p3 = new Node(5);
	// Node p4 = new Node(2);

	// p.left = p1;
    // p.right = p2;
    // p1.left = p3;
    // p1.right = p4;

    public void preOrder(Node root){
    	if(root != null){
    		System.out.print(root.data+" ");
    		preOrder(root.left);
    		preOrder(root.right);
    	}
    }
}