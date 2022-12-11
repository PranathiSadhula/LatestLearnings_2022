package datastructures.week8.daywise.dec05.hackerRank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxElement {

       public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> maxStack = new Stack();
        List<Integer> out = new ArrayList<>();
        int maxElemt = Integer.MIN_VALUE;
        for (String operation : operations) {
            if(operation.startsWith("1")){
                Integer val = Integer.valueOf(operation.split(" ")[1]);
                stack.push(val);
                maxStack.push(val);
                // list.add(val);
            }
            else if(operation.equals("2")){
                stack.pop();
                maxStack.pop();
                //list.remove(list.size()-1);
            }
            else if(operation.equals("3")){

                out.add(maxStack.peek());
              //  System.out.println(maxElemt);
            }
        }

        return out;
    }


    public static List<Integer> getMax1(List<String> operations) {

        Stack<Integer> stack = new Stack();
        Stack<Integer> maxStack = new Stack();
        List<Integer> out = new ArrayList<>();
         for (String operation : operations) {
            if(operation.startsWith("1")){
                Integer val = Integer.valueOf(operation.split(" ")[1]);
                stack.push(val);
                if(maxStack.isEmpty()){
                    maxStack.push(val);
                }else{
                    maxStack.push(Math.max(maxStack.peek(), val));
                }
            }
            else if(operation.equals("2")){
                stack.pop();
                maxStack.pop();
                //list.remove(list.size()-1);
            }
            else if(operation.equals("3")){

                out.add(maxStack.peek());
            }
        }

        return out;
    }
    @Test
    public void test(){
        List<String> operations = new ArrayList<>();
        operations.add("1 97");
        operations.add("2");
        operations.add("1 20");
        operations.add("2");
        operations.add("1 26");
        operations.add("1 20");
        operations.add("2");
        operations.add("3");
        operations.add("1 91");
        operations.add("3");
        System.out.println(getMax(operations));
        System.out.println(getMax1(operations));
    }

}
