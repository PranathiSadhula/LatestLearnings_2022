import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReverseNum {

    /**
     * 24 -> 42
     * 2425 -> 5242
     *
     * -
     */

    @Test
    public void test(){
        int num = 2425;
        Assert.assertEquals(5242, reverseNum(num));
    }

    private int reverseNum(int num){ //2425
        int placeHolder = 1;
        int num1 = num;
        while(num1 > 10){
            num1 /= 10;
            placeHolder *= 10;
        }

       // String revNum = "";
        int revNum = 0;
        while(num > 0){
            int digit = num % 10; // 5 2 4 2
            revNum += placeHolder * digit; //
            placeHolder /= 10;
            num /= 10;
        }

        return Integer.valueOf(revNum);
    }


    /**
     *  list of nums, find largest num.
     *  - if list.size is 1 -> return the elt at o Index.
     *  - if all elts are of same -> return elt.
     *  - sort the elts in list using elt in 0 index and check with other elts for max value.
     *
     *
     *  1,4,6,2,7 -> out 7
     *  1,1,1,1 -> out 1
     *  1 -> 1
     *  1,4,6,2,7,7 -> 7
     */
    @Test
    public void testL(){
        List<Integer> list = Arrays.asList(1,4,6,2,7 );
        Assert.assertEquals(7,largestNum(list));
    }

    private int largestNum(List<Integer> nums){
        if(nums.size() == 1) return nums.get(0);
        sortList(nums);
        int largestNum =  nums.get(0);  // 1

     /*   for(int i = 1; i < nums.size(); i++){ // 1,4 -> 4, 4,4 -> 6, 6,2-> 6, 6,7 ->7
            largestNum = Math.max(largestNum, nums.get(i));
        }*/
        return largestNum;
    }

    private void sortList(List<Integer> nums){

        for(int i = 0; i < nums.size()-1; i++){
            for(int j = i+1; j < nums.size(); j++){
                if(nums.get(i) < nums.get(j)){
                    int temp = nums.get(i);
                    nums.set(i, nums.get(j));
                    nums.set(j, temp);
                }
            }

        }
    }
}
