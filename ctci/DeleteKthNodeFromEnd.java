public class DeleteKthNodeFromEnd {
    public Node <Integer> deleteKthNode(Node <Integer> head, int k) {
		Node <Integer> slow = head, fast = head;
		while(k != 0 && fast != null) {
			fast = fast.next;
            if(fast == null) {
                return head.next;
            }
            k--;
		}

		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
    
		slow.next = slow.next.next;
		return head;
	}

	public Node <Integer> deleteKthNodeBruteForce(Node <Integer> head, int k) {
		int length = 0;
		Node <Integer> curr = head;

		while(curr != null) {
			length++;
			curr = curr.next;
		}

		curr = head;
        int key = length - k;
		while(key > 1) {
			curr = curr.next;
            key--;
		}

		Node <Integer> delete = curr.next;
		curr.next = curr.next.next;
		return delete;
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