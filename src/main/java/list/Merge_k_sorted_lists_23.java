package list;

import java.util.*;

public class Merge_k_sorted_lists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean hasNode = true;
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (hasNode) {
            hasNode = false;
            int curMin = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    hasNode = true;
                    if (curMin == -1 || lists[curMin].val > lists[i].val) {
                        curMin = i;
                    }
                }
            }
            if (curMin != -1) {
                next.next = lists[curMin];
                next = next.next;
                lists[curMin] = lists[curMin].next;
            }
        }
        return head.next;
    }


    // 优先队列
    public ListNode mergeKLists_1(ListNode[] lists) {
        if (lists == null || lists.length <= 0)
            return null;
        int length = lists.length;
        Queue<ListNode> queue = new PriorityQueue<>(length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) //注意判空
                queue.offer(node);
        }
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (!queue.isEmpty()){
            ListNode next = queue.poll();
            cur.next = next;
            if (next.next != null)
                queue.offer(next.next);
            cur = cur.next;
        }
        return dum.next;
    }
    
    // 归并
    public ListNode mergeKLists_2(ListNode[] lists) {
        if (lists == null || lists.length <= 0)
            return null;
        int length = lists.length;
        while (length > 1) {
            int i = 0;
            for (; i < length / 2; i++) {
                lists[i] = mergeTwoList(lists[2 * i], lists[2 * i + 1]);
            }
            if (length % 2 == 1) {
                lists[i] = lists[length - 1];
                length++;
            }
            length /= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return head.next;
    }

}
