package datastructures.week6.day1.singleLL;

import org.junit.Test;

public class MergeSortedLists {
    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     *
     * Input: list1 = [], list2 = []
     * Output: []
     * Example 3:
     *
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     *
     *
     * Constraints:
     *
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both list1 and list2 are sorted in non-decreasing order.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode mergedList = new ListNode(temp1.val);
        int mergeIndex = 0;
        while (temp1 != null) {
            if (temp1.val <= temp2.val) {
                ListNode movableNode = temp1.next;
                mergedList.next =  new ListNode(temp2.val);
                mergedList.next.next = movableNode;
                mergeIndex++;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }


        return temp1;
    }


    @Test
    public void test(){

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1,new ListNode(3, new ListNode(4)));

        // ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        mergeTwoLists(head1, head2);

    }
}
