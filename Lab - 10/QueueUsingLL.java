import java.util.Scanner;

class QueueUsingLL{
	public static void main(String[] args) {
		QueueOfLL ql = new QueueOfLL();

		ql.enqueue(5);
		ql.enqueue(10);
		ql.enqueue(17);
		ql.enqueue(23);
		ql.display();

		ql.dequeue();
		ql.dequeue();
		ql.display();
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

class QueueOfLL{
	Node first;
	Node last;

	public void enqueue(int x){
		Node newNode = new Node(x);

		if(first == null) {
			first = newNode;
			last = first;
			System.out.println("First element "+x+" is inserted in queue");
			return;
		}
		last.link = newNode;
		last = last.link;

		System.out.println("Element "+x+" is inserted at the end.");
	}
	
	public void dequeue(){
		if(first == null){
			System.out.println("Queue is empty, nothing to delete");
			return;
		}

		if(first == last){
			first = last = null;
		}
		else{
			first = first.link;
		}
	}

	public void display(){
		if (first == null) {
            System.out.println("Queue is empty, can't display elements");
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