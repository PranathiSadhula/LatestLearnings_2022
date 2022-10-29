public Class TwoSumII
{
     /**
    approach 2 :
    
        - start 2 pointers : start = 0 and end = numbers.length
        
        - initialize sum = 0
        
        - initialize int[] output with size 2 
        
        - iterate through numbers until start < end
        
        - add nums[start] and nums[end] anc compare with target
        
        - if sum macthes target add start and end to ouput
        
        - else if sum < target : increment start
        
        - else : decremenet end
        
        - finally return output
        
    
    */
    
     public int[] twoSum(int[] numbers, int target) {
         
         int start = 0;  //1
         int end = numbers.length-1;
         int[] output = new int[2];
        
         
         while(start < end){  // o[n]
              int sum = 0;
            sum +=  numbers[start] + numbers[end];
             if(sum == target) {
                 output[0] = start+1;
                 output[1] = end+1;
                 break;
              }
             else if (sum < target) start++;
             else end--;
         }
         
         return output;
         
         //time : o[n], space : o[n]
         
     }
    /**
        approach 1:
        
        - check if nums.length > 2, else return error
        
        - initialize sum = 0
        
        - iterate through nums starting from i = 0 to nums.length
        
        - start another loop with j = i+1 
        
        - add nums[i] and nums[j] to sum and check if sum matches target
        
        - if matches return new int array with i+1, j+1 as output
        
        - else if sum < target : remove nums[j] from sum and keep continue with inner loop
        
      //  - else if sum > target  : 
        
        
  
    public int[] twoSum(int[] numbers, int target) { //2,7,11,15, 17 t= 19
        
       int sum = 0;
        
        for(int i = 0; i < numbers.length; i++){ //2
             sum += numbers[i] ;
            for(int j = i+1; j < numbers.length; j++){ // 7 , 11,15 ,17
                sum += numbers[j];// 2+11 //19
                if(sum == target)
                    return new int[] {i+1,j+1};
                else {
                    sum -= numbers[j]; //9-7 =2  13-11 = 2 //17-15 
                    
                }
                
            }
        }
        
        
        throw new RuntimeException("");
    }
      
    */
    
  /*  
    public void test1(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {1,2};
     //   Assert.assertArrayEquals(expected, getIndicesMatchingTargetAsSum(nums,target));
    }

    public void test2(){
        int[] nums = {2,7,11,15};
        int target = 8; //error expected as target doesnt matching
      //  getIndicesMatchingTargetAsSum(nums,target);
    }

    public void test3(){
        int[] nums = {-11,-1,0,2};
        int target = -9;
        int[] expected = {1,4};
      //  Assert.assertArrayEquals(expected, getIndicesMatchingTargetAsSum(nums,target));
    }

    public void test4(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {1,2};
     //   Assert.assertArrayEquals(expected, getIndicesMatchingTargetAsSum(nums,target));
    }
    */
}