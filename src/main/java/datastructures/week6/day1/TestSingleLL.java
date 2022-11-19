package datastructures.week6.day1;

import org.junit.Test;

public  class TestSingleLL{
    @Test
    public void test(){
       singleLLImplementation ssl = new singleLLImplementation();
        ssl.add(1);
        ssl.add(2);
        ssl.add(3);
        ssl.add(4);
        ssl.add(5);
        ssl.add(6);
     System.out.println("size -->"+ssl.size());
        ssl.print();

        ssl.removeFirst();
        System.out.println("size -->"+ssl.size());
        ssl.print();


        System.out.println("get value -->"+ssl.get(7));
        ssl.print();


      ssl.set(3,6);
        ssl.print();

        ssl.remove(5);
        ssl.print();
    }

}