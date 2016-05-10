package MergeKSortedLists;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length-1);
    }

    private ListNode partion(ListNode[] lists, int begin, int end) {
        if(begin == end)
            return lists[begin];

        if(begin < end) {
            int mid = begin + (end - begin)/2;
            ListNode list1 = partion(lists, begin, mid);
            ListNode list2 = partion(lists, mid+1, end);
            return merge(list1, list2);
        }
        else
            return null;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }
        else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
