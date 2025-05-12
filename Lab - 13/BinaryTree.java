class BinaryTree{
	public static void main(String[] args) {
		BST bt = new BST();

		bt.insertNode(0);
		bt.insertNode(1);
		bt.insertNode(3);
		bt.insertNode(2);
		bt.insertNode(4);
		bt.insertNode(-1);
		bt.insertNode(-3);
		bt.insertNode(-2);
		bt.insertNode(-4);

		System.out.print("Preorder : ");
		bt.preOrder(bt.root);
		System.out.println();

		System.out.print("Postorder : ");
		bt.postOrder(bt.root);
		System.out.println();

		System.out.print("Inorder : ");
		bt.inOrder(bt.root);
		System.out.println();

		if(bt.search(bt.root, 1)){
			System.out.println("found");
		}
		else{
			System.out.println("not found");
		}

		bt.deleteRecursion(bt.root, 0);


		System.out.print("Inorder : ");
		bt.inOrder(bt.root);
		System.out.println();

	}
}

class Node{
	int info;
	Node lptr;
	Node rptr;

	Node(int value){
		info = value;
	}
}

class BST{
	Node root;

	public void insertNode(int x){
		Node n = new Node(x);

		if(root == null){
			root = n;
			System.out.println("First Node value "+n.info+" inserted in BST");
			return;
		}
		else{
			Node parent;
			Node child = root;

			while(true){
				parent = child;

				if(child.info <= n.info){
					child = child.rptr;

					if(child == null){
						parent.rptr = n;
						System.out.println("Node value "+n.info+" inserted on RHS");
						break;
					}
				}
				else{
					child = child.lptr;

					if(child == null){
						parent.lptr = n;
						System.out.println("Node value "+n.info+" inserted on LHS");
						break;
					}
				}
			}
		}
	}

	public Node deleteRecursion(Node root, int val){

		if(root == null){
			System.out.println("BST is empty");
			return null;
		}

		if(root.info > val){
			root.lptr = deleteRecursion(root.lptr, val);
		}

		else if(root.info < val){
			root.rptr = deleteRecursion(root.rptr, val);
		}

		else { 
			//case 1
			if(root.lptr == null && root.rptr == null){
				return null;
			}

			//case 2
			if(root.lptr == null){
				return root.rptr;
			}
			else if(root.rptr == null){
				return root.lptr;
			}

			//case 3
			Node is = inOrderSuccessor(root.rptr);
			root.info = is.info; // copy leaf Node value to current root Node
			root.lptr = deleteRecursion(root.lptr, is.info); // delete leaf Node value
		}
		return root;
	}

	public Node inOrderSuccessor(Node root){
		while(root.lptr != null){
			root = root.lptr;
		}
		return root;
	}


	public Node deleteLoop(Node root, int val){
		Node parent;
		Node child = root;
		Node temp;

		if(root.info == val){
			temp = root;
			child = root.rptr;

			while(child.lptr != null){
				child = child.lptr;
			}
			child.lptr = temp.lptr;
			root = temp.rptr;

			temp.lptr = null;
			temp.rptr = null;

			return temp;
		}
		return root;
	}

	public boolean search(Node root, int key){
		if(root==null){
			return false;
		}

		if(key < root.info){
			return search(root.lptr, key);
		}

		else if(root.info == key){
			return true;
		}

		else{
			return search(root.rptr, key);
		}
	}

	public void preOrder(Node root){
		Node temp = root;
		if(temp == null){
			// System.out.println("BST is empty");
			return;
		}
		else{
			System.out.print(temp.info+" ");
			preOrder(temp.lptr);
			preOrder(temp.rptr);
		}
	}

	public void postOrder(Node root){
		Node temp = root;
		if(temp == null){
			// System.out.println("BST is empty");
			return;
		}
		else{
			postOrder(temp.lptr);
			postOrder(temp.rptr);
			System.out.print(temp.info+" ");
		}
	}

	public void inOrder(Node root){
		Node temp = root;
		if(temp == null){
			// System.out.println("BST is empty");
			return;
		}
		else{
			inOrder(temp.lptr);
			System.out.print(temp.info+" ");
			inOrder(temp.rptr);
		}
	}
}