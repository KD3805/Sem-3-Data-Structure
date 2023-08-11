import java.util.Scanner;

class StackUsingLL{
	public static void main(String[] args) {
		StackOfLL st = new StackOfLL();

		st.push(5);	
		st.push(12);	
		st.push(17);	
		st.push(19);
		st.display();

		st.peek();
		st.display();

		st.pop();
		st.display();

		st.peep(0);
		st.peep(1);
		st.peep(2);
		st.peep(3);
		st.peep(4);
		st.display();

		st.change(23,4);
		st.display();

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

class StackOfLL{
	Node top;

	// Insert an element at front of the Stack
	public void push(int x){
		Node newNode = new Node(x);

		if(top == null){
			top = newNode;
			return;
		}
		newNode.link = top;
		top = newNode;

		System.out.println(x+" element inserted at the front of stack.");
	}


	// Delete topmost element from stack
	public Node pop(){
		if(top == null){
			System.out.println("Stack is empty, nothing to delete.");
			return null;
		}
		Node pop = top;
		top = top.link;

		System.out.println("Top Element deleted from stack.");

		return pop;
	}


	// Return top element from stack
	public Node peek(){
		if(top == null){
			System.out.println("Stack is empty.");
			return null;
		}
		Node peek = top;
		System.out.println("Peek element = "+peek.info);
		
		return peek;
	}


    // Return an element from the specified position
    public Node peep(int pos) {
        if (top == null) {
            System.out.println("Stack is empty.");
            return null;
        }

        if(pos <= 0){
            System.out.println("Position index cannot be Negative or Zero");
            return null;
        }

        int count = 1;
        Node current = top;

        while (current != null && count < pos) {
            current = current.link;
            count++;
        }

        if (current == null) {
            System.out.println("Position "+pos+" not found in the Stack.");
            count--;
            return null;
        }
        System.out.println("Position index "+pos+" element = "+current.info);

        return current;
    }


    // Change an element from the specified position
    public void change(int element, int pos){
    	if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        if(pos > countNodes()){
            System.out.println("Stack Underflow");
            return;
        }

        if(pos <= 0){
            System.out.println("Position index cannot be Negative or Zero");
            return;
        }

        Node current = top;
        int count = 1;

        while (current != null && count < pos) {
            current = current.link;
            count++;
        }

        if (current == null) {
            System.out.println("Position "+pos+" not found in the Stack.");
            count--;
            return;
        }

        int temp = current.info;
        current.info = element;
        System.out.println("Element "+temp+" is changed by element "+element+" at "+pos+" index form stack.");
    }


    // Count total elements in stack
    public int countNodes(){
    	int count = 0;

		if(top == null){
			System.out.println("List is empty");
			return 0;
		}

		// Count No. of Nodes
		else{
			Node temp = top;

			while(temp != null){
				temp = temp.link;
				count++;
			}
		}
		System.out.println("Total No. of Elements : "+count);

		return count;
    }


    // Display all the elements
	public void display() {
		if (top == null) {
            System.out.println("Linked list is empty.");
            return;
        }

		Node temp = top;
		while(temp != null) {
			System.out.print(temp.info+" ");
			temp = temp.link;
			
		}
		System.out.println();
	}
}