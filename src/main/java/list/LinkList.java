package list;

import java.util.LinkedList;

public class LinkList {
	private ListNode head;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public LinkList(int sorted[]) {
		ListNode now;
		if (sorted != null && sorted.length > 0) {
			head = now = new ListNode(sorted[0]);
			for (int i = 1; i < sorted.length; i++) {
				ListNode node = new ListNode(sorted[i]);
				now.next = node;
				now = node;
			}
		}
	}
}
