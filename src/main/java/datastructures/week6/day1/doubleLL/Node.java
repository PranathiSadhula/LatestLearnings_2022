package datastructures.week6.day1.doubleLL;

public class Node {
    Integer nodeValue;
   Node nextNode;
   Node prevNode;
    Node(Integer nodeValue) {
        this.nodeValue = nodeValue;
        this.nextNode = null;
        this.prevNode = null;
    }

    Node(Integer nodeValue, Node prev, Node next) {
        this.nodeValue = nodeValue;
        this.nextNode = next;
        this.prevNode = prev;
    }
}
