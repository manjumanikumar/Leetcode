package com.leetcodepractice;

import java.util.HashMap;
import java.util.Map;

public class NumberEqualDigit {

    public static void main(String[] args) {
//        int[] arr = new int[]{51,71,17,42};
//        int[] arr1 = new int[]{42,33,60};
//        int[] arr2 = new int[]{51,32,43};
//        System.out.println(getMaxSum(arr));
//        System.out.println(getMaxSum(arr1));
        System.out.println(getMaxSum(5666));
    }

    private static int getMaxSum(int[] arr) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            int addDigitsSum = computeDigitSum(arr[i]);
            if (map.containsKey(addDigitsSum)){
                max = Math.max(max, map.get(addDigitsSum)+arr[i]);
            }
            else{
                map.put(addDigitsSum, arr[i]);
            }
        }

        return max;
    }

    private static int computeDigitSum(int num) {

        int sum = 0;
        int unitPlace = 0;

        while(num != 0){
            unitPlace = num%10;
            sum = sum + unitPlace;
            num = num/10;
        }
       return sum;
    }

    private static int getMaxSum(int num){
        boolean negFlag = false;
        if (num < 0)
            negFlag = true;

        String str = String.valueOf(num);
        for(int i=1; i< str.length(); i++){
           if (negFlag){

           }
            if (str.charAt(i-1) > str.charAt(i)){

            }
        }
        return 0;

    }
}
