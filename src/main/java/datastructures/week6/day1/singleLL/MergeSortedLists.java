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
        ListNode head;
        ListNode tail;
        int length;
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

        public void add(int val, ListNode nodetoAdd){
            ListNode temp = new ListNode(val);
            temp.next = nodetoAdd;
                if(tail == null){
                     tail = temp;
                    head = temp;
                }
                else{
                    tail.next = temp;
                    tail = temp;
                }
             length++;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode mergedList = new ListNode();
        ListNode curListNode = mergedList;
        while (temp1 != null || temp2 != null) {

            if(temp2 == null ||temp1 != null && temp1.val < temp2.val){
                curListNode.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            }
            else {
               curListNode.next = new ListNode(temp2.val);
               temp2 = temp2.next;
           }
            curListNode = curListNode.next;

        }


        return mergedList.next;
    }


    @Test
    public void test(){

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1,new ListNode(3, new ListNode(4)));

        // ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        mergeTwoLists(head1, head2);

    }

    @Test
    public void test1(){

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);

        // ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        mergeTwoLists(head1, head2);

    }
}
