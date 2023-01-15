package datastructures.week14.jan08;

import org.junit.Test;

public class ContainerWithMostWater {

    @Test
    public void test(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        maxWater(height);
    }

    private int maxWater(int[] height){
        int left = 0, right = height.length - 1;
        int max = 0;
        //time = O[n/2]
        while(left < right)
        {
            int prod = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, prod);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}

