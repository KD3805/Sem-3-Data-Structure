class CircularLL{
	public static void main(String[] args) {
		LL cl = new LL();
		cl.cir_ins_first(5);	
		cl.cir_ins_last(10);	
		cl.cir_ins_last(15);	
		cl.cir_ins_last(25);
		cl.display();

		cl.sort();
		cl.cir_ins_ord(20);
		cl.display();

		cl.cir_delete_element(10);
		cl.display();
	}
}

class Node{
	int info;
	Node link;
	public Node(int x){
		info = x;
		link = null;
	}
}

class LL{
	Node first;
	Node last;

	public void cir_ins_first(int x){
		Node newNode = new Node(x);

		if(first == null) {
			newNode.link = newNode;
			last = first = newNode;
			System.out.println("First element "+x+" is inserted in Circular LL");
			return;
		}
		newNode.link = first;
		last.link = newNode;
		first = newNode;
		System.out.println("Element "+x+" is inserted at the front.");

		return;
	}

	public void cir_ins_last(int x){
		Node newNode = new Node(x);

		if(first == null) {
			newNode.link = newNode;
			last = first = newNode;
			System.out.println("First element "+x+" is inserted in Circular LL");
			return;
		}
		newNode.link = first;
		last.link = newNode;
		last = newNode;
		System.out.println("Element "+x+" is inserted at the end.");

		return;
	}


	//Sort linked list
	boolean flag = false;
	public void sort(){
		int count = 1;

		if(first == null){
			System.out.println("List is empty");
			return;
		}

		// Count No. of Nodes
		else{
			Node temp = first;

			while(temp.link != first){
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

			if(flag) break;
		}
		System.out.println("After sorting, List elements are...");
		display();

	}

	// Insert a node in increasing order of the linked list
    public void cir_ins_ord(int x){
        Node newNode = new Node(x);

		sort();

        if(first == null){
            newNode.link = newNode;
			last = first = newNode;
			System.out.println("First element "+x+" is inserted in Circular LL");
			return;
        }
        else{
            if(newNode.info <= first.info){
                newNode.link = first;
                last.link = newNode;
                first = newNode;
                System.out.println("Element "+x+" is inserted at the front.");

				return;
            }

            Node current = first;
            while(current != last && newNode.info >= (current.link).info){
                current = current.link;
            }
            newNode.link = current.link;
            current.link = newNode;

            if(current == last){
            	last = newNode;
            }

            System.out.println("Node "+x+" inserted in increasing order.");
        }
        return;
    }


    // Delete any element
	public void cir_delete_element(int element){
		if(first == null){
			System.out.println("Linked list is empty, can't delete any element");
		}
		Node save = first;
		Node pred = null;

		while(save.link != first && save.info != element){
			pred = save;
			save = save.link;
		}

		if(save.link == first){
			System.out.println("Element "+element+" is not found");
		}
		else{
			if(save == first){
				first = first.link;
				last.link = first;
			}
			else{
				pred.link = save.link;
				// save.link = null;

				if(element == last.info){
					last = pred;
				}
				System.out.println(element+" is deleted from the list");
			}
		}
		return;
	}

	public void display(){
		if (first == null) {
            System.out.println("Linked list is empty.");
            return;
        }

		Node temp = first;
		do{
			System.out.print(temp.info+" ");
			temp = temp.link;
			
		} while(temp != first);
		
		System.out.println();
	}
}