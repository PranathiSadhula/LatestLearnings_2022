package datastructures.week2.day2.assessment;

public class ClassAssessment {
    /**
     * Given a string s and a number k, find the maximum number of vowels in substring of size k.
     * String: "workaattech"
     * k: 3
     *
     * suubStrs :
     *
     *
     *
     */

    /**
     *1st approach :
     *
     * - initialize maxCount = Integer.MinValue.
     *
     * - initialise fIndex = 0 and sIndex = fIndex+1 -k
     *
     * - loop until fIndex < sIndex
     *
     * - check if char at fIndex is vowel.
     *
     *  - if yes --> count++
     *
     *  - using math.max hold onto maxCount or count
     *
     *  - finally return maxCount
     *
     *
     */

    private int maxVowelsInSubStr(String s, int k){
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        int fIndx = 0;
        int sIndx = fIndx+1-k;

        while(fIndx < sIndx){
            if(isCharVowel(s.charAt(fIndx++))) count++;
            else count --;
           // maxCount = Math
        }

        return maxCount;
    }




    private boolean isCharVowel(char c) {

        String vowels = "aeiouAEIOU";
        return vowels.indexOf(c) >= 0 ? true: false;

    }
}
