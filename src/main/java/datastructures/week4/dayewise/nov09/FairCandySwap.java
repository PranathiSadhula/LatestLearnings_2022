package datastructures.week4.dayewise.nov09;

import org.junit.Assert;
import org.junit.Test;

public class FairCandySwap {
    /**
     * Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.
     *
     * Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.
     *
     * Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.
     *
     *
     *
     * Example 1:
     *
     * Input: aliceSizes = [1,1], bobSizes = [2,2]
     * Output: [1,2]
     * Example 2:
     *
     * Input: aliceSizes = [1,2], bobSizes = [2,3]
     * Output: [1,2]
     * Example 3:
     *
     * Input: aliceSizes = [2], bobSizes = [1,3]
     * Output: [2,3]
     *
     *
     * Constraints:
     *
     * 1 <= aliceSizes.length, bobSizes.length <= 104
     * 1 <= aliceSizes[i], bobSizes[j] <= 105
     * Alice and Bob have a different total number of candies.
     * There will be at least one valid answer for the given input.
     */

    /**
     * - initialize 2 int variables sumA and sumB to hold respective sum of candies both Alice and Bob have.
     * - iterate through each candyArrays to add sum of all candies.
     * - now, calculate sum formula like sumA - a[i] + b[j] == sumB -b[j] + a[i]
     * - the above formaula gives something like no.of candies both alice(a[i]) and bob(b[j]) to be exchanged
     */

    public int[] fairCandySwap(int[] alice, int[] bob){
        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < alice.length; i++) sumA += alice[i];
        for(int i = 0; i < bob.length; i++) sumB += bob[i];


        for(int aCandiesToExchange = 0; aCandiesToExchange < alice.length; aCandiesToExchange++){
            for(int bCandiesToExchange = 0; bCandiesToExchange < bob.length; bCandiesToExchange++){
                if(sumA - alice[aCandiesToExchange] + bob[bCandiesToExchange] == sumB - bob[bCandiesToExchange] + alice[aCandiesToExchange]){
                    return new int[] {alice[aCandiesToExchange],bob[bCandiesToExchange]};
                }
            }
        }

        return new int[] {};
    }


    @Test
    public void test(){
        int[] a = {1,2};
        int[] b = {2,2};
        Assert.assertArrayEquals(new int[]{}, fairCandySwap(a,b));
    }

    @Test
    public void test1(){
        int[] a = {1,1};
        int[] b = {2,2};
        Assert.assertArrayEquals(new int[]{1,2}, fairCandySwap(a,b));
    }
}

