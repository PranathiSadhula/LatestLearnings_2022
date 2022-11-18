package datastructures.interviewready;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class CollectionsPractice {

    @Test
    public void test(){

        Collection<Integer> values = new ArrayList<Integer>();

        System.out.println(values.add(5));
        values.add(6);
        System.out.println( values.add(5));
        values.add(9);
        System.out.println(values);

        values = new HashSet<>();

        System.out.println(values.add(5));
        values.add(6);
        System.out.println( values.add(5));
        values.add(9);
        System.out.println(values);



    }


    static int var = 10;
    int nonStaticvar = 20;

    static void printVar(){
        System.out.println(var);
     //   System.out.println(nonStaticvar);
      //  printNonStaticVars();
    }

    void printNonStaticVars(){
        System.out.println(var);
        System.out.println(nonStaticvar);
        printVar();
    }
}





