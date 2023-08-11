class TreeCreation{
	public static void main(String[] args) {
		
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
	Node root = new Node(2);
	Node childL = new Node(1);
	Node childR = new Node(4);

	root.left = childL;
	root.right = childR;
}