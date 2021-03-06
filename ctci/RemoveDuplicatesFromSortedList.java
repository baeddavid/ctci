import java.util.TreeSet;
import java.util.Iterator;

public class RemoveDuplicatesFromSortedList {
	Node <Integer> removeDupes(Node <Integer> head) {
		Node <Integer> curr = head;
		while(curr != null) {
			Node <Integer> keyCheck = curr.next;
			while(keyCheck != null && keyCheck.data != curr.data) {
				keyCheck = keyCheck.next;
			}
			curr.next = keyCheck;
			curr = keyCheck;
		}
		return head;
	}

	Node <Integer> removeDupesLinearSpace(Node <Integer> head) {
		TreeSet <Integer> set = new TreeSet <>();
		Node <Integer> curr = head;

		while(curr != null) {
			set.add(curr.data);
			curr = curr.next;
		}

		Node <Integer> dummyHead = new Node <>(-1);
		curr = dummyHead;
		Iterator <Integer> itr = set.iterator();

		while(itr.hasNext()) {
			curr.next = new Node <Integer> (itr.next());
			curr = curr.next;
		}

		return dummyHead.next;
	}
}

class Node <T> {
	public T data;
	public Node next;

	public Node(T data) {
		this.data = data;
		next = null;
	}
}