import java.util.HashSet;

public class TestForCycle {
	// O(n) space complexity solution
	boolean testForCycleBrute(Node <Integer> head) {
		HashSet <Node <Integer>> set = new HashSet<>();
		Node <Integer> current = head;

		while(current != null) {
			if(!set.contains(current)) set.add(current);
			else return true;
		}

		return false;
	}

	// Optimal Solution
	boolean testForCycle(Node <Integer> head) {
		Node <Integer> fast = head, slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) 
				return true;
		}
		return false;
	}
}

class Node <T> {
	public T t;
	public Node next;

	public Node(T t) {
		this.t = t;
		next = null;
	}

	void displayNode() {
		System.out.print("{" + t + "}");
	}
}