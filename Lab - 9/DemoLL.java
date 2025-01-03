public class DemoLL {
	Node head;

	public static void main(String[] args) {
		LL list = new LL();
		list.addFirst("a");
		list.addLast("devang");
		list.printList();
	}

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	// Add first
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	// Add Last
	public void addLast(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node saveNode = head;
		while (saveNode.next != null) {
			saveNode = saveNode.next;
		}
		saveNode.next = newNode;

	}

	public void printList() {
		Node saveNode = head;
		if (head == null) {
			System.out.println("list is empty");
			return;
		}

		while (saveNode != null) {
			System.out.println(saveNode.data + "=>");
			saveNode = saveNode.next;
		}
		System.out.println("Null");

	}

}