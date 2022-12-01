package datastructures.week6.day1.doubleLL;



public class DoubleLLImplementation {

    Node head;
    Node tail;
    int length;

    public void add(int value){
       if(tail == null){
           Node temp = new Node(value);
           head = temp;
           tail = temp;
        //   head.prevNode = null;
       }
       else{
           Node temp = new Node(value);
           temp.prevNode = tail;
           tail.nextNode =  temp.prevNode ;
           tail = temp;
       }
       length++;
    }


    public boolean remove(int value){
        if(length == 0) throw new RuntimeException("List is empty");
        if(length == 1 && head.nodeValue != value) throw new RuntimeException("value ["+value+"] is not present in list");
        if(head.nodeValue == value) {
          //  head.nextNode.prevNode = null;
            head = head.nextNode;
        }
        if(tail.nodeValue == value){
            tail.prevNode = null;
        }
        Node temp = head;
        while(temp.nextNode != null && temp.nextNode.nextNode != null){
            if(temp.nodeValue == value){ //

                temp.prevNode.nextNode = temp.nextNode.prevNode;

             //   temp = null;

             }
            temp = temp.nextNode;
        }

        return false;
    }


    public void print(){
        Node temp = head;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.nodeValue+",");
            temp = temp.nextNode;
        }
        System.out.print("]");
        System.out.println();
    }
}
