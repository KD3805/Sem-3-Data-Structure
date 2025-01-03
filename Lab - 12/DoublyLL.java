class DoublyLL{
	public static void main(String[] args) {
		LL dl = new LL();

		//insert
		dl.insertAtFirst(12);
		dl.insertAtFirst(23);
		dl.insertAtFirst(17);
		dl.display();
		dl.insertAtLast(34);
		dl.insertAtLast(43);
		dl.display();

		//insert in order
		dl.insertOrder(27);
		dl.display();

		//delete
		dl.deleteElement(27);
		dl.display();
	}
}

class Node{
	int info;
	Node lptr;
	Node rptr;
	public Node(int x){
		info = x;
		lptr = null;
		rptr = null;
	}
}

class LL{
	private Node left;
	private Node right;

	public void insertAtFirst(int x){
		Node newNode = new Node(x);

		if(right == null){
			left = right = newNode;
			System.out.println("First element "+x+" is inserted in doubly ll.");
			return;
		}

		newNode.lptr = null;
		newNode.rptr = left;
		left.lptr = newNode;
		left = newNode;

		System.out.println(x+" Node inserted at the front.");
		return;
	}

	public void insertAtLast(int x){
		Node newNode = new Node(x);

		if(right == null){
			left = right = newNode;
			System.out.println("First element "+x+" is inserted in doubly ll.");
			return;
		}

		newNode.rptr = null;
		newNode.lptr = right;
		right.rptr = newNode;
		right = newNode;

		System.out.println(x+" Node inserted at the last.");
		return;
	}


	//Sort linked list
	boolean flag = false;
	public void sort(){
		int count = 1;

		if(right == null){
			System.out.println("List is empty");
		}

		// Count No. of Nodes
		else{
			Node temp = left;

			while(temp.rptr != null){
				temp = temp.rptr;
				count++;
			}
		}
		System.out.println("Total No. of Nodes : "+count);

		// Bubble sort
		for(int i=0; i<count; i++){
			Node temp1 = left;
			Node temp2 = left.rptr;
			int swap;
			flag = true;

			for(int j=0; j<count-i-1; j++){

				if(temp1.info > temp2.info){
					swap = temp1.info;
					temp1.info = temp2.info;
					temp2.info = swap;
					flag = false;
				}
				temp1 = temp2;
				temp2 = temp2.rptr;
			}
			if(flag) {
				break;
			}
		}
		System.out.println("After sorting, List elements are...");
		display();

	}


	// Insert a node in increasing order of the linked list
    public void insertOrder(int x){
        Node newNode = new Node(x);

        sort();

        if(right == null){
			left = right = newNode;
			System.out.println("First element "+x+" is inserted in doubly ll.");
			return;
		}

        else{
            if(newNode.info <= left.info){
                newNode.lptr = null;
				newNode.rptr = left;
				left.lptr = newNode;
				left = newNode;
            }

            Node current = left;
            while(current.rptr != null && newNode.info >= (current.rptr).info){
                current = current.rptr;
            }
            newNode.rptr = current.rptr;
            newNode.lptr = current;
            current.rptr = newNode;
            (current.rptr).lptr = newNode;

            System.out.println(x+" Node inserted in increasing order.");
        }
        return;
    }

	// Delete any element
    public void deleteElement(int element){
    	if(right == null){
			System.out.println("Linked list is empty, can't delete any element");
		}
		Node save = left;

		while(save.rptr != null && save.info != element){
			save = save.rptr;
		}

		// if list have only one element
		if(left == right){
			left = right = null;
			return;
		}

		// if given element is first element of list
		else if(save == left){
			left = left.rptr;
			left.lptr = null;
		}

		// if given element is last element of list
		else if(save == right){
			right = right.lptr;
			right.rptr = null;
		}

		// if element not found
		else if(save.rptr == null){
			System.out.println("Element "+element+" is not found");
			return;
		}
		
		else{
			(save.lptr).rptr = save.rptr;
			(save.rptr).lptr = save.lptr;
			System.out.println(element+" is deleted from the list");
		}
    }

    public void display(){
    	Node temp = left;

    	if(right == null){
			 System.out.println("Doubly linked list is empty.");
			return;
		}

    	while(temp != null){
    		System.out.print(temp.info+" ");
			temp = temp.rptr;
    	}
    	System.out.println();
    }
}