package com.leetcodepractice;

import java.util.HashSet;
import java.util.Set;

public class UniqueKSubString {
    public static void main(String[] args) {
        System.out.println(new UniqueKSubString().printSubstring("abcabc", 3));
    }

    public Set<String> printSubstring(String s, int k){

        Set<String> set = new HashSet<>();
        for (int i=0;i<s.length()-k+1;i++){
            StringBuilder sb = new StringBuilder();

            for (int j=i; j<i+k;j++){
                if (sb.indexOf(String.valueOf(s.charAt(j))) != -1) break;
                else
                    sb.append(s.charAt(j));
            }
            if (sb.length() == k)
                set.add(sb.toString());

        }
        return set;
    }
}
