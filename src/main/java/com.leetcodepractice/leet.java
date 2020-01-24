package com.leetcodepractice;

import java.util.*;

public class leet {

    public static void main(String[] args) {
        System.out.println(new leet().solution("Codility"));
    }

    private String solution(String str) {

        Map<Character, Integer> upperCharcount = new HashMap<>();
        for (int i=0; i < str.length();i++){
            if (Character.isUpperCase(str.charAt(i))){
                upperCharcount.putIfAbsent(str.charAt(i), 0);
            }
        }

        for (int i=0;i<str.length();i++){
            if (Character.isLowerCase(str.charAt(i))){
                Character upperChar = Character.toUpperCase(str.charAt(i));
                if (upperCharcount.containsKey(upperChar)){
                    upperCharcount.put(upperChar, upperCharcount.get(upperChar)+1);
                }
            }
        }

        upperCharcount.values().removeIf(charValue -> charValue == 0);

        List<Character> result = new ArrayList<>(upperCharcount.keySet());
        Collections.sort(result);

        return String.valueOf(result.get(result.size()-1));

    }
}
