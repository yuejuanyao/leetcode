package list;


public class RemoveDuplicatesFromSortedlList {

	private ListNode buildList(int sorted[]) {
		ListNode head = new ListNode();
		ListNode now;

		if (sorted != null && sorted.length > 0) {
			head = now = new ListNode(sorted[0]);
			for (int i = 1; i < sorted.length; i++) {
				ListNode node = new ListNode(sorted[i]);
				now.next = node;
				now = node;
			}
		}

		return head;
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode headForNew = null;
		if (head != null)
			headForNew = new ListNode(head.val);
		ListNode tailForNew = headForNew;

		while (head != null) {
			boolean flag = false;

			ListNode nowForNew = headForNew;
			// 判断新的链表中是否有一样的值
			while (nowForNew.next != null) {
				if (head.val == nowForNew.val) {
					flag = true;
					break;
				}
				nowForNew = nowForNew.next;
			}
			// 最后一个节点处理
			if (head.val == nowForNew.val)
				flag = true;

			// 不存在就插入值
			if (!flag) {
				ListNode node = new ListNode(head.val);
				tailForNew.next = node;
				tailForNew = node;
			}
			head = head.next;
		}

		return headForNew;
	}

	public ListNode deleteDuplicatesSorted(ListNode head) {
		ListNode headForNew = null;
		if (head != null) {
			headForNew = new ListNode(head.val);
		}
		ListNode tailForNew = headForNew;

		while (head != null) {

			if (tailForNew != null && head.val != tailForNew.val) {
				ListNode node = new ListNode(head.val);
				tailForNew.next = node;
				tailForNew = node;
			}
			head = head.next;
		}

		return headForNew;
	}

	public ListNode deleteDuplicatesSorted1(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				ListNode node = cur.next;
				cur.next = node.next;
				node.next = null;
			} else {
				cur = cur.next;
			}
		}

		return head;
	}
	
	public ListNode deleteDuplicatesSortedRecurrent(ListNode head) {
		if(head == null || head.next == null)
			return head;

		head.next = deleteDuplicatesSortedRecurrent(head.next);
		if(head.val == head.next.val) {
			head = head.next;
		}
		return head;
	}

	public void build() {
		int[] a = { 1, 2, 3, 4, 4,5 };
		System.out.println(a.length);
		ListNode head = buildList(a);
		System.out.println(head);

		ListNode newList = deleteDuplicates(head);
		System.out.println(newList);

		ListNode newListSort = deleteDuplicatesSorted(head);
		System.out.println(newListSort);

		ListNode newListSort1 = deleteDuplicatesSorted1(head);
		System.out.println(newListSort1);
	}

}
