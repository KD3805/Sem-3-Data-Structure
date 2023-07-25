public class Linkedlist {

	public static void main(String[] args) {
		Ll l1 = new Ll();
		Ll l2 = new Ll(5);
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.insertAtFront(5);
		l1.insertAtEnd(9);
		l1.insertOrder(2);
		l2.add(6);
		l2.add(11);
		l2.insertAtEnd(17);
		l1.print();
		l2.print();
		//HI Kisan 
		// Pull Demo
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
	Node last;
	public Ll() {
		first = null;
		last = null;
	}
	public Ll(int x) {
		first = new Node(x);
		last = first;
	}
	void add(int x) {
		if(first == null) {
			first = new Node(x);
			last = first;
			return;
		}
		last.link = new Node(x);
		last = last.link;
	}

	void insertAtFront(int x){
		Node newNode = new Node(x);

		if(first == null){
			first = newNode;
			return;
		}
		newNode.link = first;
		first = newNode;
		
		System.out.println(x+" Node inserted at the front.");
	}

	void insertAtEnd(int x){
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

	// Insert a node in increasing order of the linked list
    public void insertOrder(int info){
        Node newNode = new Node(info);

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
            while(current.link != null && info >= (current.link).info){
                current = current.link;
            }
            newNode.link = current.link;
            current.link = newNode;
        }
        return;
    }

	void print() {
		Node temp;
		temp = first;
		while(temp != null) {
			System.out.print(temp.info+" ");
			temp = temp.link;
			
		}
		System.out.println();
	}
}
