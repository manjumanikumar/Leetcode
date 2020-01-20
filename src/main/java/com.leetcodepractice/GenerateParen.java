package com.leetcodepractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenerateParen {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        Set<String> res = generateParen(n);
        return new ArrayList<>(res);
    }

    public Set<String> generateParen(int remaining){
        Set<String> set = new HashSet<>();
        if(remaining == 0){
            set.add("");
        }else{
            Set<String> prev = generateParen(remaining - 1);
            for(String str : prev){
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i) == '('){
                        String s = insertBrackets(str, i);
                        set.add(s);
                    }
                }
                set.add("()"+str);
            }
        }
        return set;
    }

    public String insertBrackets(String s, int i){
        String left = s.substring(0,i+1);
        String right = s.substring(i+1, s.length());
        return left + "()" + right;
    }

    public static void main(String[] args) {
        GenerateParen solution = new GenerateParen();
        System.out.println(solution.generateParenthesis(3));
    }
}
