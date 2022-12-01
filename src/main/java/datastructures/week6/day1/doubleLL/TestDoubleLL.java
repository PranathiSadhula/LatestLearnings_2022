package datastructures.week6.day1.doubleLL;

import org.junit.Test;

public class TestDoubleLL {

    @Test
    public void test(){
        DoubleLLImplementation dll = new DoubleLLImplementation();
        dll.add(1);
        dll.add(3);
        dll.add(2);
        dll.add(4);
        dll.print();
        dll.remove(2);
        dll.print();

    }
}
