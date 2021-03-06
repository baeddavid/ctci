public class KthFromLast {
	Node <Integer> kthFromLastBruteForce(Node <Integer> head, int k) {
		Node <Integer> current = head;
		int size = 0;
		
		while(current != null) {
			size++;
			current = current.next;
		}

		int targetNode = size - k - 1;
		int currentNode = 0;

		current = head;
		while(currentNode != targetNode && current != null) {
            currentNode++;
			current = current.next;
		}

		return current;
	}

	Node <Integer> kthFromLastOptimal(Node <Integer> head, int k) {
		Node <Integer> fast = head, current = head;
		int currentNode = 0;
		
		while(currentNode < k) {
			currentNode++;
			fast = fast.next;
		}

		while(fast.next != null) {
			current = current.next;
			fast = fast.next;
		}

		return current;
	}
}

class Node <T> {
	public T t;
	public Node <T> next;

	public Node(T t) {
		this.t = t;
		next = null;
	}

	public void displayNode() {
		System.out.print("{" + t + "}");
	}
}