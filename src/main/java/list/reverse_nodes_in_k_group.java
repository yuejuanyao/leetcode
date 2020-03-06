package list;

public class reverse_nodes_in_k_group {
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode res = new ListNode();
		res.next = head;
		ListNode pre = res;
		ListNode end = res;
		
		while(end.next != null) {
			for(int i=0; i<k && end != null; i++) {
				end = end.next;
			}
			if(end == null)
				break;
			ListNode start = pre.next;
			ListNode next = end.next;
			pre.next = reverse(start, k);
			start.next = next;
			pre = start;
			end = start;
		}
		return res.next;
	}

	//第一步：知道ｋ个节点如何反转
	public static ListNode reverse(ListNode head, int k) {
		ListNode per = null;
		ListNode cur = head;
		ListNode next = null;
		for(int i=0; i<k; i++) {
			next = cur.next;
			cur.next = per;
			per = cur;
			cur = next;
		}
		return per;
	}
	public static void main(String[] args) {
		int[] nums = {1,2};
		LinkList linklist = new LinkList(nums);
		System.out.println(reverseKGroup(linklist.getHead(), 3));
	}
}
