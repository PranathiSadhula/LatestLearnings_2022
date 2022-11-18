package datastructures.week3.day2;

public class StringBasics{


 @org.junit.Test
    public void stringBasicTest(){
        
        String firstRef = "Test";
        String secondRef = "Test";

        String objStr = new String("Test");
        
        System.out.println(firstRef);
        System.out.println(secondRef);
        System.out.println(objStr);

        System.out.println(firstRef == secondRef);  //true
         System.out.println(firstRef == objStr); //false 
         /*bcz firstRef is having direct reference to literal(Test) string pool
            whereas objStr will have object created in heap memory and then internally this object refers to literal(Test)
            So, when we use "==" --> compares only references and 
            gives false when we try compare firstRef with objStr reference.
            So, we need to use .equals() to compare literal values of both strings


         */
        System.out.println(firstRef.equals(objStr)); //true

        char asciiChar = 65;
        System.out.println(asciiChar); //prints 'A'
        
        /**
        
        useful methods:

        toCharArray()
        getChars(char[] dest, int startIndex)
        intern()
        codePointAt(int index) ==> returns ascii code for given char at index 
        s1.concat(s2)
        s1.startsWith(char c) // endWith(char c)
        equals()
        equalsIgnoreCase()
        length()
        trim()
        isEmpty()
        indexOf()
        valueOf()
        split()
        subString()
        replace()
        replaceAll()



        
         */

    }


}