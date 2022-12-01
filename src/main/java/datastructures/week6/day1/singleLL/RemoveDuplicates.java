package datastructures.week6.day1.singleLL;

import org.junit.Test;

public class RemoveDuplicates {
    /**
     * Given the head of a sorted linked list,
     * delete all duplicates such that each element appears only once. Return the linked list sorted as well.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,1,2]
     * Output: [1,2]
     * Example 2:
     *
     *
     * Input: head = [1,1,2,3,3]
     * Output: [1,2,3]
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [0, 300].
     * -100 <= Node.val <= 100
     * The list is guaranteed to be sorted in ascending order.
     */


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    class ListNode {
        Integer nodeValue;
        ListNode nextNode;
        ListNode() {};
        ListNode(Integer nodeValue) {
            this.nodeValue = nodeValue;
         }
        ListNode(int val, ListNode next) {
            this.nodeValue = val;
            this.nextNode = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp =  head;
        while(temp != null){
            if(temp.nodeValue == temp.nextNode.nodeValue){
                temp.nextNode = temp.nextNode.nextNode;
            }
            temp = temp.nextNode;
        }
        return  head;
    }


    @Test
    public void test(){

        ListNode head = new ListNode(1);

        head.nextNode.nodeValue = 1;
        head.nextNode.nextNode.nodeValue = 2;
        head.nextNode.nextNode.nextNode.nodeValue = 3;
        head.nextNode.nextNode.nextNode.nextNode.nodeValue = 3;

        deleteDuplicates(head);

    }

}
