package list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Linked_list_cycle_141 {
	
    public static boolean hasCycle(ListNode head) {
        boolean res = false;
        if(head == null)
        	return res;
        Set<ListNode> hasseen = new HashSet<ListNode>();
        while(head.next != null) {
        	if(!hasseen.contains(head)) {
        		hasseen.add(head);
        	}else {
        		res = true;
        		return res;
        	}
        	head = head.next;
        }
        return res;
    }
    
    public static boolean hasCycle_1(ListNode head) {
        if(head == null || head.next == null)
        	return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow) {
        	if(fast == null || fast.next ==null) {
        		return false;
        	}
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return true;
    }

	public static void main(String[] args) {
		int[] nums = {3,2,0,-4};
		LinkList list = new LinkList(nums);
		ListNode temp = list.getHead().next;
		temp.next.next = temp;
		System.out.println(hasCycle_1(list.getHead()));
	}

}
