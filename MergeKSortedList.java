import java.util.PriorityQueue;

/**
 * Leetcode 23. Merge k Sorted Lists
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {
    /**
     * if we have 2-3 total lists we could have done it with taking pointer for each list
     * and compare all pointers with each other and put the lowest value in result and increment
     * pointer in that list and repeat. Since we can't manage k pointers here directly we
     * can use a heap which essentially is working as keeping k pointers. remaining logic is same
     *
     * TC: O(Nlogk) where N -> total nodes across all lists (k), logk taken by heap add and poll
     * SC: O(k) maximum k elements in heap at any time
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head: lists){ //total k lists, k elements in heap
            if (head != null) {
                heap.add(head);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (!heap.isEmpty()) { //we will process each node in all list once only
            ListNode addNext = heap.poll(); // k -1 elements in heap; TC O(logk)

            if (addNext.next != null) {
                heap.add(addNext.next); // k elements in heap; TC O(logk)
            }

            curr.next = addNext;
            curr = curr.next;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
