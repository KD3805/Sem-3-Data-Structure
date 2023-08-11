public class Linkedlist {

	public static void main(String[] args) {
		System.out.println();

		Ll l1 = new Ll();
		Ll l2 = new Ll(5);
		
		l1.insertAtFront(9);
		l1.insertAtFront(27);
		l1.insertAtEnd(32);
		l1.insertAtEnd(23);
		l1.insertAtEnd(5);
		l1.insertAtEnd(23);
		l1.insertOrder(10);
		l1.display();

		l1.insertAtPosition(19,1);
		l1.display();

		l1.sort();
		l1.insertOrder(10);

		l1.deleteLast();
		l1.display();


		
	}

}
class Node{
	int info;
	Node link; 
	public Node(int x) {
		info = x;
		link = null;
	}
}

class Ll{
	Node first;
	Node lastInserted;

	// Insert data by using constructor ---------------------------
	public Ll() {
		first = null;
		lastInserted = null;
	}
	public Ll(int x) {
		first = new Node(x);
		lastInserted = first;
	}
	public void add(int x) {
		if(first == null) {
			first = new Node(x);
			lastInserted = first;
			return;
		}
		lastInserted.link = new Node(x);
		lastInserted = lastInserted.link;
	}
	// ------------------------------------------------------------


	// Insert a node at front of the linked list
	public void insertAtFront(int x){
		Node newNode = new Node(x);

		if(first == null){
			first = newNode;
			return;
		}
		newNode.link = first;
		first = newNode;
		
		System.out.println(x+" Node inserted at the front.");
	}


	// Insert a node at end of the linked list
	public void insertAtEnd(int x){
		Node newNode = new Node(x);

		if(first == null){
			first = newNode;
			return;
		}
		Node current = first;
		while(current.link != null){
			current = current.link;
		}
		current.link = newNode;
		System.out.println(x+" Node inserted at the end.");
	}

	boolean flag = false;
	public void sort(){
		int count = 0;

		if(first == null){
			System.out.println("List is empty");
		}

		// Count No. of Nodes
		else{
			Node temp = first;

			while(temp != null){
				temp = temp.link;
				count++;
			}
		}
		System.out.println("Total No. of Nodes : "+count);

		// Bubble sort
		for(int i=0; i<count; i++){
			Node temp1 = first;
			Node temp2 = first.link;
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
				temp2 = temp2.link;
			}
		}
		System.out.println("After sorting, List elements are...");
		display();

	}


	// Insert a node in increasing order of the linked list
    public void insertOrder(int x){
        Node newNode = new Node(x);

        if(flag == false){
        	System.out.println("Nodes are not sorted.");
        	return;
        }

        if(first == null){
            first = newNode;
            return;
        }
        else{
            if(newNode.info <= first.info){
                newNode.link = first;
                first = newNode;
            }

            Node current = first;
            while(current.link != null && newNode.info >= (current.link).info){
                current = current.link;
            }
            newNode.link = current.link;
            current.link = newNode;

            System.out.println(x+" Node inserted in increasing order.");
        }
        return;
    }


    // Insert a node from the specified position
    public void insertAtPosition(int data, int pos) {
    	Node newNode = new Node(data);

        if(first == null){
            first = newNode;
            System.out.println(data+" Node inserted at first position.");
            return;
        }

        if(pos == 1){
        	newNode.link = first;
			first = newNode;
			System.out.println(data+" Node inserted at first position.");
            return;
        }


        int count = 1;
        Node current = first;
        Node prev = null;

        while (current.link != null && count < pos) {
            prev = current;
            current = current.link;
            count++;
        }

        if (current == null) {
            System.out.println("Position "+pos+" not found in the linked list.");
        }
        else {
        	newNode.link = current.link;
            prev.link = newNode;

            // newNode.link = current.link;
            // current.link = newNode;
            System.out.println("Node inserted at position " + pos);
        }
    }


    // Delete any element
	public void deleteElement(int element){
		if(first == null){
			System.out.println("List is empty, can't delete any element");
		}
		Node save = null;
		Node pred = null;
		save = first;

		while(save.link != null && save.info != element){
			pred = save;
			save = save.link;
		}

		if(save.link == null){
			System.out.println("Element "+element+" is not found");
		}
		else{
			if(save == first){
				first = first.link;
			}
			else{
				pred.link = save.link;
				save.link = null;
				System.out.println(element+" is deleted from the list");
			}
		}
	}


	// Delete the last inserted node of the linked list
    public void deleteLast() {
        if (first == null) {
            System.out.println("Linked list is empty. Nothing to delete.");
            return;
        }

        if (first.link == null) {
            first = null;
            System.out.println("last inserted node deleted.");
            return;
        }

        Node current = first;
        while ((current.link).link != null) {
            current = current.link;
        }
        current.link = null;
        System.out.println("Last node deleted.");
    }


    // Delete a node from the specified position
    public void deleteFromPosition(int pos) {
        if (first == null) {
            System.out.println("Linked list is empty. Nothing to delete.");
            return;
        }

        if (pos == 1) {
            first = first.link;
            System.out.println("Node deleted from position " + pos);
            return;
        }

        int count = 1;
        Node current = first;
        Node prev = null;

        while (current != null && count < pos) {
            prev = current;
            current = current.link;
            count++;
        }

        if (current == null) {
            System.out.println("Position "+pos+" not found in the linked list.");
        }
        else {
            prev.link = current.link;
            System.out.println("Node deleted from position " + pos);
        }
    }


	// Display all the elements
	public void display() {
		if (first == null) {
            System.out.println("Linked list is empty.");
            return;
        }

		Node temp = first;
		while(temp != null) {
			System.out.print(temp.info+" ");
			temp = temp.link;
			
		}
		System.out.println();
	}
}
