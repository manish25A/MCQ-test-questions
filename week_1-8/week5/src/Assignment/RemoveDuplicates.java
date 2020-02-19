package	Assignment;

public class RemoveDuplicates {
	Node head;

	class Node
	{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}

	void removingDuplicates()
	{

		Node num1 = null, num2 = null, duplicate = null;
		num1 = head;

		/* Pick elements one by one */
		while (num1 != null && num1.next != null) {
			num2 = num1;

	             /* Compare the picked element with rest
	                 of the elements */
			while (num2.next != null) {

				/* If duplicate then delete it */
				if (num1.data == num2.next.data) {

					/* sequence of steps is important here */
					duplicate = num2.next;
					num2.next = num2.next.next;
					System.gc();
				} else /* This is tricky */ {
					num2 = num2.next;
				}
			}
			num1 = num1.next;
		}
	}


	public void push(int new_data)
	{

		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}


	void printList()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		RemoveDuplicates list1 = new RemoveDuplicates();
		list1.push(50);
		list1.push(50);
		list1.push(60);
		list1.push(70);
		list1.push(60);
		list1.push(50);
		list1.push(80);
		list1.push(80);

		System.out.println("List before removal of duplicates");
		list1.printList();

		list1.removingDuplicates();

		System.out.println("List after removal of duplicate elements");
		list1.printList();
	}
}
