import java.util.Scanner;

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

class LinkedList {

	Node head;

	void insertNode(int value) {

		Node newNode = new Node(value);

		if(head == null) {
			head = newNode;
			return;
		}

		Node temp = head;

		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
	}

	void reverse() {

		reverse(head);		
	}

	void reverse(Node head) {

		if(head == null)
			return;

		reverse(head.next);
		System.out.print(head.data + " ");
	}

	void display() {

		if(head == null) {
			System.out.println("Linked list is empty!");
			return;
		}

		Node temp = head;

		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class RevLinkedList {
	
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		Scanner objSc = new Scanner(System.in);

		System.out.print("Enter number of elements in linked list: ");
		int n = objSc.nextInt();
		System.out.print("Enter the numbers in linked list: ");
		for(int i = 0; i < n; i++) {
			list.insertNode(objSc.nextInt());
		}
		System.out.println("Original list:");
		list.display();
		System.out.println("Reversed list:");
		list.reverse();

	}
}