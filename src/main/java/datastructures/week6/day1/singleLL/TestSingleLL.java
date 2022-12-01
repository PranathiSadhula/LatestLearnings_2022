package datastructures.week6.day1.singleLL;

import org.junit.Test;

public  class TestSingleLL{
    @Test
    public void test() {
     SingleLLImplementation ssl = new SingleLLImplementation();
     ssl.add(1);
     ssl.add(2);
     ssl.add(3);
     ssl.add(4);
     ssl.add(5);
     ssl.add(6);
     ssl.add(4);
     ssl.add(5);
     ssl.add(6);
     System.out.println("size -->" + ssl.size());
     System.out.println("tail -->" + ssl.tail.nodeValue);
     ssl.print();
     System.out.println("index of 5 ==>"+ssl.indexOf(5));
     System.out.println("lastIndex of 5 ==>"+ssl.lastIndexOf(5));
     ssl.removeFirst();
     System.out.println("size -->" + ssl.size());
     ssl.print();

     System.out.println("get value -->" + ssl.get(5));
     ssl.print();
     ssl.remove(4);
     ssl.print();
     ssl.set(3, 6);
     ssl.print();
     ssl.removeAll(6);
     ssl.print();

     ssl.removeLast();
     ssl.print();

     ssl.removeByIndex(2);
     ssl.print();


    }

}