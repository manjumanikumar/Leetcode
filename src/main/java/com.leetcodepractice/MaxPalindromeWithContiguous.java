package com.leetcodepractice;

public class MaxPalindromeWithContiguous {
    public static void main(String[] args) {
        System.out.println(maxPalindrome("aabbaaaabb"));
        System.out.println(maxPalindrome("aabbaabbaabbaa"));
        System.out.println(maxPalindrome("aabbbaabbaabbaa"));
    }

    private static String maxPalindrome(String str) {
        int startIndex=0;
        int length = 0;
        int maxConsecutive = 1;

        int startWindow = 0;
       for (int endWindow = 1; endWindow < str.length(); endWindow++){

           if (str.charAt(endWindow -1) != str.charAt(endWindow)){
               maxConsecutive = 1;
           }
           else if (str.charAt(endWindow - 1) == str.charAt(endWindow)){
               maxConsecutive++;
           }

           if (maxConsecutive == 3){
               maxConsecutive -- ;
               startWindow = endWindow - 1;
           }

           if (endWindow - startWindow+1 > length){
               length = endWindow - startWindow+1;
               startIndex = startWindow;
           }
       }
        return str.substring(startIndex, length);
    }
}
