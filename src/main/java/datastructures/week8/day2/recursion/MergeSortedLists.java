package datastructures.week8.day2.recursion;

public class MergeSortedLists {
    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */

    /**
     * - check if both list1 and list2 are null, if yes, return null.
     * - check if else list1 is null, if yes return list2.
     * - check if else list2 is null, if yes return list1.
     * - create a mergedList to hold the resulted merged list of list1 and list2.
     *              mergedList = new ListNode();
     * - assign above mergedList to another List say : curList to keep iterate on next nodes.
     * - loop until either of list1 or list2 becomes null.
     *              check if list1 is null and list2.val < list1.value
     *                  (here as list1 might be null, so before checking list1.value, check if list1 != null)
     *              if yes, keep adding list1.value to curNode and list1 == list1.next
     *              else
     *                  keep adding list2.value to curNode and list2 == list2.next
     *
     *
     *
     *
     */













    class ListNode {
        int val;
        ListNode next;

        ListNode(){};

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
