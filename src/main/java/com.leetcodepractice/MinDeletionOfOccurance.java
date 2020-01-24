package com.leetcodepractice;

import java.util.*;

public class MinDeletionOfOccurance {
    public static void main(String[] args) {
        System.out.println(new MinDeletionOfOccurance().getNoOfDeletion("aaabbbcccddd"));
    }

    private int getNoOfDeletion(String str) {
        int minDeletion = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character ch : str.toCharArray()){
            countMap.putIfAbsent(ch, 0);
            countMap.put(ch, countMap.get(ch)+1);
        }

        List<Integer> countList = new ArrayList<>();
        countList.addAll(countMap.values());

        Set<Integer> seen = new HashSet<>();
        for (int value : countList) {
            if (!seen.contains(value)){
                seen.add(value);
                continue;
            }
            while (seen.contains(value)) {
                value--;
                minDeletion++;
            }
                if (value != 0) {
                    seen.add(value);
                }
        }
        return minDeletion;
    }
}
