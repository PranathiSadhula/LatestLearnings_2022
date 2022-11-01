package datastructures.week3.day1;

public class Sumof2NonZeroInt {

     /**
        -initialize out[]
        - check if given number is a decimal 
        
        - if yes, return int[] with 1, number-1
        
        else if given num is not a decimal :
        
        - check if num-1 is decimal, if not return 1, num-1
        
        - else return 2, num-2
        
    */
    public int[] getNoZeroIntegers(int n) {
        if(n % 10 == 0) return new int[] {1, n-1};
        int[] output = new int[2];
        
        if((n-1) % 10 == 0) return new int[] {2, n-2};
        else 
        
        return new int[] {1, n-1};
        
    }

    /**
        public void test(){
        
            int input = 23;
            int[] output = {1,21};
        }
        
        public void test(){
            int input = 1001;
            int[] out = {2,999};
        }
        
    */
}