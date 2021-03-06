public class Palindrome {
	// Brute Force Solution
	public boolean isListPalindromeBrute(Node <Integer> head) {
		Node <Integer> copy = new Node <>(-1);
		Node <Integer> current = head, copyHead = copy, prev = null;

		while(current != null) {
			copyHead.next = new Node <Integer> (current.data);
			copyHead = copyHead.next;
			current = current.next;
		}

		current = head;
		while(current != null) {
			Node <Integer> next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		current = prev;
		copyHead = copy.next;
		while(copyHead != null && current != null) {
			if(current.val != copyHead.val)
				return false;
			current = current.next;
			copyHead = copyHead.next;
		}

		return true;
	}

	// Slightly improved palindrome solution
	public boolean isListPalindrome(Node <Integer> head) {
		return areListsEqual(head, reverseAndCopyList(head));
	}

	public boolean areListsEqual(Node <Integer> a, Node <Integer> b) {
		Node <Integer> headA = a, headB = b;
		while(headA != null && headB != null) {
			if(headA.data != headB.data)
				return false;
			headA = headA.next;
			headB = headB.next;
		}
		return true;
	}

	public Node <Integer> reverseAndCopyList(Node <Integer> head) {
		Node <Integer> newHead = null;
		while(head != null) {
			Node <Integer> newNode = new Node <>(head.data);
			newNode.next = newHead;
			newHead = newNode;
			head = head.next;
		}
		return newHead;
	}

	// Stack solution
	public boolean isListPalindromeStack(Node <Integer> head) {
		Stack <Integer> stack = new Stack <>();
		Node <Integer> fast = head, slow = head;

		while(fast != null && fast.next != null) {
			stack.add(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast != null) {
			slow = slow.next;
		}

		while(slow != null) {
			int top = stack.pop().intValue();
			if(top != slow.data) 
				return false;
			slow = slow.next;
		}
		return true;
	}

	public boolean isListPalindromeOptimal(Node <Integer> head) {
		// O(n) time and O(1) space complexity
		// Get to the middle of the list first
		Node <Integer> current = head, fast = head, prevCurrent = null, midNode;
		while(fast != null && fast.next != null) {
			prevCurrent = current;
			current = current.next;
			fast = fast.next.next;
		}

		if(fast != null) {
			midNode = current;
			current = current.next;
		}

		// Reverse the second half of the list and compare it to the front of the list
		Node <Integer> secondHalf = current;
		prevCurrent.next = null;
		Node <Integer> reverseHead = reverse(secondHalf);
		boolean result = areListsEqual(head, secondHalf);
		reverseHead = reverse(secondHalf);

		if(midNode != null) {
			prevCurrent.next = midNode;
			midNode.next = secondHalf;
		} else {
			prevCurrent.next = secondHalf;
		}

		return result;
	}

	public Node <Integer> reverseHead(Node <Integer> head) {
		Node <Integer> current = head, prev = null;
		while(current != null) {
			Node <Integer> next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
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