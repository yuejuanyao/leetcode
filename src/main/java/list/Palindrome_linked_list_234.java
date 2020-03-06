package list;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_linked_list_234 {
    //将链表放数组里然后用头尾指针 空间复杂度O(N)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //递归方法加上外部指针方法；递归方法从后往前，外部指针从前往后
    ListNode frontPointer = null;
    public boolean isPalindrome_1(ListNode head) {
        frontPointer = head;
        return isPalindromeHelper(head);
    }

    private boolean isPalindromeHelper(ListNode currnode) {
        if (currnode != null) {
            if (!isPalindromeHelper(currnode.next))
                return false;
            if (frontPointer.val != currnode.val)
                return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 将后半部分的链表反转
     * 1. 找到中间的节点
     * 2. 将后半部分节点反转
     * 3. 判断两部分的节点是否一样
     * 4. 将链表还原
     * @param head
     * @return
     */

    public boolean isPalindrome_2(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode midNode = getFrontEnd(head);
        ListNode endList = reverse(midNode.next);
        boolean result = check(head, endList);
        midNode.next = reverse(endList);
        return result;
    }

    private boolean check(ListNode midNode, ListNode endList) {
        while (midNode!=null && endList!=null){
            if(midNode.val != endList.val)
                return false;
            midNode = midNode.next;
            endList = endList.next;
        }
        return true;
    }

    //反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //用快慢指针找到前半部分的最后一个节点
    private ListNode getFrontEnd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
