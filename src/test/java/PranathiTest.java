import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class PranathiTest {
    @Test
    public void test(){
        //input = 70304
        //out = 70000 + 300+4
/*ques:
    -   is input int or string?
    -   is outut string?
    - what if given input is single digit , return same?

 */
        Assert.assertEquals("70000+300+4", placeValues("70304"));

    }

    /**
     * - check if given str is single digit. or < 10. if yes return string value.
     * - convert given str into int.
     * - initialize String output.
     * - initialize a stack to hold place values of each digit.
     * - iterate through each digit and keep adding digit * by its placeValue into stack.
     * - finally pop each value from stack and append to output to return.
     */

    private String placeValues(String s){
        if(s.replaceAll("\\D","").isEmpty()) throw new RuntimeException("invalid input");
        if(Integer.valueOf(s) < 10) return s;
        int num = Integer.valueOf(s);
        String output  = "";
        Stack<String> stack = new Stack<>();
        int placeValue = 1;
        while(num > 0){
            int digit = num % 10;
            num = num / 10;
            if(digit != 0)
             stack.push(String.valueOf(digit * placeValue));
            placeValue *= 10;
        }

        while(!stack.isEmpty()){
            output += stack.pop();
            if(!stack.isEmpty()) output += "+";
        }
       // output = output.substring(0, output.length()-1);

        return output;
    }

}

class ConstructorPrac{
    ConstructorPrac(){

    }

    ConstructorPrac(String m){

    }
}

class B extends  ConstructorPrac{

}
