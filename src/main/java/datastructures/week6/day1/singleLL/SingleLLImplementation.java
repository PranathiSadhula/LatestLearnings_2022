package datastructures.week6.day1.singleLL;

public  class SingleLLImplementation {
    Node head;
    Node tail;
    int length;

    public void add(int input) {  //h, t =null
        if (tail == null) {
            Node temp = new Node(input);
            tail = temp;
            head = temp;
        } else {
            Node temp = new Node(input);
            tail.nextNode = temp;
            tail = temp;
        }
        length++;
    }

    public int size() {
        return length;
    }

    public int indexOf(int value){
        Node temp = head;
        int nodeIndex = 0;
        while(temp != null){  //1,2,3,4,5  -> 1,2,4,5
            if (temp.nodeValue == value){
                 return nodeIndex;
            }
            temp = temp.nextNode;
            nodeIndex++;
        }
        return -1;
    }

    public int lastIndexOf(int value){
        Node temp = head;
        int indexToReturn = -1;
        int nodeIndex = 0;
        while(temp != null){  //1,2,3,4,5  -> 1,2,4,5
            if (temp.nodeValue == value){
                indexToReturn = nodeIndex;
            }
            temp = temp.nextNode;
            nodeIndex++;
        }
        return indexToReturn;
    }

    public void removeFirst() {
        if (head.nextNode == null) head = null;
            // above if check can be done in 2 other ways
            /*
                if(head == tail) head = null;
                if(length ==  1) head = null;
             */
        else head = head.nextNode;
        length--;
    }

   public boolean removeLast() {
        if(length == 0) throw new RuntimeException("List is empty") ;
        if(length == 1) {
            head = tail = null;
            length--; //0
            return true;
        }
        Node temp = head;
        while(temp.nextNode != null){  // head, node1, node2, node3, tail
                                        //head.next --> node1, node1.next --> node2, node2.next --> node3 ---> node3.next--> tail.
            if(temp.nextNode.nextNode == null) {
                temp.nextNode = null;
                length--;
                return true;
            }
            temp = temp.nextNode;
        }
        return false;
    }
    public boolean remove(int value){ // 3
        Node temp = head;
        while(temp.nextNode != null){  //1,2,3,4,5  -> 1,2,4,5
            if(temp.nextNode.nodeValue == value) {
                temp.nextNode = temp.nextNode.nextNode;  //1,2,3,5
                length--;
                return true;
            }
            temp = temp.nextNode;
        }
        throw new RuntimeException("value["+value+"] not present in list");
    }

    public boolean removeByIndex(int indexToRemove){ // 3
        if(indexToRemove > length-1) throw new RuntimeException("index["+indexToRemove+"]is out of range");
        Node temp = head;
        int nodeIndex = 0;
        while(temp != null){  //1,2,3,4,5  -> 1,2,4,5
            if (nodeIndex == indexToRemove-1){
                temp.nextNode = temp.nextNode.nextNode;  //1,2,3,5
                length--;
                return true;
            }
            temp = temp.nextNode;
            nodeIndex++;
        }
        throw new RuntimeException("value at index["+indexToRemove+"] not present in list");

    }

    public boolean removeAll(int value) { // 6
        boolean isRemoved = false;
        Node temp = head;
        while (temp != null) {  //1,2,3,4,5 ,3 -> 1,2,4,5
            if (temp.nextNode.nodeValue == value) {
                temp.nextNode = temp.nextNode.nextNode;  //1,2,3,5
                length--;
                isRemoved = true;
            }
            temp = temp.nextNode;
        }
        if (isRemoved) return isRemoved;
        else
            throw new RuntimeException("value[" + value + "] not present in list");
    }

    //ToDO


   public int get(int value){
       Node temp = head;
       while(temp != null){
          if(temp.nodeValue == value) return temp.nodeValue ;
           temp = temp.nextNode;
       }
       throw new RuntimeException("value["+value+"] not present in list");
   }


    public boolean set(int nThNode, int value) {
        Node temp = head;
        int nodePosition = 0;
        while (temp != null) { //while(nodePosition <= n)
            if (nodePosition == nThNode) {
                temp.nodeValue = value;
                return true;
            }
            temp = temp.nextNode;
            nodePosition++;
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
